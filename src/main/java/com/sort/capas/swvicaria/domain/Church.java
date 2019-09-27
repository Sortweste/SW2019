package com.sort.capas.swvicaria.domain;

import io.swagger.annotations.ApiModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "churchs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@ApiModel(description = "Church Entity")
public class Church {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Long id;

    @NotNull
    @Size(min = 0, max = 100, message = "{nameChurch.size}")
    @Pattern(regexp = "[^1234567890]", message = "{nameChurch.pattern}")
    @Column(name = "c_name")
    private String name;

    @NotNull
    @Size(min = 0, max = 100, message = "{addressChurch.size}")
    @Column(name = "c_address")
    private String address;

    @NotNull
    @Size(min = 0, max = 5000, message = "{historyChurch.size}")
    @Column(name = "c_history")
    private String history;

    @Column(name = "c_picture")
    private String img;

    @OneToMany(mappedBy = "church", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Group> groups;

}
