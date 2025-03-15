package com.dominhdang.blog_app.features.post.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dominhdang.blog_app.features.author.entity.Author;
import com.dominhdang.blog_app.features.author.repository.AuthorRepository;
import com.dominhdang.blog_app.features.category.entity.Category;
import com.dominhdang.blog_app.features.category.repository.CategoryRepository;
import com.dominhdang.blog_app.features.images.service.ImageService;
import com.dominhdang.blog_app.features.post.dto.PostClientDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.dto.PostFormDto;
import com.dominhdang.blog_app.features.post.dto.PostManageDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostManageItemDto;
import com.dominhdang.blog_app.features.post.dto.mapper.PostMapper;
import com.dominhdang.blog_app.features.post.entity.Post;
import com.dominhdang.blog_app.features.post.repository.PostRepository;
import com.dominhdang.blog_app.features.tag.entity.Tag;
import com.dominhdang.blog_app.features.tag.repository.TagRepository;
import com.dominhdang.blog_app.models.ApiResponse;
import com.dominhdang.blog_app.models.Pagination;
import com.dominhdang.blog_app.utils.SlugGenerator;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    PostMapper postMapper;

    @Autowired
    ImageService imageService;

    @Override
    public ApiResponse<PostManageDetailDto> savePost(PostFormDto post) {
        Author author = this.authorRepository.findById(post.getAuthorId()).orElse(null);
        if (author == null) {
            return ApiResponse.<PostManageDetailDto>builder().status(HttpStatus.NOT_FOUND).message("Author not existed")
                    .build();
        }

        Category category = this.categoryRepository.findById(post.getCategoryId())
                .orElse(null);

        if (category == null) {
            return ApiResponse.<PostManageDetailDto>builder().status(HttpStatus.NOT_FOUND)
                    .message("Category not existed")
                    .build();
        }
        Set<Tag> tagSet = new HashSet<>();
        String[] tagNames = post.getTags().split(",");
        if (post.getTags() != null && !post.getTags().isEmpty()) {
            for (String tagName : tagNames) {
                final String trimedName = tagName.trim();
                Tag tag = this.tagRepository.findOneByName(trimedName).orElseGet(() -> {
                    Tag newtag = Tag.builder().name(trimedName).urlSlug(SlugGenerator.toSlug(trimedName)).build();
                    return tagRepository.save(newtag);
                });
                tagSet.add(tag);
            }
        }

        Post newPost = postMapper.toEntity(post);
        newPost.setAuthor(author);
        newPost.setCategory(category);
        newPost.setTags(tagSet);

        return ApiResponse.<PostManageDetailDto>builder()
                .status(HttpStatus.CREATED)
                .data(this.postMapper.toManageDetailDto(this.postRepository.save(newPost)))
                .message("Post created successfully")
                .build();
    }

    @Override
    public ApiResponse<PostManageDetailDto> savePost(UUID id, PostFormDto post) {
        if (this.postRepository.existsById(id)) {
            Author author = this.authorRepository.findById(post.getAuthorId()).orElse(null);
            if (author == null) {
                return ApiResponse.<PostManageDetailDto>builder().status(HttpStatus.NOT_FOUND)
                        .message("Author not existed")
                        .build();
            }

            Category category = this.categoryRepository.findById(post.getCategoryId())
                    .orElse(null);

            if (category == null) {
                return ApiResponse.<PostManageDetailDto>builder().status(HttpStatus.NOT_FOUND)
                        .message("Category not existed")
                        .build();
            }
            Set<Tag> tagSet = new HashSet<>();
            String[] tagNames = post.getTags().split(",");
            if (post.getTags() != null && !post.getTags().isEmpty()) {
                for (String tagName : tagNames) {
                    final String trimedName = tagName.trim();
                    Tag tag = this.tagRepository.findOneByName(trimedName).orElseGet(() -> {
                        Tag newtag = Tag.builder().name(trimedName).urlSlug(SlugGenerator.toSlug(trimedName)).build();
                        return tagRepository.save(newtag);
                    });
                    tagSet.add(tag);
                }
            }

            Post updatedPost = this.postMapper.toEntity(post);
            updatedPost.setId(id);
            updatedPost.setAuthor(author);
            updatedPost.setCategory(category);
            updatedPost.setTags(tagSet);
            return ApiResponse.<PostManageDetailDto>builder()
                    .status(HttpStatus.OK)
                    .data(this.postMapper.toManageDetailDto(this.postRepository.save(updatedPost)))
                    .message(String.format("Post with id: %s updated successfully", id))
                    .build();
        }
        return ApiResponse.<PostManageDetailDto>builder()
                .status(HttpStatus.NOT_FOUND)
                .message(String.format("Post with id: %s not found", id))
                .build();
    }

    @Override
    public ApiResponse<?> deletePost(UUID id) {
        if (this.postRepository.existsById(id)) {
            this.postRepository.deleteById(id);
            return ApiResponse.builder()
                    .status(HttpStatus.NO_CONTENT)
                    .message(String.format("Post with id: %s deleted successfully", id))
                    .build();
        }
        return ApiResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(String.format("Post with id: %s not found", id))
                .build();
    }

    @Override
    public ApiResponse<PostManageDetailDto> getAdminPostDetail(UUID id) {
        Post result = this.postRepository.findById(id).orElse(null);
        if (result == null) {
            return ApiResponse.<PostManageDetailDto>builder()
                    .status(HttpStatus.NOT_FOUND)
                    .message(String.format("Post with id: %s not found", id))
                    .build();
        }

        return ApiResponse.<PostManageDetailDto>builder()
                .status(HttpStatus.OK)
                .data(this.postMapper.toManageDetailDto(result))
                .message(String.format("Post with id: %s not found", id))
                .build();
    }

    @Override
    public ApiResponse<PostManageDetailDto> togglePublishPost(UUID id) {
        if (this.postRepository.existsById(id)) {
            Post post = this.postRepository.findById(id).get();
            post.setPublished(!post.getPublished());
            return ApiResponse.<PostManageDetailDto>builder()
                    .status(HttpStatus.OK)
                    .data(this.postMapper.toManageDetailDto(this.postRepository.save(post)))
                    .message(String.format("Post with id: %s updated successfully", id))
                    .build();
        }
        return ApiResponse.<PostManageDetailDto>builder()
                .status(HttpStatus.NOT_FOUND)
                .message(String.format("Post with id: %s not found ", id))
                .build();
    }

    @Override
    public ApiResponse<List<PostManageItemDto>> getAdminPostList(String title, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<PostManageItemDto> result = this.postRepository.findAllByTitleContainingIgnoreCase(title, pageable)
                .map(post -> this.postMapper.toManageItemDto(post));
        Pagination pagination = Pagination.builder()
                .currentPage(currentPage)
                .pageSize(pageSize)
                .totalItems(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .build();
        return ApiResponse.<List<PostManageItemDto>>builder()
                .status(HttpStatus.OK)
                .message("Get all Posts successfully")
                .pagination(pagination)
                .data(result.toList())
                .build();
    }

    @Override
    public ApiResponse<List<PostClientItemDto>> getClientPostList(String title, int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<PostClientItemDto> result = this.postRepository
                .findAllByTitleContainingIgnoreCaseAndPublishedTrue(title, pageable)
                .map(post -> this.postMapper.toClientItemDto(post));
        Pagination pagination = Pagination.builder()
                .currentPage(currentPage)
                .pageSize(pageSize)
                .totalItems(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .build();
        return ApiResponse.<List<PostClientItemDto>>builder()
                .status(HttpStatus.OK)
                .message("Get all Posts successfully")
                .pagination(pagination)
                .data(result.toList())
                .build();
    }

    @Override
    public ApiResponse<PostManageDetailDto> updateImage(UUID id, MultipartFile image) {

        if (this.postRepository.existsById(id)) {
            Post post = this.postRepository.findById(id).get();
            try {
                String imageUrl = this.imageService.saveImage(image);
                post.setImageUrl(imageUrl);
                return ApiResponse.<PostManageDetailDto>builder()
                        .message(String.format("Post with id: %s updated successfully", id))
                        .status(HttpStatus.OK)
                        .data(this.postMapper.toManageDetailDto(this.postRepository.save(post)))
                        .build();
            } catch (Exception e) {
                return ApiResponse.<PostManageDetailDto>builder()
                        .message(String.format("There is error while saving image: %s", e.getMessage()))
                        .status(HttpStatus.BAD_REQUEST)
                        .build();
            }
        }

        return ApiResponse.<PostManageDetailDto>builder()
                .message(String.format("Post with id: %s not found", id))
                .status(HttpStatus.NOT_FOUND)
                .build();
    }

    @Override
    public ApiResponse<PostClientDetailDto> getClientPostDetail(UUID id) {
        Post post = this.postRepository.findById(id).orElse(null);
        if (post != null) {
            return ApiResponse.<PostClientDetailDto>builder()
                    .message(String.format("Post with id: %s updated successfully", id))
                    .status(HttpStatus.OK)
                    .data(this.postMapper.toClientDetailDto(post))
                    .build();
        }
        return ApiResponse.<PostClientDetailDto>builder()
                .message(String.format("Post with id: %s not found", id))
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
