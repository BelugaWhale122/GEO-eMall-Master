package com.geo.emallmaster.service.impl;

import com.geo.emallmaster.common.Constants;
import com.geo.emallmaster.common.ServiceResultEnum;
import com.geo.emallmaster.controller.vo.UserVO;
import com.geo.emallmaster.dao.UserMapper;
import com.geo.emallmaster.entity.User;
import com.geo.emallmaster.service.UserService;
import com.geo.emallmaster.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 23:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult getUserPage(PageQueryUtil pageQueryUtil) {
        List<User> users = userMapper.findUserList(pageQueryUtil);
        int total = userMapper.getTotalUser(pageQueryUtil);
        PageResult pageResult = new PageResult(total, pageQueryUtil.getLimit(), pageQueryUtil.getPage(), users);
        return pageResult;
    }

    @Override
    public Boolean lockUser(Integer[] ids, int lockStatus) {
        if (ids.length < 1) {
            return false;
        }
        return userMapper.lockUserBatch(ids, lockStatus) > 0;
    }

    @Override
    public String register(String loginName, String password) {
        if (userMapper.selectByLoginName(loginName) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        User registerUser = new User();
        registerUser.setLoginName(loginName);
        registerUser.setNickName(loginName);
        String passwordMD5 = MD5Util.MD5Encode(password, "UTF-8");
        registerUser.setPasswordMd5(passwordMD5);
        if (userMapper.insertSelective(registerUser) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String login(String loginName, String passwordMD5, HttpSession httpSession) {
        User user = userMapper.selectByLoginNameAndPasswd(loginName, passwordMD5);
        if (user != null && httpSession != null) {
            if (user.getLockedFlag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED.getResult();
            }
            //昵称太长 影响页面展示
            if (user.getNickName() != null && user.getNickName().length() > 7) {
                String tempNickName = user.getNickName().substring(0, 7) + "..";
                user.setNickName(tempNickName);
            }
            UserVO userVO = new UserVO();
            BeanUtil.copyProperties(user, userVO);
            //设置购物车中的数量
            httpSession.setAttribute(Constants.USER_SESSION_KEY, userVO);
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    @Override
    public UserVO updateUserInfo(User user, HttpSession httpSession) {
        UserVO userTemp = (UserVO) httpSession.getAttribute(Constants.USER_SESSION_KEY);
        User userFromDB = userMapper.selectByPrimaryKey(userTemp.getUserId());
        if (userFromDB != null) {
            if (!StringUtils.isEmpty(user.getNickName())) {
                userFromDB.setNickName(MallUtils.cleanString(user.getNickName()));
            }
            if (!StringUtils.isEmpty(user.getAddress())) {
                userFromDB.setAddress(MallUtils.cleanString(user.getAddress()));
            }
            if (!StringUtils.isEmpty(user.getIntroduceSign())) {
                userFromDB.setIntroduceSign(MallUtils.cleanString(user.getIntroduceSign()));
            }
            if (userMapper.updateByPrimaryKeySelective(userFromDB) > 0) {
                UserVO userVO = new UserVO();
                userFromDB = userMapper.selectByPrimaryKey(user.getUserId());
                BeanUtil.copyProperties(userFromDB, userVO);
                httpSession.setAttribute(Constants.USER_SESSION_KEY, userVO);
                return userVO;
            }
        }
        return null;
    }
}
