package com.torrefactora.dtos;

import com.torrefactora.entities.TaskEntity;
import lombok.*;

import java.io.Serializable;

/**
 * DTO (Objeto de Transferencia de Datos) para representar los datos necesarios para crear un estado.
 * Este DTO se utiliza para transferir datos relacionados con la creación de un estado entre
 * las capas de la aplicación.
 */
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateStatusDto implements Serializable {

    /**
     * El nombre del estado.
     */
    public String name;

    /**
     * La descripción del estado.
     */
    public String description;
}
