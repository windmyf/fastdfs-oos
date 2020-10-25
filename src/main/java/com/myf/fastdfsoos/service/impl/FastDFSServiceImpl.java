package com.myf.fastdfsoos.service.impl;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.myf.fastdfsoos.service.FastDFSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author : myf
 * @Date : 2020/10/25 19:00
 * @Description : FastDFS文件操作
 * @Version : 1.0
 */
@Service
public class FastDFSServiceImpl implements FastDFSService {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Override
    public String upload(MultipartFile file,String fileExtName) throws Exception {

        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(),
                file.getSize(), fileExtName, null);
        String path = storePath.getFullPath();

        return path;
    }
}
