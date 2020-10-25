package com.myf.fastdfsoos.controller;

import com.myf.fastdfsoos.service.FastDFSService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : myf
 * @Date : 2020/10/25 19:08
 * @Description : 用户图片
 * @Version : 1.0
 */
@RestController
@RequestMapping("fdfs")
public class UserImageController {
    @Autowired
    private FastDFSService dfsService;
    @PostMapping("")
    public String uploadFace (
            String userId, MultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception{

        String path = null;

        if (file!=null){
            // 获得文件上传的文件名称
            String filename = file.getOriginalFilename();
            if(StringUtils.isNotBlank(filename)){
                // 文件重名
                String fileNameArr[] = filename.split("\\.");
                // 获取文件的后缀名
                String suffix = fileNameArr[fileNameArr.length - 1];

                if (!suffix.equalsIgnoreCase("png")&&
                !suffix.equalsIgnoreCase("jpg")&&
                !suffix.equalsIgnoreCase("jpeg")){
                    return "图片格式不正确";
                }

                path = dfsService.upload(file, suffix);
                System.out.println("upload = " + path);

            }
        }else {
            return "文件不能为空！";
        }

        if (!StringUtils.isNotBlank(path)){
            return "文件上传失败！";
        }
        //TODO 将文件地址存储进数据库

        return "文件上传成功！";
    }
}
