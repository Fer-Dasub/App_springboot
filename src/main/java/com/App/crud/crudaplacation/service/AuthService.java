package com.App.crud.crudaplacation.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.crud.domain.model.Usuario;
import com.App.crud.domain.repository.UsuarioRepositoryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
   

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public Usuario registrar(Usuario usuario) {
        Optional<Usuario> usuarioExistente = usuarioRepositoryPort.BuscarPorEmail(usuario.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        }
        return usuarioRepositoryPort.guardar(usuario);
    }

    public Usuario login(String email, String password){
        return usuarioRepositoryPort.BuscarPorEmail(email)
                .filter(usuario -> usuario.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
    }

    public Optional<Usuario> buscarporid(Long id){
        return usuarioRepositoryPort.BuscarPorId(id);
    }

    public java.util.List<Usuario> listarUsuarios(){
        return usuarioRepositoryPort.Listar();
    }

    public void eliminar(Long id){
        usuarioRepositoryPort.eliminar(id);
    }
}