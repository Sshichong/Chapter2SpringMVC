package com.sc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by shichong on 2018/8/19
 * 文件上传控制器
 */
@Controller
public class UploadController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){//MultipartFile接受单个文件上传，MultipartFile[] 接受多个文件上传
        try {
            FileUtils.writeByteArrayToFile(new File("D:upload/"+file.getOriginalFilename())//通过wrtieByteArrayToFile快速写文件到磁盘
            ,file.getBytes());
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }
    }
}
