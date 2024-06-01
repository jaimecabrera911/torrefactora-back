package com.torrefactora.services;

import com.torrefactora.dtos.CreateTaskDto;
import com.torrefactora.dtos.ResponseTaskDto;

import java.util.List;

/**
 * Interfaz que define los métodos para operaciones relacionadas con las tareas.
 */
public interface ITaskService {

    /**
     * Crea una nueva tarea.
     *
     * @param createTaskDto El DTO de creación de tarea que contiene los detalles de la nueva tarea.
     * @return El ID de la tarea creada.
     */
    int createTask(CreateTaskDto createTaskDto);

    /**
     * Obtiene todas las tareas.
     *
     * @return Una lista de DTOs de tarea de respuesta.
     */
    List<ResponseTaskDto> getAll();

    /**
     * Busca una tarea por su ID.
     *
     * @param id El ID de la tarea a buscar.
     * @return El DTO de tarea de respuesta encontrado.
     */
    ResponseTaskDto findTaskById(int id);

    /**
     * Actualiza una tarea existente.
     *
     * @param id             El ID de la tarea a actualizar.
     * @param createTaskDto  El DTO de creación de tarea que contiene los detalles actualizados de la tarea.
     */
    void updateTask(int id, CreateTaskDto createTaskDto);
}
