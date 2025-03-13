package com.dominhdang.blog_app.features.author.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthorItemDto {
    private UUID id;
    private String fullName;
    private String imageUrl;
    private LocalDateTime joinedDate;
    private String email;
}
