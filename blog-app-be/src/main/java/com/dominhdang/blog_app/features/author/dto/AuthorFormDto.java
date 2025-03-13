package com.dominhdang.blog_app.features.author.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorFormDto {
    @NotBlank(message = "Fullname is required")
    @Length(max = 100, message = "Full name shouldn't more than 100 characters")
    private String fullName;
    @NotBlank(message = "Url slug is required")
    @Length(max = 100, message = "Url slug shouldn't more than 100 characters")
    private String urlSlug;

    @Length(max = 150, message = "Email shouldn't more than 150 characters")
    @Email(message = "Email must be in right format")
    private String email;

    @Length(max = 500, message = "Note shouldn't more than 500 characters")
    private String note;
}
