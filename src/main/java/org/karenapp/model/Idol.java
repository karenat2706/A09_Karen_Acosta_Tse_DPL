package org.karenapp.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Table(name = "idols")
@Data
public class Idol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre artístico no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre artístico debe tener entre 2 y 50 caracteres")
    @Column(name = "nombre_artistico")
    private String nombreArtistico;

    @NotBlank(message = "El grupo no puede estar vacío")
    @Size(min = 1, max = 100, message = "El grupo debe tener entre 1 y 100 caracteres")
    private String grupo;

    @Pattern(regexp = "masculino|femenino|mixto", message = "El género debe ser: masculino, femenino o mixto")
    private String genero;

    @Min(value = 1, message = "La edad mínima es 1 año")
    @Max(value = 120, message = "La edad máxima es 120 años")
    private int edad;

    @Min(value = 0, message = "Los años de experiencia no pueden ser negativos")
    @Max(value = 50, message = "Los años de experiencia no pueden superar 50")
    @Column(name = "años_experiencia")
    private int añosExperiencia;
}