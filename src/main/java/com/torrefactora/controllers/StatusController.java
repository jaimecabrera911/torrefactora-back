package com.torrefactora.controllers;

import com.torrefactora.dtos.CreateStatusDto;
import com.torrefactora.dtos.ResponseStatusDto;
import com.torrefactora.services.IStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los estados.
 */
@RestController
@RequestMapping("/status")
@RequiredArgsConstructor
public class StatusController {

    private final IStatusService statusService;

    /**
     * Obtiene todos los estados.
     *
     * @return una lista de objetos ResponseStatusDto que representan los estados.
     */
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseStatusDto> getAll() {
        return statusService.getAll();
    }

    /**
     * Crea un nuevo estado.
     *
     * @param createStatusDto objeto CreateStatusDto que contiene los datos del nuevo estado.
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createTask(@RequestBody CreateStatusDto createStatusDto) {
        statusService.create(createStatusDto);
    }
}
