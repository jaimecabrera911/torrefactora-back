package com.torrefactora.services;

import com.torrefactora.dtos.CreateStatusDto;
import com.torrefactora.dtos.ResponseStatusDto;

import java.util.List;

/**
 * Interfaz que define los métodos para operaciones relacionadas con los estados.
 */
public interface IStatusService {

    /**
     * Obtiene todos los estados.
     *
     * @return Una lista de DTOs de estado de respuesta.
     */
    List<ResponseStatusDto> getAll();

    /**
     * Crea un nuevo estado.
     *
     * @param createStatusDto El DTO de creación de estado que contiene los detalles del nuevo estado.
     */
    void create(CreateStatusDto createStatusDto);
}
