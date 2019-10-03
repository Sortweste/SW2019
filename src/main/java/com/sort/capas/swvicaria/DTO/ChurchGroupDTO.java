package com.sort.capas.swvicaria.DTO;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.domain.Group;
import lombok.Data;

import java.util.List;

@Data
public class ChurchGroupDTO {

    private Group group;
    private List<Church> church;

}
