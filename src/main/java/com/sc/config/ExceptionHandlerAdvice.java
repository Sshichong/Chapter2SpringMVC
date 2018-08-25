package com.sc.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by shichong on 2018/8/15
 * 定制ControllerAdvice
 * 没成功
 *
 * @ExceptionHandler， 处理全局处理控制力器里的异常
 * @InitBinder 用来设置WebDataBinder，用来自动绑定前台请求参数到model中
 * @ModelAttribute 本来的作用是绑定键值对到Model中，此处是让全局的@RequestMapping都能获得在此处设置的键值对
 *
 */
@ControllerAdvice//声明一个控制器建言，组合了component注解，所以自动注册为spring的bean
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = Exception.class)//此处定义全局处理，value可过滤拦截条件，此处是拦截所有的exception
    public ModelAndView exception(Exception exception, WebRequest request){
        ModelAndView modelAndView =new ModelAndView("error");//error页面
        modelAndView.addObject("errorMessage",exception.getMessage());
        return modelAndView;
    }

    @ModelAttribute
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");//将键值对添加到全局，所注解RequestMapping的方法可获得此键值对
    }

    @InitBinder//定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");//此处忽略request参数的id
    }
}
