package com.dominhdang.blog_app.features.author.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominhdang.blog_app.features.author.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
    Page<Author> findByFullNameContainingIgnoreCase(String fullName, Pageable pageable);
}
