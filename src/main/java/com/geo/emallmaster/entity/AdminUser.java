package com.geo.emallmaster.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "admin_user", indexes = {
        @Index(name = "admin_user_login_admin_name_uindex", columnList = "login_admin_name", unique = true)
})
@Entity
@Data
public class AdminUser {
    @Id
    @Column(name = "admin_user_id", nullable = false)
    private Integer adminUserId;

    @Column(name = "login_admin_name", nullable = false, length = 50)
    private String loginAdminName;

    @Column(name = "login_password", nullable = false, length = 50)
    private String loginPassword;

    @Column(name = "nick_name", nullable = false, length = 50)
    private String nickName;

    @Column(name = "locked", nullable = false)
    private Integer locked;


}