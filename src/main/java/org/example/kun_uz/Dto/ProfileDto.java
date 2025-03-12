package org.example.kun_uz.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;

    //status

    //role

    private boolean visible;
    private LocalDateTime create_date;
    private Long photo_id;
}
