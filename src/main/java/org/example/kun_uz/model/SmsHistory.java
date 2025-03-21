package org.example.kun_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
