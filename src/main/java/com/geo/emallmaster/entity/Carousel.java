package com.geo.emallmaster.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Table(name = "carousel")
@Entity
@Data
public class Carousel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carousel_id", nullable = false)
    private Integer id;

    @Column(name = "carousel_url", nullable = false, length = 100)
    private String carouselUrl;

    @Column(name = "redirect_url", nullable = false, length = 100)
    private String redirectUrl;

    @Column(name = "carousel_rank", nullable = false)
    private Integer carouselRank;

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