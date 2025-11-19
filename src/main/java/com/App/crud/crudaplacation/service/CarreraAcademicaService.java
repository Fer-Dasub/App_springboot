package com.App.crud.crudaplacation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.App.crud.domain.model.CarreraAcademica;
import com.App.crud.domain.repository.CarreraAcademicaRepositoryPort;

@Service
public class CarreraAcademicaService{
    private final CarreraAcademicaRepositoryPort port;

    public CarreraAcademicaService(CarreraAcademicaRepositoryPort port) {
        this.port = port;
    }

    public CarreraAcademica crear(CarreraAcademica carreraAcademica) {
        return port.save(carreraAcademica);
    }

    public List<CarreraAcademica> listar() {
        return port.findAll();
    }

    public Optional<CarreraAcademica> buscar(Long id) {
        return port.findById(id);
    }

    public CarreraAcademica actualizar(Long id, CarreraAcademica c) {
        CarreraAcademica actual = port.findById(id).orElseThrow(() -> new RuntimeException("CarreraAcademica no encontrada"));
        actual.setNombre(c.getNombre());
        actual.setNumCreditos(c.getNumCreditos());
        actual.setNumAsignaturas(c.getNumAsignaturas());
        actual.setNumSemestres(c.getNumSemestres());
        actual.setNivelFormacion(c.getNivelFormacion());
        actual.setTitulo(c.getTitulo());
        actual.setValorSemestre(c.getValorSemestre());
        actual.setUniversidad(c.getUniversidad());
        actual.setEsAcreditada(c.getEsAcreditada());
        actual.setPerfiles(c.getPerfiles());
        actual.setAreaConocimiento(c.getAreaConocimiento());
        return port.save(actual);
    }

    public void eliminar(Long id) {
        port.deleteById(id);
    }
}