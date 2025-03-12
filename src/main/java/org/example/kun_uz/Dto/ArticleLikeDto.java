package org.example.kun_uz.Dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.Article;
import org.example.kun_uz.model.Profile;
import org.example.kun_uz.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleLikeDto {

    @ManyToMany
    private Integer profiles;
    @ManyToMany
    private UUID articleid;
    @CreatedDate
    private LocalDateTime created_date;
    @Enumerated(EnumType.STRING)
    private Status status;
}
