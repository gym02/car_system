package com.gym.test.service.impl;

import com.gym.test.mapper.FileMapper;
import com.gym.test.pojo.File;
import com.gym.test.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 高垚淼
 * @version 1.0
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileMapper fileMapper;

    @Override
    public void insert(File file) {
        fileMapper.insert(file);
    }

    @Override
    public File select(String md5) {
        return fileMapper.select(md5);
    }

    @Override
    public File selectById(int fileId) {
        return fileMapper.getById(fileId);
    }
}
