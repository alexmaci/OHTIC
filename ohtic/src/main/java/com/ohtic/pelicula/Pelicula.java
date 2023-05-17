package com.ohtic.pelicula;

import com.ohtic.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Calendar;

@Entity
@Data
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String nombre;
    private Integer anyo;
    private String director;
    private String genero;
    private Calendar hora;
    @OneToOne
    private Usuario usuario;
}
