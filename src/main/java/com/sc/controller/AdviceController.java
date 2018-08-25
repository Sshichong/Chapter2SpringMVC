package com.sc.controller;

import com.sc.model.DemoObj;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shichong on 2018/8/15
 * 报错未成功
 */
@RestController
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg")String msg, DemoObj obj){
//        return msg;
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute："+ msg);
//        return "error";
    }
}
