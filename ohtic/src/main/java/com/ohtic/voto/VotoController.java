package com.ohtic.voto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voto")
public class VotoController {
    @Autowired
    private VotoService service;

    @GetMapping
    public List<Voto> getVotos(){
        return service.findAll();
    }

    @GetMapping("/getVoto")
    public Voto getVotoById(@RequestParam Integer idUsuario, @RequestParam Integer idPelicula){
        VotoKey id = new VotoKey();
        id.setUsuarioId(idUsuario);
        id.setPeliculaId(idPelicula);
        return service.findById(id);
    }

    @PostMapping
    public Voto createVoto(@RequestBody VotoKey id, Integer nota) {
        return service.save(id,nota);
    }

    @DeleteMapping
    public void deleteVotoById(@RequestParam Integer idUsuario,@RequestParam Integer idPelicula) {
        VotoKey id = new VotoKey();
        id.setUsuarioId(idUsuario);
        id.setPeliculaId(idPelicula);
        service.deleteById(id);
    }

    @PutMapping
    public Voto updateVoto(@RequestBody Voto voto,@RequestParam Integer idUsuario,@RequestParam Integer idPelicula){
        VotoKey id = new VotoKey();
        id.setUsuarioId(idUsuario);
        id.setPeliculaId(idPelicula);
        Voto votoUpdated = service.updateVoto(voto,id);
        return votoUpdated;
    }
}
