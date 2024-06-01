package com.torrefactora.repositories;

import com.torrefactora.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que proporciona métodos para interactuar con la base de datos para la entidad de tarea.
 */
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
}
