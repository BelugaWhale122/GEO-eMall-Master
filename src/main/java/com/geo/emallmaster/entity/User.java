package com.geo.emallmaster.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/14
 */

@Table(name = "user", indexes = {
        @Index(name = "user_login_name_uindex", columnList = "login_name", unique = true)
}, uniqueConstraints = {
        @UniqueConstraint(name = "user_user_id_uindex", columnNames = {"user_id"})
})
@Entity
@Data
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

}