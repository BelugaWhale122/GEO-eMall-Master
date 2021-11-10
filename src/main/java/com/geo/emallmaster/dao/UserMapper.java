package com.geo.emallmaster.dao;

import com.geo.emallmaster.entity.User;
import com.geo.emallmaster.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 23:20
 */
@Component
public interface UserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    User selectByLoginName(String loginName);

    User selectByLoginNameAndPasswd(@Param("loginName") String loginName, @Param("password") String password);

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

    /**
     * 批量禁用/解禁用户
     *
     * @param ids
     * @param lockStatus
     * @return
     */
    int lockUserBatch(@Param("ids") Integer[] ids, @Param("lockStatus") int lockStatus);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
