package com.App.crud.infrastructure.repository.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.App.crud.domain.model.CarreraAcademica;
import com.App.crud.domain.repository.CarreraAcademicaRepositoryPort;
import com.App.crud.infrastructure.repository.entity.CarreraAcademicaEntity;
import com.App.crud.infrastructure.repository.jpa.CarreraAcademicaJpaRepository;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class CarreraAcademicaRepositoryAdapter implements CarreraAcademicaRepositoryPort {

    private final CarreraAcademicaJpaRepository jpaRepository;

    @Override
    public CarreraAcademica guardar(CarreraAcademica carrera) {
        CarreraAcademicaEntity entity = new CarreraAcademicaEntity();
        entity.setId(carrera.getId());
        entity.setNombre(carrera.getNombre());

        CarreraAcademicaEntity saved = jpaRepository.save(entity);

        return new CarreraAcademica(saved.getId(), saved.getNombre());
    }

    @Override
    public List<CarreraAcademica> Listar() {
        return jpaRepository.findAll()
            .stream()
            .map(e -> new CarreraAcademica(e.getId(), e.getNombre()))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<CarreraAcademica> BuscarPorId(Long id) {
        return jpaRepository.findById(id)
            .map(e -> new CarreraAcademica(e.getId(), e.getNombre()));
    }

       @Override
    public void eliminar(Long id) {
        jpaRepository.deleteById(id);
    }
}