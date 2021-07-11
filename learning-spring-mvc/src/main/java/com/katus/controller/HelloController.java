package com.katus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 快速入门测试
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-29
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/hello")   // 请求路径是叠加的
    public String sayHello() {
        System.out.println("Hello SpringMVC!");
        return "success";
    }

    // 要求必须通过POST或者GET方法请求 请求中必须有username参数 (也可以username=katus 限制必须传入katus) 要求有Accept请求头
    @RequestMapping(value = "/test", method = {RequestMethod.GET, RequestMethod.POST}, params = {"username"}, headers = {"Accept"})
    public String test() {
        System.out.println("Test Mapping...");
        return "success";
    }

    @RequestMapping("/testServlet")
    public String testS(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Test Servlet...");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        System.out.println(session.getServletContext());
        System.out.println(response);
        return "success";
    }
}
