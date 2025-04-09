package com.dominhdang.blog_app.features.post.dto.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.dominhdang.blog_app.features.author.dto.mapper.AuthorMapper;
import com.dominhdang.blog_app.features.category.dto.mapper.CategoryMapper;
import com.dominhdang.blog_app.features.post.dto.PostClientDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostClientItemDto;
import com.dominhdang.blog_app.features.post.dto.PostFormDto;
import com.dominhdang.blog_app.features.post.dto.PostManageDetailDto;
import com.dominhdang.blog_app.features.post.dto.PostManageItemDto;
import com.dominhdang.blog_app.features.post.entity.Post;
import com.dominhdang.blog_app.features.tag.dto.mapper.TagMapper;
import com.dominhdang.blog_app.features.tag.entity.Tag;

@Mapper(componentModel = "spring", uses = { AuthorMapper.class, CategoryMapper.class, TagMapper.class })
public interface PostMapper {
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "published", ignore = true)
    @Mapping(target = "modifiedDate", ignore = true)
    @Mapping(target = "postedDate", ignore = true)
    @Mapping(target = "viewCount", ignore = true)
    @Mapping(target = "imageUrl", ignore = true)
    Post toEntity(PostFormDto post);

    @Mapping(source = "author", target = "author")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "tags", target = "tags")
    PostClientDetailDto toClientDetailDto(Post post);

    PostClientItemDto toClientItemDto(Post post);

    @Mapping(source = "author", target = "author")
    @Mapping(source = "category", target = "category")
    @Mapping(source = "tags", target = "tags")
    PostManageDetailDto toManageDetailDto(Post post);

    PostManageItemDto toManageItemDto(Post post);

    default String mapTagSetToTagsString(Set<Tag> tags) {
        return String.join(",", tags.stream().map(tag -> tag.getName()).toList());
    }
}
