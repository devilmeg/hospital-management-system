package com.hms.hospital_management.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

=======
import lombok.*;
>>>>>>> 016a7a7b1c5122e2bb993835c924a6f19a9ec9e8
@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String role;
}
