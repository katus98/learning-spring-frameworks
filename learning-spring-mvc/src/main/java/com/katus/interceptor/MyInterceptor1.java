package com.katus.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-30
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * 预处理方法
     * @param request
     * @param response
     * @param handler
     * @return 是否放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1 Pre has been run.");
        // 放行
        return true;
        // 不放行
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
//        return false;
    }

    /**
     * 后处理方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1 Post has been run.");
        // 跳转页面
        //request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    /**
     * 浏览器结果页面执行后处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1 After has been run.");
        // 此方法无法跳转页面
    }
}
