package com.dominhdang.blog_app.features.author.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.author.dto.AuthorDetailDto;
import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.author.service.AuthorService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "api/author")
@Tag(name = "Author Endpoints", description = "Author's endpoints for public access")
@RequiredArgsConstructor
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AuthorItemDto>>> getAuthorList(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        ApiResponse<List<AuthorItemDto>> response = this.authorService.getAllByName(name, currentPage, pageSize);
        return ResponseEntity.status(response.getStatus()).body(response);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<AuthorDetailDto>> getAuthorById(
            @PathVariable("id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.authorService.getById(id));
    }

}
