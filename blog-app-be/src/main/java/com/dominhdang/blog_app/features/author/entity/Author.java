
package com.dominhdang.blog_app.features.author.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.dominhdang.blog_app.features.post.entity.Post;

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
@Table(name = "tbl_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName;

    @Column(name = "url_slug", nullable = false, length = 100)
    private String urlSlug;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "joined_date", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime joinedDate;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "note", length = 500)
    private String note;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

}
