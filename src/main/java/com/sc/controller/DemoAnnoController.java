package com.sc.controller;

import com.sc.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by shichong on 2018/8/12
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")//produces可定制返回的response的媒体类型和字符集
    public @ResponseBody String index(HttpServletRequest request){//演示可接受HttpServletRequest作为参数，当然也可以接受HttpServletResponse作为参数，此处@ResponseBody用在返回值前
        return "url:"+request.getRequestURL() +" can access";
    }

    @RequestMapping(value = "/pathvar/{str}",produces = "text/plain;charset=UTF-8")//演示接受路径参数，并在方法前结合@PathVariable,访问路径为/anno/pathvar/xxx
    public @ResponseBody String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access,str:"+ str;
    }

    @RequestMapping(value = "/requestParam",produces = "text/plain;charset=UTF-8")//常规的request参数获取，访问路径为/anno/requestParam?id=1
    public @ResponseBody String passRequestParam(long id,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access ,id:"+id;
    }

    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")//演示解释参数到对象，访问路径为/anno/obj?id=1&name=xx
    @ResponseBody//也可用在方法上
    public String passObj(DemoObj obj,HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access,obj id:"+obj.getId()+"obj name:"+obj.getName()+obj.toString();
    }

    @RequestMapping(value = {"/name1","/name2"},produces = "text/plain;chartset=UTF-8")//演示映射不同的路径到相同的方法上
    public @ResponseBody String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access";
    }


}
