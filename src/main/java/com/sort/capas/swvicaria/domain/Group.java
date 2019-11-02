package com.sort.capas.swvicaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")
   // @Pattern(regexp = "[^1234567890]", message = "El nombre contiene numeros")
    @Column(name = "t_name")
    private String name;


    @Column(name = "t_info")
    private String information;


    @Column(name = "t_schedule")
    private Date schedule;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id")
    private Church church;

    @OneToMany(mappedBy = "group", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<User> users;

}
