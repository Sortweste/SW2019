package com.sort.capas.swvicaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "u_active")
    private Boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="r_id")
    //@Fetch(FetchMode.JOIN)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="t_id")
    private Group group;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
