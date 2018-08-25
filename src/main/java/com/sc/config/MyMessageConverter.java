package com.sc.config;

import com.sc.model.DemoObj;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by shichong on 2018/8/19
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<DemoObj> {//继承AbstractHttpMessageConverter接口实现自定义HttpMessageConverter

    public MyMessageConverter() {
        super(new MediaType("application","x-wisely",Charset.forName("UTF-8")));//仙剑一个自定义媒体类型 application/x-wisely
    }

    /**
     * 重写readIntenal方法，处理请求数据，代表表明我们处理由“-”隔开的数据，并转成DemoObj的对象
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected DemoObj readInternal(Class<? extends DemoObj> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(),
                Charset.forName("UTF-8"));
        String[] tempArr =temp.split("-");
        return new DemoObj(new Long(tempArr[0]),tempArr[1]);
    }

    /**
     * 只处理DemoObj这个类
     * @param aClass
     * @return
     */
    @Override
    protected boolean supports(Class<?> aClass) {
        return DemoObj.class.isAssignableFrom(aClass);
    }

    /**
     * 重写writeInternal方法，处理如何输出数据到response。
     * @param obj
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(DemoObj obj, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        String out = "hello:"+obj.getId()+"-"+obj.getName();
        httpOutputMessage.getBody().write(out.getBytes());
    }


}
