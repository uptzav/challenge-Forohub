package com.foro.forohub.controller;

import com.foro.forohub.model.Topico;
import com.foro.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    // Método para manejar solicitudes POST (ya implementado)
    @PostMapping
    public ResponseEntity<Topico> crear(@RequestBody @Valid Topico topico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearTopico(topico));
    }

    // Método para manejar solicitudes GET
    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> topicos = service.listarTopicos();
        return ResponseEntity.ok(topicos);
    }
    // Listar los primeros 10 tópicos ordenados por fecha de creación (ASC)
    @GetMapping("/primeros10")
    public ResponseEntity<List<Topico>> listarPrimeros10() {
        return ResponseEntity.ok(service.listarPrimeros10());
    }

    // Buscar tópicos por curso y año
    @GetMapping("/buscar")
    public ResponseEntity<List<Topico>> listarPorCursoYAnio(
            @RequestParam String curso,
            @RequestParam int anio) {
        return ResponseEntity.ok(service.listarPorCursoYAnio(curso, anio));
    }

    // Listar tópicos con paginación
    @GetMapping("/paginacion")
    public ResponseEntity<Page<Topico>> listarConPaginacion(
            @PageableDefault(size = 10, sort = "fechaCreacion", direction = org.springframework.data.domain.Sort.Direction.ASC) Pageable pageable) {
        return ResponseEntity.ok(service.listarConPaginacion(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizar(@PathVariable Long id, @RequestBody @Valid Topico topico) {
        try {
            Topico actualizado = service.actualizarTopico(id, topico);
            return ResponseEntity.ok(actualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            service.eliminarTopico(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
