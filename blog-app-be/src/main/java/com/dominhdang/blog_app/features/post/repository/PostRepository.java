package com.dominhdang.blog_app.features.post.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominhdang.blog_app.features.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    Page<Post> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Post> findAllByTitleContainingIgnoreCaseAndPublished(String title, Boolean published, Pageable pageable);

    Page<Post> findByAuthor_UrlSlugAndPublished(String author_UrlSlug, Boolean published, Pageable pageable);

    Page<Post> findByCategory_UrlSlugAndPublished(String urlSlug, Boolean published, Pageable pageable);

    Page<Post> findByTags_UrlSlugAndPublished(String urlSlug, Boolean published, Pageable pageable);

    Page<Post> findByAuthorId(UUID id, Pageable pageable);

    Page<Post> findByCategoryId(UUID id, Pageable pageable);

    Page<Post> findByTagsId(UUID id, Pageable pageable);
}
