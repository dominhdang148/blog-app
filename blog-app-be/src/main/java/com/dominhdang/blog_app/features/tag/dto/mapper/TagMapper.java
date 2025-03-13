package com.dominhdang.blog_app.features.tag.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dominhdang.blog_app.features.tag.dto.TagDetailDto;
import com.dominhdang.blog_app.features.tag.dto.TagFormDto;
import com.dominhdang.blog_app.features.tag.dto.TagItemDto;
import com.dominhdang.blog_app.features.tag.entity.Tag;

@Mapper(componentModel = "spring")
public interface TagMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    Tag toEntity(TagFormDto tag);

    @Mapping(target = "postCount", expression = "java(tag.getPosts().size())")
    TagItemDto toItemDto(Tag tag);

    TagDetailDto toDetailDto(Tag tag);
}
