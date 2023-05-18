package com.ohtic.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;
    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario, Integer id) {
        Usuario usuarioUpdated = findById(id);

        usuarioUpdated.setDni(usuario.getDni());
        usuarioUpdated.setEdad(usuario.getEdad());
        usuarioUpdated.setEmail(usuario.getEmail());
        usuarioUpdated.setNombre(usuario.getNombre());

        return repository.save(usuarioUpdated);

    }
}
