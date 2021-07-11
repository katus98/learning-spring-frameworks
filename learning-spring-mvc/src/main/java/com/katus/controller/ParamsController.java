package com.katus.controller;

import com.katus.domain.Account;
import com.katus.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 请求参数绑定测试
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-29
 */
@Controller
@RequestMapping("/params")
public class ParamsController {
    @RequestMapping("/testParams1")
    public String testParams1(String name, String password) {
        System.out.println("Run...");
        System.out.println("name: " + name + "\n" + "password: " + password);
        return "success";
    }

    @RequestMapping("/saveAccount")
    public String testAccount(Account account) {
        System.out.println(account);
        return "success";
    }

    @RequestMapping("/saveUser")
    public String testUser(User user) {
        System.out.println(user);
        return "success";
    }
}
