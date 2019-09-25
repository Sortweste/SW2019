package com.sort.capas.swvicaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "parish")
@Data
@AllArgsConstructor
@Valid
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")
    @Pattern(regexp = "[^1234567890]", message = "El nombre contiene numeros")
    @Column(name = "p_name")
    private String name;

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")
    @Column(name = "p_address")
    private String address;

    @NotNull
    @Size(min = 0, max = 5000, message = "El nombre debe ser entre 0 y 5000 caracteres")
    @Column(name = "p_history")
    private String history;

    @NotNull
    @Size(min = 0, max = 500, message = "El nombre debe ser entre 0 y 500 caracteres")
    @Column(name = "p_picture")
    private String img;

    @OneToMany(mappedBy = "church", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Group> groups;

}
