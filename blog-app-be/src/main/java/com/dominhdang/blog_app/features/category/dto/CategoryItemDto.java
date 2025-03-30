package com.dominhdang.blog_app.features.category.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryItemDto {
    private UUID id;
    private String name;
    private String urlSlug;
    private Boolean showOnMenu;
    private int postCount;
}
