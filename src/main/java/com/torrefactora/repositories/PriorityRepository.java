package com.torrefactora.repositories;

import com.torrefactora.entities.PriorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que proporciona métodos para interactuar con la base de datos para la entidad de prioridad.
 */
public interface PriorityRepository extends JpaRepository<PriorityEntity, Integer> {

    /**
     * Busca una prioridad por su nombre.
     *
     * @param name El nombre de la prioridad a buscar.
     * @return Un Optional que puede contener la prioridad encontrada, o vacío si no se encuentra.
     */
    Optional<PriorityEntity> findByName(String name);

}
