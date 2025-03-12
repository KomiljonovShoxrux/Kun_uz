package org.example.kun_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Profile profile_id;

    @OneToMany
    private List<Comment> comment_id;

    @CreatedDate
    private LocalDateTime created_Date;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String status;


}
