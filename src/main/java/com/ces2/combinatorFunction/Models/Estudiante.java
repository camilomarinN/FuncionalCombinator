package com.ces2.combinatorFunction.Models;

import java.time.LocalDate;

public class Estudiante {
    private String nombre;
    private String Genero;
    private String email;
    private LocalDate fechaNacimiento;

    public Estudiante() {
    }

    public Estudiante(String nombre, String email, String genero, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.Genero = genero;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
