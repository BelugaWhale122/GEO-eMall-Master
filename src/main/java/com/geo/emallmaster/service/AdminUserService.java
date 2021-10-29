package com.geo.emallmaster.service;

import com.geo.emallmaster.entity.AdminUser;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/28 9:32
 */
public interface AdminUserService {
    AdminUser login(String userName, String password);

    /**
     * 获取用户信息
     *
     * @param loginUserId
     * @return
     */
    AdminUser getUserById(Integer loginUserId);

    /**
     * 修改当前登录用户名称信息
     *
     * @param loginUserId
     * @param loginAdminName
     * @param nickName
     * @return
     */
    Boolean updateName(Integer loginUserId, String loginAdminName, String nickName);

    /**
     * 修改当前登录用户密码
     *
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);
}
