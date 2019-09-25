package com.sort.capas.swvicaria.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "r_id")
    private Long id;

    @Column(name = "r_name")
    private String role_name;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;


}
