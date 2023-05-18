package com.ohtic.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getUsuarios(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario newUsuario) {
        return service.save(newUsuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuarioById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario,@PathVariable Integer id){
        Usuario usuarioUpdated = service.updateUsuario(usuario,id);
        return usuarioUpdated;
    }

}
