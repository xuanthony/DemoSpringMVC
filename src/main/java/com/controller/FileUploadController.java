package com.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @（#）:FileUploadController
 * @description:
 * @author: xuxb 16/8/2
 * @version: Version 1.0
 */
@Controller
@RequestMapping(value = "/file")
public class FileUploadController {

    Logger logger = Logger.getLogger(FileUploadController.class);

    @RequestMapping(value = "/uploadJSP", method = RequestMethod.GET)
    public String fileUpload() {
        return "file/upload";
    }

    @RequestMapping(value = "/upload")
    public String addFiles(@RequestParam("file")CommonsMultipartFile[] files, HttpServletRequest request) {

        for(int i=0; i<files.length; i++) {
            logger.info("filename =======" + files[i].getOriginalFilename());
        }

        return "success";
    }

    @RequestMapping(value = "/upload2")
    public String addFiles2(HttpServletRequest request,HttpServletResponse response) throws IOException {

        //创建一个通用的多部分解析器
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;
            //取得request中的所有文件名
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                //记录上传过程起始时的时间，用来计算上传时间
                int pre = (int) System.currentTimeMillis();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                if(file != null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为“”,说明该文件存在，否则说明该文件不存在
                    if(myFileName.trim().length() > 0){
                        logger.info(" info======= file name is " + myFileName);
                        //重命名上传后的文件名
                        String fileName = "demoUpload" + file.getOriginalFilename();
                        //定义上传路径
                        String path = "F:/" + fileName;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                    }
                }
                //记录上传该文件后的时间
                int finaltime = (int) System.currentTimeMillis();
                logger.info(" info======= time is " + (finaltime - pre));
                logger.debug(" debug======= time is " + (finaltime - pre));
                logger.error(" error======= time is " + (finaltime - pre));
            }

        }

        return "success";
    }
}
