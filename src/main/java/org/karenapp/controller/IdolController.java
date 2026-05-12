package org.karenapp.controller;
import jakarta.validation.Valid;
import org.karenapp.model.Idol;
import org.karenapp.service.IdolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/idols")
public class IdolController {
    @Autowired
    private IdolService service;
    // POST - Crear
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Idol crear(@Valid @RequestBody Idol idol) {
        return service.guardarIdol(idol);
    }
    // GET - Listar todos
    @GetMapping
    public List<Idol> listarTodos() {
        return service.obtenerTodos();
    }
    // GET - Buscar por ID
    @GetMapping("/{id}")
    public Idol obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    // PUT - Actualizar (nuevo)
    @PutMapping("/{id}")
    public Idol actualizar(@PathVariable Long id, @Valid @RequestBody Idol idol) {
        return service.actualizarIdol(id, idol);
    }
    // DELETE - Eliminar (nuevo)
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminarIdol(id);
    }
}