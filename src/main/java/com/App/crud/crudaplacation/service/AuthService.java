package com.App.crud.crudaplacation.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.crud.domain.model.Usuario;
import com.App.crud.domain.repository.UsuarioRepositoryPort;

@Service
public class AuthService {
    private final UsuarioRepositoryPort usuarioPort;

    public AuthService(UsuarioRepositoryPort usuarioPort) {
        this.usuarioPort = usuarioPort;
    }

    public boolean login(String email, String password){
        Optional<Usuario> uOpt = usuarioPort.findByEmail(email);
        if(uOpt.isEmpty()) return false;
        Usuario u = uOpt.get();
        return u.getPassword().equals(password);
    }
}