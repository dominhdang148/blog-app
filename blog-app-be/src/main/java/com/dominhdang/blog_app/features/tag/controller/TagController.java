package com.dominhdang.blog_app.features.tag.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dominhdang.blog_app.features.tag.dto.TagDetailDto;
import com.dominhdang.blog_app.features.tag.dto.TagFormDto;
import com.dominhdang.blog_app.features.tag.dto.TagItemDto;
import com.dominhdang.blog_app.features.tag.service.TagService;
import com.dominhdang.blog_app.models.ApiResponse;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(name = "Tags Endpoints", path = "api/tag")
@Tag(name = "Tag Endpoints", description = "Tag's endpoints for public access")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<TagItemDto>>> getAllTags(
            @RequestParam(name = "name", defaultValue = "", required = false) String name,
            @RequestParam(name = "currentPage", defaultValue = "0") int currentPage,
            @RequestParam(name = "pageSize", defaultValue = "3") int pageSize) {
        ApiResponse<List<TagItemDto>> response = this.tagService.getAllTagsContainingName(name, currentPage, pageSize);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<TagDetailDto>> getDetailTag(@PathVariable UUID id) {
        ApiResponse<TagDetailDto> response = this.tagService.getById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

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
