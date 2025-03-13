package com.dominhdang.blog_app.features.category.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominhdang.blog_app.features.category.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Page<Category> findByNameContainingIgnoreCase(String name, Pageable pageable);

    boolean existsByNameIgnoreCaseOrUrlSlugIgnoreCase(String name, String urlSlug);

    boolean existsByNameIgnoreCaseOrUrlSlugIgnoreCaseAndIdNot(String name, String urlSlug, UUID id);
}
