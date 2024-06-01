package com.torrefactora.repositories;

import com.torrefactora.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Interfaz que proporciona métodos para interactuar con la base de datos para la entidad de estado.
 */
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

    /**
     * Busca un estado por su nombre.
     *
     * @param name El nombre del estado a buscar.
     * @return Un Optional que puede contener el estado encontrado, o vacío si no se encuentra.
     */
    Optional<StatusEntity> findByName(String name);
}
