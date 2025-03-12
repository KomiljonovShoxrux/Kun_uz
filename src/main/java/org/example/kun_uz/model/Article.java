package org.example.kun_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false , unique = true)
    private String content;
    @Column(nullable = false)
    private String shared_count;
    @Column(nullable = false)
    private String image_id;
    @ManyToMany
    private List<Region> region_id;
    @ManyToMany
    private List<Category> category_id;
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
