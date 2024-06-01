package com.torrefactora.dtos;

import com.torrefactora.entities.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO (Objeto de Transferencia de Datos) para representar los datos necesarios para crear una tarea.
 * Este DTO se utiliza para transferir datos relacionados con la creación de una tarea entre
 * las capas de la aplicación.
 */
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateTaskDto implements Serializable {

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
}
