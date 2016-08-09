package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller")
public class HelloMvcController {

    @RequestMapping(value = "hello")
    public String helloMvc() {
//        try {
//            Class<?> clas = Class.forName("");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        System.out.println("");
        return "hello";
    }
}
