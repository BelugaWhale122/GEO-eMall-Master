package com.geo.emallmaster.controller.admin;

import com.geo.emallmaster.service.UserService;
import com.geo.emallmaster.utils.PageQueryUtil;
import com.geo.emallmaster.utils.Result;
import com.geo.emallmaster.utils.ResultGenerator;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 23:42
 */
@Controller
@RequestMapping("/admin")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/users")
    public String userPage(HttpServletRequest request) {
        request.setAttribute("path", "users");
        return "admin/user";
    }

    /**
     * 用户列表
     */
    @RequestMapping(value = "/users/list", method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> parms) {
        if (StringUtils.isEmpty(parms.get("page")) || StringUtils.isEmpty(parms.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(parms);
        return ResultGenerator.genSuccessResult(userService.getUserPage(pageUtil));
    }

    /**
     * 用户禁用与解除禁用(0-未锁定 1-已锁定)
     */
    @RequestMapping(value = "/users/lock/{lockStatus}", method = RequestMethod.POST)
    @ResponseBody
    public Result lockUsers(@RequestBody Integer[] ids, @PathVariable int lockStatus) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (lockStatus != 0 && lockStatus != 1) {
            return ResultGenerator.genFailResult("非法操作");
        }
        if (userService.lockUser(ids, lockStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("操作失败!");
        }
    }
}
