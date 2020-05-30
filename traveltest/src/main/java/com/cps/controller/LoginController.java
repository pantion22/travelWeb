package com.cps.controller;

import com.cps.pojo.User;
import com.cps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String, Object> map,
                        HttpSession session){
        User user = userService.find(username,password);
        if (user != null) {
            session.setAttribute("user",user);
            // 旅游景点管理页
            return "redirect:/admin";
        }else {
            // 登录失败 返回登录页
            map.put("msg", "账号或密码错误");
            return "login";
        }
    }

    // 注销当前账号
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index";
    }

    // 去修改密码页面
    @GetMapping("/admin/modify")
    public String toModify(){
        return "admin/modify";
    }

    //提交修改密码
    @PostMapping("/admin/modify/{id}")
    public String modify(@PathVariable("id") Integer id
            ,@RequestParam String password){
        userService.update(id, password);

        //修改完密码 重新登录
        return "redirect:/login";
    }

}
