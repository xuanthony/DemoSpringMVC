package com.controller;

import com.model.BlogEntity;
import com.model.UserEntity;
import com.repository.BlogRepository;
import com.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @（#）:BlogController
 * @description:
 * @author: xuxb 16/8/2
 * @version: Version 1.0
 */
@Controller
@RequestMapping(value = "/blog")
public class BlogController {

    private Logger logger = Logger.getLogger(BlogController.class);

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    //查看所有博文
    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap) {
        List<BlogEntity> blogList = blogRepository.findAll();
        modelMap.addAttribute("blogList", blogList);
        return "blogs";
    }

    //添加博文
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBlog(ModelMap modelMap) {
        List<UserEntity> userList = userRepository.findAll();
        //向jsp注入用户列表
        modelMap.addAttribute("userList", userList);

        return "addBlog";
    }

    //添加博文，POST请求，重定向为查看博客页面
    @RequestMapping(value = "addP", method = RequestMethod.POST)
    public String addBlogPost(@ModelAttribute("blog") BlogEntity blogEntity) {
        logger.info(blogEntity.getTitle()+" info");
        logger.debug(blogEntity.getTitle()+" debug");
        logger.error(blogEntity.getTitle()+" error");
        logger.info(blogEntity.getUserByUserId().getNickname()+" info");
        logger.debug(blogEntity.getUserByUserId().getNickname()+" debug");
        logger.error(blogEntity.getUserByUserId().getNickname()+" error");

        blogRepository.saveAndFlush(blogEntity);
        return "redirect:blogs";
    }
}
