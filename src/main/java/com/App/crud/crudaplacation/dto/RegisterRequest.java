package com.App.crud.crudaplacation.dto;

public record RegisterRequest(
        String nombre,
        String email,
        String password
) {}