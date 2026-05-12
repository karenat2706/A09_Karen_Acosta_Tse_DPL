package org.karenapp.service;
import org.karenapp.model.Idol;
import org.karenapp.repository.IdolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IdolService {
    @Autowired
    private IdolRepository repository;

    // Crear
    public Idol guardarIdol(Idol idol) {
        return repository.save(idol);
    }
    // Listar todos
    public List<Idol> obtenerTodos() {
        return repository.findAll();
    }
    // Buscar por ID
    public Idol obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Idol no encontrado con ID: " + id));
    }
    // Actualizar
    public Idol actualizarIdol(Long id, Idol idolActualizado) {
        Idol idolExistente = obtenerPorId(id);
        idolExistente.setNombreArtistico(idolActualizado.getNombreArtistico());
        idolExistente.setGrupo(idolActualizado.getGrupo());
        idolExistente.setGenero(idolActualizado.getGenero());
        idolExistente.setEdad(idolActualizado.getEdad());
        idolExistente.setAñosExperiencia(idolActualizado.getAñosExperiencia());
        return repository.save(idolExistente);
    }

    // Eliminar
    public void eliminarIdol(Long id) {
        Idol idol = obtenerPorId(id);
        repository.delete(idol);
    }
}