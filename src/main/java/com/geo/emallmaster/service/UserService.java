package com.geo.emallmaster.service;

import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.PageResult;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 22:53
 */
public interface UserService {
    PageResult getUserPage(PageQueryUtil pageQueryUtil);
}
