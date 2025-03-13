
package com.dominhdang.blog_app.features.category.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryFormDto {
    @NotBlank(message = "Category's name is required")
    @Length(max = 50, message = "Category's name shouldn't more than 50 characters")
    private String name;

    @NotBlank(message = "Category's slug is required")
    @Length(max = 50, message = "Category's slug shouldn't more than 50 characters")
    private String urlSlug;

    @Length(max = 500, message = "Category's slug shouldn't more than 500 characters")
    private String description;
}
