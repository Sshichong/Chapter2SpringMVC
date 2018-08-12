package com.sc.controller;

import com.sc.model.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shichong on 2018/8/12
 */
@RestController//返回数据时不需要ResponseBody
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",produces = {"application/json;charset=UTF-8"})//返回数据媒体类型为json
    public DemoObj getjson(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");//直接返回对象，对象会自动转换成json
    }

    @RequestMapping(value = "/getxml",produces = {"application/xml;charset=UTF-8"})//返回数据媒体类型为xml
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"yy");//直接返回对象，对象会自动转换为xml
    }
}
