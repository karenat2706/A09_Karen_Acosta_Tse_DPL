package org.karenapp.model;
import jakarta.persistence.*;

import lombok.Data; // Si usas Lombok, te ahorras escribir getters y setters


@Entity

@Table(name = "idols")

@Data // Elimina esto y genera getters/setters manualmente (Click derecho -> Generate) si no usas Lombok

public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombreArtistico;
    private String grupo;
    private String genero; // masculino, femenino o mixto
    private int edad;
    private int añosExperiencia;
}
