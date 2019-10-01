package com.sort.capas.swvicaria.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

@Entity
@Table(name = "test")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class Test {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "msg")
    private String msg;
}
