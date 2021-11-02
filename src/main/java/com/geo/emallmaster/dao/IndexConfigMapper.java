package com.geo.emallmaster.dao;

import com.geo.emallmaster.entity.IndexConfig;
import com.geo.emallmaster.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/11/02 19:47
 */
@Component
public interface IndexConfigMapper {
    int deleteByPrimaryKey(Long configId);

    int insert(IndexConfig record);

    int insertSelective(IndexConfig record);

    IndexConfig selectByPrimaryKey(Long configId);

    IndexConfig selectByTypeAndGoodsId(@Param("configType") int configType, @Param("goodsId") Long goodsId);

    int updateByPrimaryKeySelective(IndexConfig record);

    int updateByPrimaryKey(IndexConfig record);

    List<IndexConfig> findIndexConfigList(PageQueryUtil pageUtil);

    int getTotalIndexConfigs(PageQueryUtil pageUtil);

    int deleteBatch(Long[] ids);

    List<IndexConfig> findIndexConfigsByTypeAndNum(@Param("configType") int configType, @Param("number") int number);
}
