package com.br.bycoders.controllers;

import com.br.bycoders.dtos.MovementDto;
import com.br.bycoders.dtos.TotalizerMovementDto;
import com.br.bycoders.services.MovementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/movement")
@Api(value="API REST Movimentação Finanaceira")
public class MovementController {
    @Autowired
    private MovementService service;

    @GetMapping(value = {"", "/{name}"})
    @ApiOperation(value="Lista de Movimentações Finanaceira Busca pelo nome da Loja se Passado nome")
    public TotalizerMovementDto listByName(@PathVariable(value = "name" , required = false) String name) {
        return service.findAll(name);
    }

    @PostMapping
    @ApiOperation(value="Criação de Movimentações Finanaceiras")
    public ResponseEntity<MovementDto> create(@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
        MovementDto movementDto = service.create(file);
        return ResponseEntity.ok(movementDto);
    }
}
