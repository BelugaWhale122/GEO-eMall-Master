package com.geo.emallmaster.dao;

import com.geo.emallmaster.entity.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/28 8:46
 */
public interface AdminUserMapper {
    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    /**
     * 登录方法
     *
     * @param userName
     * @param password
     * @return
     */
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser selectByPrimaryKey(Integer adminUserId);

    int updateByPrimaryKey(AdminUser record);

    int updateByPrimaryKeySelective(AdminUser record);
}
