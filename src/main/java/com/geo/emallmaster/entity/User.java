package com.geo.emallmaster.entity;

import javax.persistence.*;

@Table(name = "user", indexes = {
        @Index(name = "user_login_name_uindex", columnList = "login_name", unique = true)
}, uniqueConstraints = {
        @UniqueConstraint(name = "user_user_id_uindex", columnNames = {"user_id"})
})
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "nick_name", nullable = false, length = 50)
    private String nickName;

    @Column(name = "login_name", nullable = false, length = 11)
    private String loginName;

    @Column(name = "password_md5", nullable = false, length = 32)
    private String passwordMd5;

    @Column(name = "introduce_sign", length = 100)
    private String introduceSign;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "is_deleted", nullable = false)
    private Integer isDeleted;

    @Column(name = "locked_flag", nullable = false)
    private Integer lockedFlag;

    public Integer getLockedFlag() {
        return lockedFlag;
    }

    public void setLockedFlag(Integer lockedFlag) {
        this.lockedFlag = lockedFlag;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduceSign() {
        return introduceSign;
    }

    public void setIntroduceSign(String introduceSign) {
        this.introduceSign = introduceSign;
    }

    public String getPasswordMd5() {
        return passwordMd5;
    }

    public void setPasswordMd5(String passwordMd5) {
        this.passwordMd5 = passwordMd5;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}