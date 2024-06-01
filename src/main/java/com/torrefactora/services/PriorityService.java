package com.torrefactora.services;

import com.torrefactora.dtos.CreatePriorityDto;
import com.torrefactora.dtos.ResponsePriorityDto;
import com.torrefactora.entities.PriorityEntity;
import com.torrefactora.mappers.PriorityMapper;
import com.torrefactora.repositories.PriorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de servicio que implementa la lógica para operaciones relacionadas con las prioridades.
 */
@RequiredArgsConstructor
@Service
public class PriorityService implements IPriorityService {

    /**
     * Repositorio de prioridades para interactuar con la base de datos.
     */
    private final PriorityRepository priorityRepository;

    /**
     * Mapeador de prioridades para convertir entre entidades y DTOs.
     */
    private final PriorityMapper priorityMapper = PriorityMapper.INSTANCE;

    /**
     * Obtiene todas las prioridades.
     *
     * @return Una lista de DTOs de prioridad de respuesta.
     */
    @Override
    public List<ResponsePriorityDto> getAll() {
        return priorityRepository.findAll().stream().map(priorityMapper::toDto).toList();
    }

    /**
     * Crea una nueva prioridad.
     *
     * @param createPriorityDto El DTO de creación de prioridad que contiene los detalles de la nueva prioridad.
     */
    @Override
    public void create(CreatePriorityDto createPriorityDto) {
        PriorityEntity entity = priorityMapper.toEntity(createPriorityDto);
        priorityRepository.save(entity);
    }
}
