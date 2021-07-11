package com.katus.controller;

import com.katus.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解测试
 * @author SUN Katus
 * @version 1.0, 2020-08-29
 */
@Controller
@RequestMapping("/an")
@SessionAttributes(value = {"msg"})   // 将msg信息存入session域对象中 用于数据共享
public class AnnotationController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String sth) {   // 解决前端name与后台参数名不一致的问题
        System.out.println(sth);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {   // 获取请求体
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String number) {   // 上下id处需要保持一致 获取URL占位参数值
        System.out.println(number);
        return "success";
    }

    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(value = "Accept") String header) {   // 获取指定头信息
        System.out.println(header);
        return "success";
    }

    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String value) {   // 获取指定cookie值
        System.out.println(value);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute(value = "key") User user) {   // 获取已经设置好默认值的User对象 通过key找到
        System.out.println(user);
        System.out.println("testModelAttribute() has been run.");
        return "success";
    }

    // 无返回值情况 调用本类任意方法时都会提前调用本方法
    @ModelAttribute   // 会使修饰的方法提前执行 类似将接收到的数值先设置默认值 以防止空值的产生 返回值会返回给对应的映射方法
    private void defaultSth2(String name, Map<String, User> map) {   // 设置User对象的默认值
        // 模拟查询数据库
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        map.put("key", user);   // key值为设定的映射关系
        System.out.println("defaultSth2() has been run.");
    }

    // 有返回值情况 调用本类任意方法时都会提前调用本方法
//    @ModelAttribute   // 会使修饰的方法提前执行 类似将接收到的数值先设置默认值 以防止空值的产生 返回值会返回给对应的映射方法
//    private User defaultSth1(String name) {   // 设置User对象的默认值
//        // 模拟查询数据库
//        User user = new User();
//        user.setName(name);
//        user.setAge(20);
//        user.setDate(new Date());
//        System.out.println("defaultSth1() has been run.");
//        return user;
//    }

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model) {   // 获取指定cookie值
        // 底层会将其存储到request域对象中
        model.addAttribute("msg", "The message is missing!");
        return "success";
    }

    @RequestMapping("/getSharedMsg")
    public String getSharedMsg(ModelMap modelMap) {
        System.out.println(modelMap.get("msg"));   // 可以进行其他的map增删改操作
        return "success";
    }

    @RequestMapping("/delAll")
    public String delAll(SessionStatus sessionStatus) {
        sessionStatus.setComplete();   // 清空session内容
        return "success";
    }
}
