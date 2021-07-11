package com.katus.controller;

import com.katus.domain.User2;
import com.katus.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-30
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("Test String...");
        model.addAttribute("user2", new User2("Sun", "123456", 33));
        return "success";
    }

    @RequestMapping("/testVoid")// 如果没有返回值默认情况下跳转到/testVoid下 如果没有相应页面就会404
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Test Void...");
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);   //手动配置跳转 完整路径
        //response.sendRedirect(request.getContextPath() + "/redirect.jsp");   // 手动配置重定向 不能是WEB-INF中的路径

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        response.getWriter().println("你好");
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("Test ModelAndView...");
        ModelAndView mv = new ModelAndView();
        // 将数据存储到mv对象中 也会将其存储到request对象中
        mv.addObject("user2", new User2("SunK", "12456", 23));
        // 设置跳转视图的名称
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect() {   // 通过关键字执行转发和重定向
        System.out.println("Test ForwardOrRedirect...");
        // 执行转发
        // return "forward:/WEB-INF/pages/success.jsp";
        // 执行重定向
        return "redirect:/redirect.jsp";
    }

    @RequestMapping("/testAjax")
    public void testAjax(@RequestBody String body) {
        System.out.println("Test Ajax...");
        System.out.println(body);
    }

    @RequestMapping("/testAjax2")
    public @ResponseBody User2 testAjax2(@RequestBody User2 user2) {   // 需要jackson-databind依赖 自动进行数据装配
        System.out.println("Test Ajax2...");
        System.out.println(user2);
        user2.setUsername(user2.getUsername() + "_Changed");
        return user2;
    }

    @RequestMapping("/testException")
    public String testException() throws MyException {
        System.out.println("Test Exception...");
        try {
            int x = 1 / 0;   // 此处有异常
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException("不合法的数学运算1");
        }
        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor() {
        System.out.println("Test Interceptor...");
        return "success";
    }
}
