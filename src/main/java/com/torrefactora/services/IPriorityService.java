package com.torrefactora.services;

import com.torrefactora.dtos.CreatePriorityDto;
import com.torrefactora.dtos.ResponsePriorityDto;

import java.util.List;

/**
 * Interfaz que define los métodos para operaciones relacionadas con las prioridades.
 */
public interface IPriorityService {

    /**
     * Obtiene todas las prioridades.
     *
     * @return Una lista de DTOs de prioridad de respuesta.
     */
    List<ResponsePriorityDto> getAll();

    /**
     * Crea una nueva prioridad.
     *
     * @param createPriorityDto El DTO de creación de prioridad que contiene los detalles de la nueva prioridad.
     */
    void create(CreatePriorityDto createPriorityDto);
}
