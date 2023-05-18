package com.ohtic.pelicula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public List<Pelicula> getPeliculas(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Pelicula getPeliculaById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Pelicula createPelicula(@RequestBody Pelicula newPelicula) {
        return service.save(newPelicula);
    }

    @DeleteMapping("/{id}")
    public void deletePeliculaById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Pelicula updatePelicula(@RequestBody Pelicula pelicula,@PathVariable Integer id){
        Pelicula peliculaUpdated = service.updatePelicula(pelicula,id);
        return peliculaUpdated;
    }
}
