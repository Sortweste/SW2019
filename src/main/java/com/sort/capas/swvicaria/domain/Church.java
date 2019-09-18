package com.sort.capas.swvicaria.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "parish")
@Data
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_address")
    private String address;

    @Column(name = "p_history")
    private String history;

    @Column(name = "p_picture")
    private String img;

}
