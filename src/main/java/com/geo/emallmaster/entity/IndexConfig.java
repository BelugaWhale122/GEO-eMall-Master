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

@Table(name = "index_config")
@Entity
@Data
public class IndexConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "config_id", nullable = false)
    private Long configId;

    @Column(name = "config_name", nullable = false, length = 50)
    private String configName;

    @Column(name = "config_type", nullable = false)
    private Integer configType;

    @Column(name = "goods_id", nullable = false)
    private Long goodsId;

    @Column(name = "redirect_url", nullable = false, length = 100)
    private String redirectUrl;

    @Column(name = "config_rank", nullable = false)
    private Integer configRank;

    @Column(name = "is_deleted", nullable = false)
    private Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "create_user", nullable = false)
    private Integer createUser;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    @Column(name = "update_user", nullable = false)
    private Integer updateUser;

}