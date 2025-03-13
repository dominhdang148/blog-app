package com.dominhdang.blog_app.features.tag.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dominhdang.blog_app.features.tag.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    Page<Tag> findByNameContainingIgnoreCase(String name, Pageable pageable);

    boolean existsByNameIgnoreCaseOrUrlSlugIgnoreCase(String name, String urlSlug);

    boolean existsByNameIgnoreCaseOrUrlSlugIgnoreCaseAndIdNot(String name, String urlSlug, UUID id);

    Optional<Tag> findOneByName(String name);
}
