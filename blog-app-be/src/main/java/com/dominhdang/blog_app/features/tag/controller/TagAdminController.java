package com.dominhdang.blog_app.features.tag.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.tag.dto.TagDetailDto;
import com.dominhdang.blog_app.features.tag.dto.TagFormDto;
import com.dominhdang.blog_app.features.tag.service.TagService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/admin/tag")
@Tag(name = "Tag Admin Endpoints", description = "Tag's endpoints for administrator access")
public class TagAdminController {
    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<ApiResponse<TagDetailDto>> addTag(@Valid @RequestBody TagFormDto tag) {

        ApiResponse<TagDetailDto> response = this.tagService.saveTag(tag);
        return ResponseEntity.status(response.getStatus()).body(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TagDetailDto>> updateTag(@PathVariable UUID id, @RequestBody TagFormDto tag) {
        ApiResponse<TagDetailDto> response = this.tagService.saveTag(id, tag);

        return ResponseEntity
                .status(response.getStatus())
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteTag(@PathVariable UUID id) {
        ApiResponse<?> response = this.tagService.deleteTag(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
