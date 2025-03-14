package com.dominhdang.blog_app.features.category.entity;

import java.util.List;
import java.util.UUID;

import com.dominhdang.blog_app.features.post.entity.Post;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @Column(name = "url_slug", nullable = false, length = 50, unique = true)
    private String urlSlug;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "show_on_menu", nullable = false)
    @Builder.Default
    private Boolean showOnMenu = false;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Post> posts;
}
