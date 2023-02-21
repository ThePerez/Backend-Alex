package com.portfolio.alex_Project.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    
    
}
