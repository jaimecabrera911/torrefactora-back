package com.torrefactora.services;

import com.torrefactora.dtos.CreateTaskDto;
import com.torrefactora.dtos.ResponseTaskDto;
import com.torrefactora.entities.PriorityEntity;
import com.torrefactora.entities.StatusEntity;
import com.torrefactora.entities.TaskEntity;
import com.torrefactora.mappers.TaskMapper;
import com.torrefactora.repositories.PriorityRepository;
import com.torrefactora.repositories.StatusRepository;
import com.torrefactora.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Clase de servicio que implementa la lógica para operaciones relacionadas con las tareas.
 */
@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final TaskRepository taskRepository;
    private final StatusRepository statusRepository;
    private final PriorityRepository priorityRepository;
    private final TaskMapper taskMapper = TaskMapper.INSTANCE;

    /**
     * Crea una nueva tarea.
     *
     * @param createTaskDto El DTO de creación de tarea que contiene los detalles de la nueva tarea.
     * @return El ID de la tarea creada.
     */
    @Override
    public int createTask(CreateTaskDto createTaskDto) {
        StatusEntity status = statusRepository.findByName(createTaskDto.getStatus()).orElseThrow();
        PriorityEntity priority = priorityRepository.findByName(createTaskDto.getPriority()).orElseThrow();
        TaskEntity entity = taskMapper.toEntity(createTaskDto);
        entity.setStatus(status);
        entity.setPriority(priority);
        TaskEntity taskSaved = taskRepository.save(entity);
        return taskSaved.getId();
    }

    /**
     * Obtiene todas las tareas.
     *
     * @return Una lista de DTOs de tarea de respuesta.
     */
    @Override
    public List<ResponseTaskDto> getAll() {
        List<TaskEntity> tasks = taskRepository.findAll();
        return tasks.stream().map(taskMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Busca una tarea por su ID.
     *
     * @param id El ID de la tarea a buscar.
     * @return El DTO de tarea de respuesta encontrado.
     */
    @Override
    public ResponseTaskDto findTaskById(int id) {
        Optional<TaskEntity> task = taskRepository.findById(id);

        return task.map(taskEntity -> ResponseTaskDto.builder()
                .id(taskEntity.getId())
                .name(taskEntity.getName())
                .description(taskEntity.getDescription())
                .beginDate(taskEntity.getBeginDate())
                .endDate(taskEntity.getEndDate())
                .build()).orElse(null);
    }

    /**
     * Actualiza una tarea existente.
     *
     * @param id            El ID de la tarea a actualizar.
     * @param createTaskDto El DTO de creación de tarea que contiene los detalles actualizados de la tarea.
     * @throws Exception Si no se encuentra la tarea con el ID especificado.
     */
    @SneakyThrows
    @Override
    public void updateTask(int id, CreateTaskDto createTaskDto) {
        Optional<TaskEntity> task = taskRepository.findById(id);
        StatusEntity status = statusRepository.findByName(createTaskDto.getStatus()).orElseThrow();
        PriorityEntity priority = priorityRepository.findByName(createTaskDto.getPriority()).orElseThrow();

        if (task.isPresent()) {
            TaskEntity taskEntity = task.get();
            taskEntity.setName(createTaskDto.getName());
            taskEntity.setDescription(createTaskDto.getDescription());
            taskEntity.setBeginDate(createTaskDto.getBeginDate());
            taskEntity.setEndDate(createTaskDto.getEndDate());
            taskEntity.setStatus(status);
            taskEntity.setPriority(priority);
            taskRepository.save(taskEntity);
        } else {
            throw new Exception("Task not found");
        }
    }
}
