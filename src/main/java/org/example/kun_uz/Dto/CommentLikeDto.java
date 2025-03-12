package org.example.kun_uz.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.Comment;
import org.example.kun_uz.model.Profile;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentLikeDto {

    @ManyToOne
    private Integer profile_id;

    @OneToMany
    private Integer comment_id;

    @CreatedDate
    private LocalDateTime created_Date;
    @Column(nullable = false)
    private String status;
}
