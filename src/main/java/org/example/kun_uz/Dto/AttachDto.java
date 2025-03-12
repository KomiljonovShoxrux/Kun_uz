package org.example.kun_uz.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachDto {

    @Column(nullable = false)
    private String orginal_name;
    @Column(nullable = false)
    private Integer path;
    @Column(nullable = false)
    private String size;
    @Column(nullable = false)
    private String extension;

    private LocalDateTime created_date;
}
