package com.sort.capas.swvicaria.DTO;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Data
public class ChurchGroupDTO {

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")
    // @Pattern(regexp = "[^1234567890]", message = "El nombre contiene numeros")

    private String name;

    private String information;


    private Date schedule;

    private Group group;
    private List<Church> church;

}
