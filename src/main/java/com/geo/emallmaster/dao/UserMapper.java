package com.geo.emallmaster.dao;

import com.geo.emallmaster.entity.User;
import com.geo.emallmaster.utils.PageQueryUtil;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 23:20
 */
@Component
public interface UserMapper {

    /**
     * 根据参数查询用户列表
     *
     * @param pageQueryUtil
     * @return
     */
    List<User> findUserList(PageQueryUtil pageQueryUtil);

    /**
     * 查询总用户数
     *
     * @param pageQueryUtil
     * @return
     */
    int getTotalUser(PageQueryUtil pageQueryUtil);
}
