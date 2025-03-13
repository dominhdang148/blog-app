package com.dominhdang.blog_app.features.tag.dto;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TagItemDto {
    private UUID id;
    private String name;
    private String urlSlug;
    private int postCount;
}
