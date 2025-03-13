package com.dominhdang.blog_app.features.tag.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TagFormDto {
    @NotBlank(message = "Tag's name is required")
    @Length(max = 50, message = "Tag's name shouldn't over 50 characters")
    private String name;

    @NotBlank(message = "Tag's slug is required")
    @Length(max = 50, message = "Tag's slug shouldn't over 50 characters")
    private String urlSlug;

    @Length(max = 500, message = "Tag's slug shouldn't over 500 characters")
    private String description;

}
