package com.dominhdang.blog_app.features.author.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dominhdang.blog_app.features.author.dto.AuthorDetailDto;
import com.dominhdang.blog_app.features.author.dto.AuthorFormDto;
import com.dominhdang.blog_app.features.author.service.AuthorService;
import com.dominhdang.blog_app.features.images.service.ImageService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/admin/author")
@Tag(name = "Author Admin Endpoints", description = "Author's endpoints for administrator access")
public class AuthorAdminController {
    @Autowired
    private AuthorService authorService;

    @Autowired
    private ImageService imageService;

    @PostMapping
    public ResponseEntity<ApiResponse<AuthorDetailDto>> addAuthor(@Valid @RequestBody AuthorFormDto author) {
        ApiResponse<AuthorDetailDto> response = authorService.saveAuthor(author);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(value = "{id}/avatar", consumes = "multipart/form-data")
    public ResponseEntity<ApiResponse<AuthorDetailDto>> updateAuthorAvatar(
            @PathVariable UUID id,
            @RequestParam("avatar") MultipartFile avatar) {
        ApiResponse<AuthorDetailDto> response;
        try {
            String imageUrl = imageService.saveImage(avatar);
            response = authorService.updateAvatar(id, imageUrl);
            return ResponseEntity.status(response.getStatus()).body(response);
        } catch (Exception e) {
            response = ApiResponse.<AuthorDetailDto>builder().message("An Error occur while saving image").build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<AuthorDetailDto>> updateAuthor(
            @PathVariable UUID id,
            @Valid @RequestBody AuthorFormDto updatedAuthor) {

        ApiResponse<AuthorDetailDto> response = this.authorService.saveAuthor(id, updatedAuthor);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<?>> deleteAuthor(@PathVariable("id") UUID id) {
        ApiResponse<?> response = this.authorService.deleteById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
