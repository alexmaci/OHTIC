package com.ohtic.voto;

import java.util.List;

public interface VotoService {
    public List<Voto> findAll();
    public Voto findById(VotoKey id);
    public Voto save(VotoKey id, Integer nota);
    public void deleteById(VotoKey id);
    public Voto updateVoto(Voto voto, VotoKey id);
}
