package com.example.demo.web.controller;

/**
 * @author : wangjun
 * @date : 2022/3/7  17:51
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstPage {

    @RequestMapping(value = "/sayHello")
    @ResponseBody
    public String sayHello() {
        return "hello,body";
    }
}
