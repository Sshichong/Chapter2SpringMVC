package com.sc.config;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by shichong on 2018/8/14
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {//继承HandlerInterceptAdapter来自定义拦截器

    /**
     * 重写方法，在请求发生前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime",startTime);
        return true;

    }

    /**
     * 重写方法，在请求完成后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime = (Long)request.getAttribute("startTime");
        long endTime =System.currentTimeMillis();
        System.out.println("本次请求处理时间为："+new Long(endTime -startTime) +"ms");
        request.setAttribute("handingTime",endTime -startTime);
    }
}
