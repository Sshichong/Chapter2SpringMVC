package com.sc.controller;

import com.sc.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by shichong on 2018/8/25
 * 报错，servlet.init()，Controller的问题
 */
//@Controller
public class AysncController1 {

    @Autowired
    PushService pushService;//定时任务，定时更新DeferredResult

    @RequestMapping("/deferr")
    @ResponseBody
    public DeferredResult<String> deferredCall(){//返回给客户端DeferredResult
        return pushService.getAsyncUpdate();
    }
}