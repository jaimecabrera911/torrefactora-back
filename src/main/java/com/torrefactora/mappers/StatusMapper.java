package com.torrefactora.mappers;

import com.torrefactora.dtos.CreateStatusDto;
import com.torrefactora.dtos.ResponseStatusDto;
import com.torrefactora.entities.StatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Interfaz que define la lógica de mapeo entre entidades de estado y DTOs de estado.
 */
@Mapper
public interface StatusMapper {

    /**
     * Instancia Singleton del mapeador de estado.
     */
    StatusMapper INSTANCE = Mappers.getMapper(StatusMapper.class);

    /**
     * Convierte una entidad de estado en un DTO de estado de respuesta.
     *
     * @param statusEntity La entidad de estado a convertir.
     * @return El DTO de estado de respuesta resultante.
     */
    ResponseStatusDto toDto(StatusEntity statusEntity);

    /**
     * Convierte un DTO de creación de estado en una entidad de estado.
     *
     * @param createStatusDto El DTO de creación de estado a convertir.
     * @return La entidad de estado resultante.
     */
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "tasks",ignore = true)
    StatusEntity toEntity(CreateStatusDto createStatusDto);
}
