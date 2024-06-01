package com.torrefactora.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Entidad que representa una tarea en la base de datos.
 */
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tasks")
public class TaskEntity {

    /**
     * Identificador único de la tarea.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    /**
     * Nombre de la tarea.
     */
    @Basic
    @Column(name = "name", length = 100)
    private String name;

    /**
     * Descripción de la tarea.
     */
    @Basic
    @Column(name = "description", length = 100)
    private String description;

    /**
     * Fecha de inicio de la tarea.
     */
    @Basic
    @Column(name = "begin_date")
    private Date beginDate;

    /**
     * Fecha de finalización de la tarea.
     */
    @Basic
    @Column(name = "end_date")
    private Date endDate;

    /**
     * Fecha y hora en que se creó la tarea.
     */
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    /**
     * Fecha y hora en que se actualizó por última vez la tarea.
     */
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    /**
     * Prioridad de la tarea.
     */
    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id", nullable = false)
    private PriorityEntity priority;

    /**
     * Estado de la tarea.
     */
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private StatusEntity status;

}
