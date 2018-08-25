package com.sc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by shichong on 2018/8/11
 * web配置
 */
public class WebInitializer implements WebApplicationInitializer {//WebApplicationInitializer是spring提供用来配置servlet3.0的接口。
                                                                    //从而实现代替web.xml位置。
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context =new
                AnnotationConfigWebApplicationContext();

        context.register(MyMvcConfig.class);
        context.setServletContext(servletContext);//新建webApplicationcontext，注册配置类，并和其当前servletContext关联


        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher",new
                DispatcherServlet(context));//注册SpringMVC的DispatcherServlet
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setAsyncSupported(true);//开启异步方法支持
    }


}
