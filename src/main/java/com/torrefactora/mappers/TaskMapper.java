package com.torrefactora.mappers;

import com.torrefactora.dtos.CreateTaskDto;
import com.torrefactora.dtos.ResponseTaskDto;
import com.torrefactora.entities.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Interfaz que define la lógica de mapeo entre entidades de tarea y DTOs de tarea.
 */
@Mapper
public interface TaskMapper {

    /**
     * Instancia Singleton del mapeador de tarea.
     */
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    /**
     * Convierte una entidad de tarea en un DTO de tarea de respuesta.
     *
     * @param taskEntity La entidad de tarea a convertir.
     * @return El DTO de tarea de respuesta resultante.
     */
    @Mapping(source = "status.name", target = "status")
    @Mapping(source = "priority.name", target = "priority")
    ResponseTaskDto toDto(TaskEntity taskEntity);

    /**
     * Convierte un DTO de creación de tarea en una entidad de tarea.
     *
     * @param createTaskDto El DTO de creación de tarea a convertir.
     * @return La entidad de tarea resultante.
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "priority", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    TaskEntity toEntity(CreateTaskDto createTaskDto);

}
