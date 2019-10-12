package com.sort.capas.swvicaria.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "e_id")
    private Long id;

    @Column(name = "e_name")
    private String name;

    @Column(name = "e_info")
    private String information;

    @Column(name = "e_author")
    private String author;

    @Column(name = "e_date_start")
    private Date date_start;

    @Column(name = "e_date_end")
    private Date date_end;
}
