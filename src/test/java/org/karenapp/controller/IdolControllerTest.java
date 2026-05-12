package org.karenapp.controller;
import org.karenapp.model.Idol;
import org.karenapp.service.IdolService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import  static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(IdolController.class)
public  class IdolControllerTest {

    @Autowired
    private  MockMvc  mockMvc;

    @MockitoBean
    private IdolService service;

    @Test
    void testListarTodosEndpoint() throws Exception {
        Idol idol = new Idol();
        idol.setNombreArtistico("Felix");
        idol.setGrupo("Stray Kids");
        idol.setGenero("masculino");
        idol.setEdad(24);
        idol.setAñosExperiencia(7);

        when(service.obtenerTodos()).thenReturn(List.of(idol));

        mockMvc.perform(get("/api/idols"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nombreArtistico").value("Felix"))
                .andExpect(jsonPath("$[0].grupo").value("Stray Kids"));
    }
}
