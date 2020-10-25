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
     * @param : file
     * @param : fileExtName
     * @return :
     * @throws :
     * @Description ：上传文件
     * @author : myf
     * @date : 2020/10/25 19:05
     */
    public String upload(MultipartFile file, String fileExtName) throws Exception;

    /**
     * @param : file,userId
     * @return :
     * @throws :
     * @Description ：使用oss上传文件
     * @author : myf
     * @date : 2020/10/25 20:19
     */
    public String uploadOSS(MultipartFile file, String userId, String fileExtName) throws Exception;
}
