package com.App.crud.domain.repository;

import java.util.List;
import java.util.Optional;

import com.App.crud.domain.model.CarreraAcademica;

public interface CarreraAcademicaRepositoryPort {
    List<CarreraAcademica> listar();
    Optional<CarreraAcademica> BuscarPorId(Long id);
    CarreraAcademica guardar(CarreraAcademica carreraAcademica);
    void eliminar(Long id);
}