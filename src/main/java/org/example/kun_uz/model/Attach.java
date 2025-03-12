package org.example.kun_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.net.Nio2Endpoint;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
