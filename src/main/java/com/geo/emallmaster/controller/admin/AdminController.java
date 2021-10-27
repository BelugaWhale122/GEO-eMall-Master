package com.geo.emallmaster.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/15 9:13
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/indexAll")
    public String indexAll(){
        return "admin/index-all";
    }

    @GetMapping("/index")
    public String index(){
        return "admin/index";
    }
}
