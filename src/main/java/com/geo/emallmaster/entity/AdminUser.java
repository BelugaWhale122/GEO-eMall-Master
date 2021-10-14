package com.geo.emallmaster.entity;

import javax.persistence.*;

@Table(name = "admin_user", indexes = {
        @Index(name = "admin_user_login_admin_name_uindex", columnList = "login_admin_name", unique = true)
})
@Entity
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

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getLoginAdminName() {
        return loginAdminName;
    }

    public void setLoginAdminName(String loginAdminName) {
        this.loginAdminName = loginAdminName;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }
}