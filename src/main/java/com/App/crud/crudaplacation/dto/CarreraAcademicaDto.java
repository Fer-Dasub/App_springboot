package com.App.crud.crudaplacation.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CarreraAcademicaDto {
    private Long id;
    private String nombre;
    private Integer numCreditos;
    private Integer numAsignaturas;
    private Integer numSemestres;
    private String nivelFormacion;
    private String titulo;
    private BigDecimal valorSemestre;
    private String universidad;
    private Boolean esAcreditada;
    private String perfiles;
    private String areaConocimiento;
    private LocalDateTime creadoEn;
    private LocalDateTime actualizadoEn;
}