package com.sort.capas.swvicaria.DTO;

import com.sort.capas.swvicaria.domain.Church;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

public class ChurchGroupDTO {

    @NotNull
    @Size(min = 0, max = 100, message = "El nombre debe ser entre 0 y 100 caracteres")
    // @Pattern(regexp = "[^1234567890]", message = "El nombre contiene numeros")

    private String name;


    private String information;


    private Date schedule;

    private List<Church> church;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public List<Church> getChurch() {
        return church;
    }

    public void setChurch(List<Church> church) {
        this.church = church;
    }
}
