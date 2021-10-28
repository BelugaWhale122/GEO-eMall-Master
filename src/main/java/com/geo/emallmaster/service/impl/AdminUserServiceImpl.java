package com.geo.emallmaster.service.impl;

import com.geo.emallmaster.dao.AdminUserMapper;
import com.geo.emallmaster.entity.AdminUser;
import com.geo.emallmaster.service.AdminUserService;
import com.geo.emallmaster.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/28 9:36
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }
}
