package com.sc.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by shichong on 2018/8/25
 */
@Service
public class PushService {
    private DeferredResult<String> deferredResult; //产生DeferredResult给控制器使用，通过@Scheduled注解的方法定时更新DeferredResult

    public DeferredResult<String> getAsyncUpdate(){
        deferredResult = new DeferredResult<String>();
        return deferredResult;
    }

    @Scheduled(fixedDelay = 1000)
    public void refresh(){
        if (deferredResult!=null){
            deferredResult.setResult(new Long(System.currentTimeMillis()).toString());
        }
    }
}
