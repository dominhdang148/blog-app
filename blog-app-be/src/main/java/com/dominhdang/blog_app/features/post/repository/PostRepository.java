package com.dominhdang.blog_app.features.post.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dominhdang.blog_app.features.post.entity.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {
    Page<Post> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
