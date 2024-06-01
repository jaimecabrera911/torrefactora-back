package com.torrefactora.dtos;

import com.torrefactora.entities.TaskEntity;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * DTO (Objeto de Transferencia de Datos) para representar los datos de respuesta de una tarea.
 * Este DTO se utiliza para transferir datos relacionados con la respuesta de una tarea entre
 * las capas de la aplicación.
 */
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseTaskDto implements Serializable {

    /**
     * El identificador único de la tarea.
     */
    public int id;

    /**
     * El nombre de la tarea.
     */
    public String name;

    /**
     * La descripción de la tarea.
     */
    public String description;

    /**
     * La fecha de inicio de la tarea.
     */
    public Date beginDate;

    /**
     * La fecha de finalización de la tarea.
     */
    public Date endDate;

    /**
     * El estado de la tarea.
     */
    public String status;

    /**
     * La prioridad de la tarea.
     */
    public String priority;

    /**
     * La fecha y hora en que se creó la tarea.
     */
    public Timestamp createdAt;

    /**
     * La fecha y hora en que se actualizó por última vez la tarea.
     */
    private Timestamp updatedAt;
}
