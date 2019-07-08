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

    public String uploadFile(MultipartFile file, boolean isUser) throws IOException {
        String resultFilename;
        if(file != null && !file.getOriginalFilename().isEmpty()) {
            checkedOrCreateUploadDir();

            String uuidFile = UUID.randomUUID().toString();
            resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));
        }
        else if (!isUser) {
            resultFilename = "1dcad857-3dca-4a86-b8ba-a1bc4e45c109.default_image_post.png";
        }
        else {
            resultFilename = "4754bb2c-b415-4db0-bbbf-62caf9c54ae5.default_image_user.png";
        }
        return resultFilename;
    }

    public String defaulUserImage(){
        return "4754bb2c-b415-4db0-bbbf-62caf9c54ae5.default_image_user.png";
    }
}
