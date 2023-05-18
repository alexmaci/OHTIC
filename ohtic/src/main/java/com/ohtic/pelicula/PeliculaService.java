package com.ohtic.pelicula;

import java.util.List;

public interface PeliculaService {
    public List<Pelicula> findAll();
    public Pelicula findById(Integer id);
    public Pelicula save(Pelicula pelicula);
    public void deleteById(Integer id);
    public Pelicula updatePelicula(Pelicula pelicula, Integer id);
}
