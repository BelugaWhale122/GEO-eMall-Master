package com.geo.emallmaster.service.impl;

import com.geo.emallmaster.dao.UserMapper;
import com.geo.emallmaster.entity.User;
import com.geo.emallmaster.service.UserService;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
