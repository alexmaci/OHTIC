package com.ohtic.voto;

import com.ohtic.pelicula.Pelicula;
import com.ohtic.usuario.Usuario;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;

@Entity
@Data
public class Voto {
    @EmbeddedId
    private VotoKey id = new VotoKey();
    @ManyToOne
    @MapsId("peliculaId")
    private Pelicula pelicula;
    @ManyToOne
    @MapsId("usuarioId")
    private Usuario usuario;
    int nota;
}
