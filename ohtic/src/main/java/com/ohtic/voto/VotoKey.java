package com.ohtic.voto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class VotoKey {
    private Integer usuarioId;
    private Integer peliculaId;
}
