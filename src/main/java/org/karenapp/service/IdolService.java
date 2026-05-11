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

        // Crear un idols en base de datos
        public Idol guardarIdol(Idol idol) {
            return repository.save(idol);
        }

        // Obtener todos los idols de la base de datos
        public List<Idol> obtenerTodos() {
            return repository.findAll();
        }
}