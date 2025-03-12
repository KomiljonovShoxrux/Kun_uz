package org.example.kun_uz.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Profile;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    @CreatedDate
    private LocalDateTime created_date;
    @CreatedDate
    private LocalDateTime updated_date;
    @ManyToMany
    private Integer profile_id;
    @Column(nullable = false)
    private String content;
    @ManyToMany
    private UUID article_id;
    @Column(nullable = false)
    private Integer reply_id;
    private boolean visible;
}
