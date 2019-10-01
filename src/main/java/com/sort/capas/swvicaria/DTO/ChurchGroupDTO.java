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

    private Group group;
    private List<Church> church;

}
