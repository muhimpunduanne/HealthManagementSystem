package com.example.healthcaresystem.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "the firstname is required")
    private String firstname;
    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "the last name is required")
    private String lastname;
    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message="the email is requied")
    private String email;
    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "the password is required")
    private String password;

}
