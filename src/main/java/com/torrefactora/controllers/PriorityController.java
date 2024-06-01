package com.torrefactora.controllers;

import com.torrefactora.dtos.CreatePriorityDto;
import com.torrefactora.dtos.ResponsePriorityDto;
import com.torrefactora.services.IPriorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con las prioridades.
 */
@RestController
@RequestMapping("/priorities")
@RequiredArgsConstructor
public class PriorityController {

    private final IPriorityService priorityService;

    /**
     * Obtiene todas las prioridades.
     *
     * @return una lista de objetos ResponsePriorityDto que representan las prioridades.
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ResponsePriorityDto> getAll() {
        return priorityService.getAll();
    }

    /**
     * Crea una nueva prioridad.
     *
     * @param createPriorityDto objeto CreatePriorityDto que contiene los datos de la nueva prioridad.
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreatePriorityDto createPriorityDto) {
        priorityService.create(createPriorityDto);
    }
}
