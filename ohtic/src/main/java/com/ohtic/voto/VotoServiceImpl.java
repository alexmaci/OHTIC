package com.ohtic.voto;

import com.ohtic.pelicula.Pelicula;
import com.ohtic.pelicula.PeliculaRepository;
import com.ohtic.usuario.Usuario;
import com.ohtic.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class VotoServiceImpl implements VotoService{
    @Autowired
    private VotoRepository repository;
    @Autowired
    private PeliculaRepository peliculaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Voto> findAll() {
        return repository.findAll();
    }

    @Override
    public Voto findById(VotoKey id) {
        return repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Voto save(VotoKey id, Integer nota) {
        Pelicula pelicula = peliculaRepository.findById(id.getPeliculaId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Usuario usuario = usuarioRepository.findById(id.getUsuarioId()).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        Voto voto = new Voto();
        voto.setUsuario(usuario);
        voto.setNota(nota);
        voto.setPelicula(pelicula);
        return repository.save(voto);
    }

    @Override
    public void deleteById(VotoKey id) {
        repository.deleteById(id);
    }

    @Override
    public Voto updateVoto(Voto voto, VotoKey id) {
        Voto votoUpdated = repository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        votoUpdated.setNota(voto.getNota());
        votoUpdated.setPelicula(voto.getPelicula());
        votoUpdated.setUsuario(voto.getUsuario());

        repository.save(votoUpdated);
        return votoUpdated;

    }
}
