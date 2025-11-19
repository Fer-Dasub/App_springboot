package com.App.crud.domain.repository;

import java.util.List;
import java.util.Optional;

import com.App.crud.domain.model.CarreraAcademica;

public interface CarreraAcademicaRepositoryPort {
    CarreraAcademica save(CarreraAcademica carreraAcademica);
    List<CarreraAcademica> findAll();
    Optional<CarreraAcademica> findById(Long id);
    void deleteById(Long id);
}