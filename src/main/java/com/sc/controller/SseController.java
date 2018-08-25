package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by shichong on 2018/8/25
 * 服务端推送技术，SSE
 * 基于：当客户端向服务端发送一个请求，服务端会抓住这个不放，等有数据更新的时候才返回给客户端，当客户端接收到消息后，再向服务端发送请求，周而复始
 * 好处：减少服务器的请求数量，大大减少服务器的压力
 *
 * SSE(Server Send Event服务端发送事件)需要新的浏览器支持Chrome，Firefox
 * Servlet3.0+的异步特性，跨浏览器
 */
@Controller
public class SseController {
    @RequestMapping(value = "/push",produces = "text/event-stream")//输出媒体类型，是服务器端sse的支持，显示每5s想浏览器推送随机消息
    public @ResponseBody String push(){
        Random r =new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Test 1,2,3"+r.nextInt()+"\n\n";
    }
}
