package com.prudential.environment.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name="id")
    private Long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="user_role")
    private String userRole;
}
