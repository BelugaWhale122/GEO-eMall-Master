package com.geo.emallmaster.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 分页查询参数
 *
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 23:01
 */
@Setter
@Getter
@ToString
public class PageQueryUtil extends LinkedHashMap<String, Object> {
    //当前页码
    private int page;
    //每页条数
    private int limit;

    public PageQueryUtil(Map<String, Object> parms) {
        this.putAll(parms);

        //分页参数
        this.page = Integer.parseInt(parms.get("page").toString());
        this.limit = Integer.parseInt(parms.get("limit").toString());
        this.put("start", (page - 1) * limit);
        this.put("page", page);
        this.put("limit", limit);
    }
}
