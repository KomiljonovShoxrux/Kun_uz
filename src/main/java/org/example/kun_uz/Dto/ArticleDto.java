package org.example.kun_uz.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.Category;
import org.example.kun_uz.model.Region;
import org.example.kun_uz.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String shared_count;
    @Column(nullable = false)

    private String image_id;
    @ManyToMany
    private Integer region_id;
    @ManyToMany
    private Integer category_id;

    @Column(nullable = false)
    private Integer moderator_id;
    @Column(nullable = false)
    private String publisher_id;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreatedDate
    private LocalDateTime created_date;
    @CreatedDate
    private LocalDateTime published_date;
    private boolean visible;
    private Integer view_count;
}
