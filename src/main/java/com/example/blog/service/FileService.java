package com.example.blog.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileService {

    @Value("${upload.path}")
    private String uploadPath;

    private void checkedOrCreateUploadDir(){
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()){
            uploadDir.mkdir();
        }
    }

    public String uploadFile(MultipartFile file) throws IOException {
        if(file != null && !file.getOriginalFilename().isEmpty()){
            checkedOrCreateUploadDir();
        }

        String uuidFile = UUID.randomUUID().toString();
        String resultFilename = uuidFile + "." + file.getOriginalFilename();

        file.transferTo(new File(uploadPath + "/" + resultFilename));

        return resultFilename;
    }
}
