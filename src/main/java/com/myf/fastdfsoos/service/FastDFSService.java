package com.myf.fastdfsoos.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : myf
 * @Date : 2020/10/25 19:00
 * @Description : FastDFS文件操作
 * @Version : 1.0
 */
public interface FastDFSService {

    /**
     * @Description ：上传文件
     * @author : myf
     * @param : file
     * @param : fileExtName
     * @return :
     * @exception :
     * @date : 2020/10/25 19:05
     */
    public String upload(MultipartFile file, String fileExtName) throws Exception;
}
