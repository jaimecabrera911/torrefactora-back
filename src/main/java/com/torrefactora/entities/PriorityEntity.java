package com.torrefactora.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa una prioridad en la base de datos.
 */
@Setter
@Getter
@Entity
@Table(name = "priorities", schema = "torrefactora_db")
public class PriorityEntity {

    /**
     * Identificador único de la prioridad.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * Nombre de la prioridad.
     */
    @Basic
    @Column(name = "name", length = 100)
    private String name;

    /**
     * Descripción de la prioridad.
     */
    @Basic
    @Column(name = "description", length = 100)
    private String description;

    /**
     * Lista de tareas asociadas a esta prioridad.
     */
    @OneToMany(mappedBy = "priority")
    private List<TaskEntity> tasks = new ArrayList<>();

}
