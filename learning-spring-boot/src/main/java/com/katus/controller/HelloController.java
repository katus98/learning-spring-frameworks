package com.katus.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * @author SUN Katus
 * @version 1.0, 2020-08-26
 */
//@Controller
//@ResponseBody   // 这个类所有方法的返回值直接写给浏览器 如果是对象则返回json
@RestController   // 替代上面两个注解
public class HelloController {
    @RequestMapping("/hello")
    public String hello(@SessionAttribute("kkk") String kkk) {
        System.out.println(kkk);
        return "Hello world!";
    }

    @RequestMapping("/hello1")
    public String hello2(HttpSession session) {
        session.setAttribute("kkk", "123");
        return "Hello world!";
    }
}
