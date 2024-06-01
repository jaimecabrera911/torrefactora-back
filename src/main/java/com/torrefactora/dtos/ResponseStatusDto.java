package com.torrefactora.dtos;

import lombok.*;

import java.io.Serializable;

/**
 * DTO (Objeto de Transferencia de Datos) para representar los datos de respuesta de un estado.
 * Este DTO se utiliza para transferir datos relacionados con la respuesta de un estado entre
 * las capas de la aplicación.
 */
@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseStatusDto implements Serializable {

    /**
     * El nombre del estado.
     */
    public String name;

    /**
     * La descripción del estado.
     */
    public String description;
}