package com.ohtic.usuario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    UsuarioRepository repository;

    @InjectMocks
    private UsuarioServiceImpl service;

    private Usuario usuario;
    private Optional<Usuario> optional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(   this);
        usuario = new Usuario();
        usuario.setNombre("Test name");
        usuario.setId(1);
        usuario.setRole(Role.USER);
        usuario.setPassword("password");
        usuario.setEdad(12);
        usuario.setEmail("algo@mail.com");
        usuario.setDni("11111111J");
        optional = Optional.of(usuario);
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(usuario));
        assertNotNull(service.findAll());
    }

    @Test
    void findById() {
        when(repository.findById(any(Integer.class))).thenReturn(optional);
        assertNotNull(service.findById(5));
    }

    @Test
    void save() {
        when(repository.save(any(Usuario.class))).thenReturn(usuario);
        assertNotNull(service.save(usuario));
    }

    @Test
    void deleteById() {
        doNothing().when(repository).deleteById(any(Integer.class));
        service.deleteById(21);
    }

    @Test
    void updateUsuario() {
        when(repository.findById(any(Integer.class))).thenReturn(optional);
        when(repository.save(any(Usuario.class))).thenReturn(usuario);
        assertNotNull(service.updateUsuario(usuario,1));
    }
}