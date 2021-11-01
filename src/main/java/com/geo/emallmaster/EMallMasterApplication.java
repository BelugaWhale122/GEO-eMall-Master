package com.geo.emallmaster;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/14
 */

@SpringBootApplication
@MapperScan("com.geo.emallmaster.dao")
public class EMallMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EMallMasterApplication.class, args);
    }
}
