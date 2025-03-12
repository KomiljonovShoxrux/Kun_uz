package org.example.kun_uz.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article_typeDto {
    private String order_number;
    private String name_uz;
    private String name_ru;
    private String name_eng;


    private boolean visible;
    private LocalDateTime created_date;

}
