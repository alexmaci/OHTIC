package com.ohtic.pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    private PeliculaRepository repository;
    @Override
    public List<Pelicula> findAll() {
        return repository.findAll();
    }

    @Override
    public Pelicula findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Pelicula save(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Pelicula updatePelicula(Pelicula pelicula, Integer id) {
        Pelicula peliculaUpdated = findById(id);

        peliculaUpdated.setAnyo(pelicula.getAnyo());
        peliculaUpdated.setDirector(pelicula.getDirector());
        peliculaUpdated.setGenero(pelicula.getGenero());
        peliculaUpdated.setNombre(pelicula.getNombre());
        peliculaUpdated.setUsuario(pelicula.getUsuario());


        return repository.save(peliculaUpdated);
    }
}
