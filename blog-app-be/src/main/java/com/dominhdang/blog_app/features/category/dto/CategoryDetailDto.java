package com.dominhdang.blog_app.features.category.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetailDto {
    private UUID id;
    private String name;
    private String urlSlug;
    private String description;
    private Boolean showOnMenu;
}
