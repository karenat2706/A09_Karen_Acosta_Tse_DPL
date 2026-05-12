package org.karenapp.service;
import org.karenapp.model.Idol;
import org.karenapp.repository.IdolRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import  static org.junit.jupiter.api.Assertions.*;
import  static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IdolServiceTest {

    @Mock
    private  IdolRepository  repository;

    @InjectMocks
    private IdolService service;

    private  Idol  idol;

    @BeforeEach
    void setUp() {
        idol = new Idol();
        idol.setId(1L);
        idol.setNombreArtistico("Felix");
        idol.setGrupo("Stray Kids");
        idol.setGenero("masculino");
        idol.setEdad(24);
        idol.setAñosExperiencia(7);
    }

    @Test
    void testGuardarIdol() {
        when(repository.save(any(Idol.class))).thenReturn(idol);

        Idol guardado = service.guardarIdol(new Idol());

        assertNotNull(guardado);
        assertEquals("Felix", guardado.getNombreArtistico());
        assertEquals("Stray Kids", guardado.getGrupo());
        assertEquals(24, guardado.getEdad());
        verify(repository, times(1)).save(any(Idol.class));
    }

    @Test
    void testObtenerTodos() {
        when(repository.findAll()).thenReturn(List.of(idol));

        List<Idol> lista = service.obtenerTodos();

        assertFalse(lista.isEmpty());
        assertEquals(1, lista.size());
        assertEquals("Felix", lista.get(0).getNombreArtistico());
        verify(repository, times(1)).findAll();
    }
}

