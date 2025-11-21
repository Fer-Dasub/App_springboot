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
        return port.guardar(carreraAcademica);
    }

    public List<CarreraAcademica> listar() {
        return port.listar();
    }

    public Optional<CarreraAcademica> buscar(Long id) {
        return port.BuscarPorId(id);
    }

  

    public void eliminar(Long id) {
        port.eliminar(id);
    }
}