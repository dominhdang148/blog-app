package com.dominhdang.blog_app.features.tag.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dominhdang.blog_app.features.tag.dto.TagDetailDto;
import com.dominhdang.blog_app.features.tag.dto.TagFormDto;
import com.dominhdang.blog_app.features.tag.dto.TagItemDto;
import com.dominhdang.blog_app.features.tag.dto.mapper.TagMapper;
import com.dominhdang.blog_app.features.tag.entity.Tag;
import com.dominhdang.blog_app.features.tag.repository.TagRepository;
import com.dominhdang.blog_app.models.ApiResponse;
import com.dominhdang.blog_app.models.Pagination;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private TagMapper tagMapper;

    @Override
    public ApiResponse<TagDetailDto> saveTag(TagFormDto tag) {
        if (!this.tagRepository.existsByNameIgnoreCaseOrUrlSlugIgnoreCase(tag.getName(), tag.getUrlSlug())) {
            Tag newTag = tagMapper.toEntity(tag);
            return ApiResponse.<TagDetailDto>builder()
                    .data(this.tagMapper.toDetailDto(this.tagRepository.save(newTag)))
                    .status(HttpStatus.CREATED)
                    .message("Create tag succesfully")
                    .build();
        }

        return ApiResponse.<TagDetailDto>builder()
                .status(HttpStatus.BAD_REQUEST)
                .message("Tag already existed")
                .build();
    }

    @Override
    public ApiResponse<TagDetailDto> saveTag(UUID id, TagFormDto tag) {
        Optional<Tag> existingTag = tagRepository.findById(id);
        if (existingTag.isEmpty()) {
            return ApiResponse.<TagDetailDto>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message(String.format("Tag with id: %s not found"))
                    .build();
        }
        Tag oldTag = existingTag.get();
        boolean isDuplicated = !oldTag.getName().equalsIgnoreCase(tag.getName())
                || !oldTag.getUrlSlug().equalsIgnoreCase(tag.getUrlSlug());
        if (isDuplicated
                || this.tagRepository.existsByNameIgnoreCaseOrUrlSlugIgnoreCaseAndIdNot(tag.getName(), tag.getUrlSlug(),
                        id)) {
            return ApiResponse.<TagDetailDto>builder()
                    .message(String.format("Tag's name and url slug might existed"))
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }

        Tag updatedTag = tagMapper.toEntity(tag);
        updatedTag.setId(id);
        return ApiResponse.<TagDetailDto>builder()
                .status(HttpStatus.OK)
                .data(this.tagMapper.toDetailDto(this.tagRepository.save(updatedTag)))
                .message(String.format("Tag with id: %s updated succesffully", id))
                .build();
    }

    @Override
    public ApiResponse<List<TagItemDto>> getAllTagsContainingName(String name, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<TagItemDto> result = this.tagRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(tag -> this.tagMapper.toItemDto(tag));
        Pagination pagination = Pagination.builder()
                .totalPages(result.getTotalPages())
                .totalItems(result.getTotalElements())
                .currentPage(currentPage)
                .pageSize(pageSize)
                .build();

        return ApiResponse.<List<TagItemDto>>builder()
                .status(HttpStatus.OK)
                .data(result.toList())
                .message("Geg tags List successfully")
                .pagination(pagination)
                .build();
    }

    @Override
    public ApiResponse<TagDetailDto> getById(UUID id) {
        TagDetailDto result = this.tagMapper.toDetailDto(this.tagRepository.findById(id).orElse(null));
        if (result == null) {
            return ApiResponse.<TagDetailDto>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message(String.format("Tag with id: %s not found", id))
                    .build();
        }

        return ApiResponse.<TagDetailDto>builder()
                .status(HttpStatus.NOT_FOUND)
                .message(String.format("Tag with id: %s found successfully", id))
                .build();
    }

    @Override
    public ApiResponse<?> deleteTag(UUID id) {
        if (this.tagRepository.existsById(id)) {
            this.tagRepository.deleteById(id);
            return ApiResponse.builder()
                    .status(HttpStatus.NO_CONTENT)
                    .message(String.format("Tag with id: %s deleted successfully", id))
                    .build();
        }

        return ApiResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(String.format("Tag with id: %s not found", id))
                .build();
    }
}
