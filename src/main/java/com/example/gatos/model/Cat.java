package com.example.gatos.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @Setter
@Table(name = "cat")
public class Cat {
    @Id
    private String id;
    private String name;
    private String description;
    private boolean domestic;
    private int sleeptime;

}
//Clase que é a tabela no banco//