package com.gym.test.controller;

import com.gym.test.service.FileService;
import com.gym.test.service.impl.FileServiceImpl;
import com.gym.test.util.ResponseEntity;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;

/**
 * @author 高垚淼
 * @version 1.0
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.base-path}")
    String basePath;
    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    public Object img(String md5,@RequestParam("file") MultipartFile file){
        try {
            InputStream inputStream = file.getInputStream();
            String name = System.currentTimeMillis()+"";
            LocalDateTime now = LocalDateTime.now();
            String folderPath = basePath+"/"+now.getYear()+"/"+now.getMonthValue()+"/"+now.getDayOfMonth();
            File file1 = new File(folderPath);
            if(!file1.exists()){
                file1.mkdirs();
            }
            String filePath = folderPath+"/"+name;
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            IOUtils.copy(inputStream,fileOutputStream);
            com.gym.test.pojo.File file2 = new com.gym.test.pojo.File(null, filePath,md5);
            fileService.insert(file2);
            fileOutputStream.close();
            inputStream.close();
            return new ResponseEntity(200,"success",file2.getId());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/img")
    public void img(int id, HttpServletResponse response){
        try {
            com.gym.test.pojo.File file = fileService.selectById(id);
            FileInputStream fileInputStream = new FileInputStream(file.getPath());
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(fileInputStream,outputStream);
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getByMd5")
    public Object getMD5(String md5){
        com.gym.test.pojo.File file = fileService.select(md5);
        if(file == null){
            return new ResponseEntity(400,"fail",null);
        }else{
            return new ResponseEntity(200,"success",file.getId());
        }
    }
}
