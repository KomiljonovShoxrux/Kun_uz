package org.example.kun_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @CreatedDate
    private LocalDateTime created_date;
    @CreatedDate
    private LocalDateTime updated_date;
    @ManyToMany
    private List<Profile> profile_id;
    @Column(nullable = false)
    private String content;
    @ManyToMany
    private List<Article> article_id;
    @Column(nullable = false)
    private Integer reply_id;
    private boolean visible;
}
