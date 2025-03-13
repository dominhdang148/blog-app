package com.dominhdang.blog_app.features.tag.entity;

import java.util.List;
import java.util.UUID;

import com.dominhdang.blog_app.features.post.entity.Post;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "tbl_tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false, length = 50, unique = true)
    private String name;

    @Column(name = "url_slug", nullable = false, length = 50, unique = true)
    private String urlSlug;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private List<Post> posts;
}
