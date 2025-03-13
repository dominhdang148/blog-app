package com.dominhdang.blog_app.features.post.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.category.dto.CategoryItemDto;
import com.dominhdang.blog_app.features.tag.dto.TagItemDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostClientDetailDto {
    private UUID id;
    private String title;
    private String shortDescription;
    private String urlSlug;
    private String description;
    private String imageUrl;
    private int viewCount;
    private LocalDateTime postedDate;
    private LocalDateTime modifiedDate;
    private AuthorItemDto author;
    private CategoryItemDto category;
    private Set<TagItemDto> tags;
}
