package com.dominhdang.blog_app.features.tag.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TagDetailDto {
    private UUID id;
    private String name;
    private String urlSlug;
    private String description;
}
