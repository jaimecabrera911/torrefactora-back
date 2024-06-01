package com.torrefactora.dtos;

import com.torrefactora.entities.TaskEntity;
import lombok.*;

import java.io.Serializable;

/**
 * DTO (Objeto de Transferencia de Datos) para representar los datos de respuesta de una prioridad.
 * Este DTO se utiliza para transferir datos relacionados con la respuesta de una prioridad entre
 * las capas de la aplicación.
 */
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponsePriorityDto implements Serializable {

    /**
     * El nombre de la prioridad.
     */
    public String name;

    /**
     * La descripción de la prioridad.
     */
    public String description;
}
