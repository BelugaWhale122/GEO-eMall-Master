package com.geo.emallmaster.service;

import com.geo.emallmaster.entity.AdminUser;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/28 9:32
 */
public interface AdminUserService {
    AdminUser login(String userName, String password);
}
