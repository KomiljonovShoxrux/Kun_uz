package org.example.kun_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.kun_uz.model.entity.RolePermission;
import org.example.kun_uz.model.entity.Status;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false , unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private String password;

    //status
    @Enumerated(EnumType.STRING)
    private Status status=Status.ACTIVE;
    //role
    @Enumerated(EnumType.STRING)
    private RolePermission rolePermission;

    private boolean visible;
    @CreatedDate
    private LocalDateTime create_date;
    @Column(nullable = false)
    private Long photo_id;
}
