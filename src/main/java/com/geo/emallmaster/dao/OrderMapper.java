package com.geo.emallmaster.dao;

import com.geo.emallmaster.entity.Order;
import org.springframework.stereotype.Component;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/08 8:53
 */
@Component
public interface OrderMapper {

    int insert(Order record);

    int insertSelective(Order record);
}
