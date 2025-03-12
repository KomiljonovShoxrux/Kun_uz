package org.example.kun_uz.Dto;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Profile;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedArticleDto {

    @ManyToOne
    private Integer profile_id;
    @ManyToOne
    private UUID article_id;

    private LocalDateTime created_date;
}
