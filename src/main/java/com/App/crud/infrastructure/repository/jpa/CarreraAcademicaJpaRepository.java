package com.App.crud.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.App.crud.infrastructure.repository.entity.CarreraAcademicaEntity;

public interface CarreraAcademicaJpaRepository extends JpaRepository<CarreraAcademicaEntity, Long> {
}