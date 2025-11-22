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

import com.App.crud.domain.model.CarreraAcademica;
import com.App.crud.domain.repository.CarreraAcademicaRepositoryPort;


@RestController
@RequestMapping("/api/carreras")
public class CarreraAcademicaController {

    @Autowired
    private CarreraAcademicaRepositoryPort carreraAcademicaRepository;

    // Crear carrera académica
    @PostMapping
    public CarreraAcademica crearCarreraAcademica(@RequestBody CarreraAcademica carrera) {
        return carreraAcademicaRepository.guardar(carrera);
    }

    // Listar todas las carreras académicas
    // @GetMapping
    // public String test() {
    //     return "API funcionando";
    // }
    @GetMapping
    public List<CarreraAcademica> listarCarrerasAcademicas() {
        return carreraAcademicaRepository.Listar();
    }

    // Buscar carrera académica por id
    @GetMapping("/{id}")
    public CarreraAcademica obtenerCarreraAcademica(@PathVariable Long id) {
        return carreraAcademicaRepository.BuscarPorId(id).orElse(null);
    }

    // Actualizar carrera académica
    @PutMapping("/{id}")
    public CarreraAcademica actualizarCarreraAcademica(@PathVariable Long id, @RequestBody CarreraAcademica datos) {
        CarreraAcademica carrera = carreraAcademicaRepository.BuscarPorId(id).orElse(null);
        if (carrera == null) return null;

        carrera.setNombre(datos.getNombre());
        // Aquí puedes añadir más campos para actualizar, ej: carrera.setDuracion(datos.getDuracion());

        return carreraAcademicaRepository.guardar(carrera);
    }

    // Eliminar carrera académica
    @DeleteMapping("/{id}")
    public void eliminarCarreraAcademica(@PathVariable Long id) {
        carreraAcademicaRepository.eliminar(id);
    }
}
