package com.dominhdang.blog_app.features.author.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dominhdang.blog_app.features.author.dto.AuthorDetailDto;
import com.dominhdang.blog_app.features.author.dto.AuthorFormDto;
import com.dominhdang.blog_app.features.author.dto.AuthorItemDto;
import com.dominhdang.blog_app.features.author.entity.Author;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "joinedDate", ignore = true)
    @Mapping(target = "posts", ignore = true)
    @Mapping(target = "imageUrl", ignore = true)
    Author toEntity(AuthorFormDto author);

    AuthorItemDto toItemDto(Author author);

    AuthorDetailDto toDetailDto(Author author);
}
