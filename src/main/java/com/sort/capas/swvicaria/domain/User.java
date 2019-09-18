package com.sort.capas.swvicaria.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "usr")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Long id;

    @Column(name = "u_username")
    private String username;

    @Column(name = "u_password")
    private String password;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_lname")
    private String lastName;

    @Column(name = "u_age")
    private Integer age;

    @Column(name = "u_phone")
    private String phone;

    @Column(name = "u_mail")
    private String email;

    @Column(name = "u_role")
    private String role;

}
