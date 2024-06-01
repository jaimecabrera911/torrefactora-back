package com.torrefactora.mappers;

import com.torrefactora.dtos.CreatePriorityDto;
import com.torrefactora.dtos.ResponsePriorityDto;
import com.torrefactora.entities.PriorityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Interfaz que define la lógica de mapeo entre entidades de prioridad y DTOs de prioridad.
 */
@Mapper
public interface PriorityMapper {

    /**
     * Instancia Singleton del mapeador de prioridad.
     */
    PriorityMapper INSTANCE = Mappers.getMapper(PriorityMapper.class);

    /**
     * Convierte una entidad de prioridad en un DTO de prioridad de respuesta.
     *
     * @param priorityEntity La entidad de prioridad a convertir.
     * @return El DTO de prioridad de respuesta resultante.
     */
    ResponsePriorityDto toDto(PriorityEntity priorityEntity);

    /**
     * Convierte un DTO de creación de prioridad en una entidad de prioridad.
     *
     * @param createPriorityDto El DTO de creación de prioridad a convertir.
     * @return La entidad de prioridad resultante.
     */
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "tasks",ignore = true)
    PriorityEntity toEntity(CreatePriorityDto createPriorityDto);
}
