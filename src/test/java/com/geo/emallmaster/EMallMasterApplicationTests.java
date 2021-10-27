package com.geo.emallmaster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class EMallMasterApplicationTests {

    // 注入数据源对象
    @Autowired
    DataSource defaultDateSource;

    @Test
    void datasourceTest() throws SQLException {
        // 获取数据库连接对象
        Connection connection = defaultDateSource.getConnection();
        System.out.println("get connection...");
        System.out.println(connection != null);
        System.out.println(defaultDateSource.getClass());
        connection.close();
    }

    @Test
    void contextLoads() {
    }

}
