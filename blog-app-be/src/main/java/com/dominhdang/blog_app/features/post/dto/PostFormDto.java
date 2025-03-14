package com.dominhdang.blog_app.features.post.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostFormDto {
    @NotBlank(message = "Title is required")
    @Length(max = 500, message = "Title shouldn't more than 500 characters")
    private String title;

    @NotBlank(message = "Short description is required")
    @Length(max = 500, message = "Short description shouldn't more than 500 characters")
    private String shortDescription;

    @Length(max = 5000, message = "Description shouldn't more than 5000 characters")
    private String description;

    @NotBlank(message = "Metadata is required")
    @Length(max = 1000, message = "Metadata shouldn't more than 1000 characters")
    private String meta;

    @Length(max = 200, message = "Metadata shouldn't more than 200 characters")
    @NotBlank(message = "Post's Url Slug is required")
    private String urlSlug;

    @Length(max = 1000, message = "Image URL shouldn't more than 1000 characters")
    private String imageUrl;

    @NotNull(message = "Cateogory is required")
    private UUID categoryId;

    @NotNull(message = "Author is required")
    private UUID authorId;

    private String tags;

}
