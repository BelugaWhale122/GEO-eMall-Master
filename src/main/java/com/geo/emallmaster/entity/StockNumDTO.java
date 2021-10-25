package com.geo.emallmaster.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/14
 */

@ApiModel(description = "库存修改所需实体")
@Data
public class StockNumDTO {
    private long goodsId;
    private Integer goodsCount;
}
