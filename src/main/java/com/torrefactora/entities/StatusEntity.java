package com.torrefactora.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un estado en la base de datos.
 */
@Setter
@Getter
@Entity
@Table(name = "status", schema = "torrefactora_db")
public class StatusEntity {

    /**
     * Identificador único del estado.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * Nombre del estado.
     */
    @Basic
    @Column(name = "name", nullable = true, length = 100)
    private String name;

    /**
     * Descripción del estado.
     */
    @Basic
    @Column(name = "description", nullable = true, length = 100)
    private String description;

    /**
     * Lista de tareas asociadas a este estado.
     */
    @OneToMany(mappedBy = "status")
    private List<TaskEntity> tasks = new ArrayList<>();

}
