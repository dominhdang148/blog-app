package com.dominhdang.blog_app.features.images.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {
    @Value("${upload.dir}")
    private String uploadDir;

    @Override
    public String saveImage(MultipartFile file) throws IOException {
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);

        Files.write(filePath, file.getBytes());
        return "/uploads/" + fileName;

    }
}
