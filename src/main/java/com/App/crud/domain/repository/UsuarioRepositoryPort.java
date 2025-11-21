package com.App.crud.domain.repository;

import java.util.List;
import java.util.Optional;

import com.App.crud.domain.model.Usuario;

public interface UsuarioRepositoryPort {
   List<Usuario> Listar();

    Optional<Usuario> BuscarPorId(Long id);

    Optional<Usuario> BuscarPorEmail(String email);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);


} 