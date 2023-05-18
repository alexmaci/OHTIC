package com.ohtic.usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Integer id);
    public Usuario save(Usuario usuario);
    public void deleteById(Integer id);
    public Usuario updateUsuario(Usuario usuario, Integer id);
}
