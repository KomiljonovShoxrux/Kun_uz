package org.example.kun_uz.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailHistoryDto {
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private String email;

    private LocalDateTime created_date;
}
