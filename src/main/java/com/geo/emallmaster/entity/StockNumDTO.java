package com.geo.emallmaster.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "库存修改所需实体")
@Data
public class StockNumDTO {
    private long goodsId;
    private Integer goodsCount;
}
