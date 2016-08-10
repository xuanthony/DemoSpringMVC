package com.controller;

import com.model.UserEntity;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @（#）:MainController
 * @description:
 * @author: xuxb 16/8/2
 * @version: Version 1.0
 */
@Controller
@RequestMapping(value = "main")
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {
        //查询user表中所有的记录
        List<UserEntity> userList = userRepository.findAll();
        //将所有记录传递给要返回的jsp页面，放在userlist中
        modelMap.addAttribute("userList", userList);
        //返回页面
        return "users";
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUser() {
        // 转到 addUser.jsp页面
        return "addUser";
    }

    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
//        userRepository.saveAndFlush(userEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:users";
    }
}
