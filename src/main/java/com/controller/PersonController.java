package com.controller;

import com.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "person")
public class PersonController {

    /**
     * 登录
     * @param person 用户对象
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    @ResponseBody
    public Person login(@RequestBody Person person) {
        return person;
    }
}
