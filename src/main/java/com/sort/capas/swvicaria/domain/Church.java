package com.sort.capas.swvicaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "parish")
@Data
@AllArgsConstructor
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private Long id;

    @Setter
    @Getter
    @Column(name = "p_name")
    private String name;

    @Setter
    @Getter
    @Column(name = "p_address")
    private String address;

    @Setter
    @Getter
    @Column(name = "p_history")
    private String history;

    @Setter
    @Getter
    @Column(name = "p_picture")
    private String img;

    @OneToMany(mappedBy = "church", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Group> groups;

}
