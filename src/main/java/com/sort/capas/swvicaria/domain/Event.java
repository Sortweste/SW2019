package com.sort.capas.swvicaria.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(name = "e_title")
    private String title;

    @Column(name = "e_info")
    private String information;

    @Column(name = "e_author")
    private String author;

    @Column(name = "e_subauthor")
    private String sub_author;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "e_date")
    private Date date_start;

    @Column(name = "e_time")
    private String time;

    @Column(name = "e_persona")
    private String persona;

    @Column(name = "e_cost")
    private double cost;
}
