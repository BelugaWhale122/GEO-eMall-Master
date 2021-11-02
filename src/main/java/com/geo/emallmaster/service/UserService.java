package com.geo.emallmaster.service;

import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

import javax.servlet.http.HttpSession;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 22:53
 */
public interface UserService {

    /**
     * 后台分页
     *
     * @param pageQueryUtil
     * @return
     */
    PageResult getUserPage(PageQueryUtil pageQueryUtil);

    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockUser(Integer[] ids, int lockStatus);

    /**
     * 注册
     * @param loginName
     * @param password
     * @return
     */
    String register(String loginName, String password);

    /**
     * 登录
     * @param loginName
     * @param passwordMD5
     * @param httpSession
     * @return
     */
    String login(String loginName, String passwordMD5, HttpSession httpSession);

}
