package com.sc.controller;

import com.sc.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by shichong on 2018/8/25
 */
@Controller
public class ConverterController {

    @RequestMapping(value = "/convert",produces = {"application/x-wisely"})//返回媒体类型为我们自定义的媒体类型
    public @ResponseBody DemoObj convert (@RequestBody DemoObj demoObj){
        return demoObj;
    }
}
