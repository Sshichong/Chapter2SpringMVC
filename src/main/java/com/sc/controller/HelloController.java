package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shichong on 2018/8/11
 */
@Controller
public class HelloController {

    @RequestMapping("index")
    public String hello(){
        return "index";
    }
}
