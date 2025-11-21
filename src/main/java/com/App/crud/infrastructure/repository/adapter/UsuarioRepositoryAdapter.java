package com.App.crud.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.App.crud.domain.model.Usuario;
import com.App.crud.domain.repository.UsuarioRepositoryPort;
import com.App.crud.infrastructure.repository.entity.UsuarioEntity;
import com.App.crud.infrastructure.repository.jpa.UsuarioJpaRepository;

@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository) {
        this.usuarioJpaRepository = usuarioJpaRepository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = UsuarioEntity.fromDomain(usuario);
        UsuarioEntity guardar = usuarioJpaRepository.save(entity);
        return guardar.toDomain();
    }

    @Override
    public List<Usuario> Listar() {
        return usuarioJpaRepository.findAll()
                .stream()
                .map(UsuarioEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Usuario> BuscarPorId(Long id) {
        return usuarioJpaRepository.findById(id)
                .map(UsuarioEntity::toDomain);
    }

    @Override
    public Optional<Usuario> BuscarPorEmail(String email) {

        return usuarioJpaRepository.findByEmail(email)
                .map(UsuarioEntity::toDomain);
    }

    @Override
    public void eliminar(Long id) {
        usuarioJpaRepository.deleteById(id);
    }

}