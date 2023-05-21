package com.ohtic.auth;

import com.ohtic.config.JwtService;
import com.ohtic.usuario.Role;
import com.ohtic.usuario.Usuario;
import com.ohtic.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        Usuario user = new Usuario();
        user.setEdad(request.getEdad());
        user.setEmail(request.getEmail());
        user.setDni(request.getDni());
        user.setNombre(request.getNombre());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        repository.save(user);

        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getDni(),request.getPassword()));
        Usuario user = repository.findByDni(request.getDni()).orElseThrow();

        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(token).build();
    }
}
