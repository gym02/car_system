package com.gym.test.service;

import com.gym.test.pojo.File;

/**
 * @author 高垚淼
 * @version 1.0
 */
public interface FileService {
    public void insert(File file);

    File select(String md5);

    File selectById(int fileId);
}
