package com.torrefactora.services;

import com.torrefactora.dtos.CreateStatusDto;
import com.torrefactora.dtos.ResponseStatusDto;
import com.torrefactora.entities.StatusEntity;
import com.torrefactora.mappers.StatusMapper;
import com.torrefactora.repositories.StatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de servicio que implementa la lógica para operaciones relacionadas con los estados.
 */
@RequiredArgsConstructor
@Service
public class StatusService implements IStatusService {

    /**
     * Repositorio de estados para interactuar con la base de datos.
     */
    private final StatusRepository statusRepository;

    /**
     * Mapeador de estados para convertir entre entidades y DTOs.
     */
    private final StatusMapper statusMapper = StatusMapper.INSTANCE;

    /**
     * Obtiene todos los estados.
     *
     * @return Una lista de DTOs de estado de respuesta.
     */
    @Override
    public List<ResponseStatusDto> getAll() {
        return statusRepository.findAll().stream().map(statusMapper::toDto).toList();
    }

    /**
     * Crea un nuevo estado.
     *
     * @param createStatusDto El DTO de creación de estado que contiene los detalles del nuevo estado.
     */
    @Override
    public void create(CreateStatusDto createStatusDto) {
        StatusEntity entity = statusMapper.toEntity(createStatusDto);
        statusRepository.save(entity);
    }
}
