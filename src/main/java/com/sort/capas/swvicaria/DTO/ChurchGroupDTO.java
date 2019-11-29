package com.sort.capas.swvicaria.DTO;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
//Entidad para el manejo de iglesias, pues no se usaran todos los datos de iglesias en algunos casos.
public class ChurchGroupDTO {

    private long id; //Por si el id se necesita cambiar.

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")

    private String name;

    private String information;

    private Date schedule;

    private Group group;

    private List<Church> church;

}
