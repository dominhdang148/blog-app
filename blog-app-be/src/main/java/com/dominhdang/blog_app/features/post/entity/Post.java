package com.dominhdang.blog_app.features.post.entity;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dominhdang.blog_app.features.author.entity.Author;
import com.dominhdang.blog_app.features.category.entity.Category;
import com.dominhdang.blog_app.features.tag.entity.Tag;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tbl_post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "title", nullable = false, length = 500)
    private String title;

    @Column(name = "short_description", nullable = false, length = 5000)
    private String shortDescription;

    @Column(name = "description", nullable = false, length = 5000)
    private String description;

    @Column(name = "meta", nullable = false, length = 1000)
    private String meta;

    @Column(name = "url_slug", nullable = false, length = 200)
    private String urlSlug;

    @Column(name = "image_url", length = 1000)
    private String imageUrl;

    @Column(name = "view_count", nullable = false)
    @Builder.Default
    private Integer viewCount = 0;

    @Column(name = "published", nullable = false)
    @Builder.Default
    private Boolean published = false;

    @Column(name = "posted_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime postedDate;

    @Column(name = "modified_date", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author")
    private Author author;

    @ManyToMany
    @JoinTable(name = "tbl_post_tag", joinColumns = @JoinColumn(name = "post"), inverseJoinColumns = @JoinColumn(name = "tag"))
    private Set<Tag> tags;
}
