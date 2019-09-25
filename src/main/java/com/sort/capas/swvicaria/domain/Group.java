package com.sort.capas.swvicaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "teams")
@Data
@AllArgsConstructor
@Valid
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "t_id")
    private Long id;

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")
    @Pattern(regexp = "[^1234567890]", message = "El nombre contiene numeros")
    @Column(name = "t_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id")
    private Church church;

}
