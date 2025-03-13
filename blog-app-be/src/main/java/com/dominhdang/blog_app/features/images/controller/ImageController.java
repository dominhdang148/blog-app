package com.dominhdang.blog_app.features.images.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@Tag(name = "Image Endpoints", description = "Endpoints used for uploading and displaying images")
public class ImageController {

    private final ResourceLoader resourceLoader;

    public ImageController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @GetMapping("/uploads/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path path = Paths.get("uploads").resolve(filename);
            File file = path.toFile();
            if (!file.exists()) {
                return ResponseEntity.notFound().build();
            }
            Resource resource = resourceLoader.getResource("file:" + file.getAbsolutePath());

            // Determine the media type based on the file extension
            String mimeType = getMimeType(filename);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(mimeType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private String getMimeType(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();
        switch (extension) {
            case "png":
                return "image/png";
            case "gif":
                return "image/gif";
            case "jpg":
            case "jpeg":
                return "image/jpeg";
            default:
                return "application/octet-stream"; // Fallback
        }
    }
}
