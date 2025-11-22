package com.App.crud.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.App.crud.domain.model.Usuario;
import com.App.crud.domain.repository.UsuarioRepositoryPort;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    /*@GetMapping
     public String test() {
        return "API funcionando";
     } */


    @Autowired
    private UsuarioRepositoryPort usuarioRepository;

    // Crear usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }

    // Listar todos
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.Listar();
    }

    // Buscar por id
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioRepository.BuscarPorId(id).orElse(null);
    }

    // Actualizar
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario datos) {
        Usuario usuario = usuarioRepository.BuscarPorId(id).orElse(null);
        if (usuario == null) return null;

        usuario.setNombre(datos.getNombre());
        usuario.setEmail(datos.getEmail());

        return usuarioRepository.guardar(usuario);
    }

    // Eliminar
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.eliminar(id);
    }
}
