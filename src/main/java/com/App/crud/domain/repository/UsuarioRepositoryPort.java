package com.App.crud.domain.repository;

import java.util.Optional;

import com.App.crud.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Usuario save(Usuario u);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
} 