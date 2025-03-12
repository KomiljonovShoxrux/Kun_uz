package org.example.kun_uz.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsHistoryDto {

    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(updatable = false)
    private String type;
    @CreatedDate
    private LocalDateTime created_date;
    @CreatedDate
    private LocalDateTime used_date;
}
