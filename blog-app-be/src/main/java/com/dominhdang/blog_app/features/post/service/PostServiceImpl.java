package com.dominhdang.blog_app.features.post.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.dominhdang.blog_app.features.author.entity.Author;
import com.dominhdang.blog_app.features.author.repository.AuthorRepository;
import com.dominhdang.blog_app.features.category.entity.Category;
import com.dominhdang.blog_app.features.category.repository.CategoryRepository;
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
                .message("Author saved successfully")
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
    public ApiResponse<List<PostManageItemDto>> getAdminPostList(String name, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ApiResponse<List<PostClientItemDto>> getClientPostList(String name, int currentPage, int pageSize) {
        return null;
    }

    @Override
    public ApiResponse<PostClientDetailDto> getClientPostDetail(UUID id) {
        return null;
    }
}
