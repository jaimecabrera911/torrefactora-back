package com.torrefactora.controllers;

import com.torrefactora.dtos.CreateTaskDto;
import com.torrefactora.dtos.ResponseTaskDto;
import com.torrefactora.services.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las tareas.
 */
@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService taskService;

    /**
     * Obtiene todas las tareas.
     *
     * @return una lista de objetos ResponseTaskDto que representan las tareas.
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseTaskDto> getAll() {
        return taskService.getAll();
    }

    /**
     * Crea una nueva tarea.
     *
     * @param createTaskDto objeto CreateTaskDto que contiene los datos de la nueva tarea.
     * @return el ID de la tarea creada.
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public int createTask(@RequestBody CreateTaskDto createTaskDto) {
        return taskService.createTask(createTaskDto);
    }

    /**
     * Actualiza una tarea existente.
     *
     * @param createTaskDto objeto CreateTaskDto que contiene los datos actualizados de la tarea.
     * @param id            el ID de la tarea que se actualizará.
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createTask(@RequestBody CreateTaskDto createTaskDto, @PathVariable int id) {
        taskService.updateTask(id, createTaskDto);
    }
}
