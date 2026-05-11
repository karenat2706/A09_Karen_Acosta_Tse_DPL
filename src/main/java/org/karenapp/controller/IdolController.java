package org.karenapp.controller;
import org.karenapp.model.Idol;
import org.karenapp.service.IdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController

@RequestMapping("/api/idols")

public class IdolController {

    // Volvemos a usar Inyección de Dependencias para traer el Service
    @Autowired
    private IdolService service;

    // Endpoint para guardar (POST: http://localhost:8080/api/estudiantes)
    @PostMapping
    public Idol crear(@RequestBody Idol idol) {
        return service.guardarIdol(idol);
    }

    // Endpoint para listar (GET: http://localhost:8080/api/estudiantes)
    @GetMapping
    public List<Idol> listarTodos() {
        return service.obtenerTodos();
    }
}