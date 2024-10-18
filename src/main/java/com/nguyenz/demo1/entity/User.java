package com.nguyenz.demo1.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String name;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String address;
    @Column
    private Date dob;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_role", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "user_id"), // Khóa chính của User
            inverseJoinColumns = @JoinColumn(name = "role_id") // Khóa chính của Role
    )
    private Set<Role> roles = new HashSet<>();
}
