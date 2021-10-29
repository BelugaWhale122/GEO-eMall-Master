package com.geo.emallmaster.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Xu
 * @version 1.0
 * @date 2021/10/29 8:22
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("进入拦截器....");
        String servletPath = request.getServletPath();
        if (servletPath.startsWith("/admin") && request.getSession().getAttribute("loginUser") == null) {
            request.getSession().setAttribute("errorMsg", "请登录");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            System.out.println("拦截成功！");
            return false;
        } else {
            request.getSession().removeAttribute("errorMsg");
            System.out.println("拦截器放行..");
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }
}
