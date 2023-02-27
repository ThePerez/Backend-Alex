package com.portfolio.alex_Project.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyectos {
    @NotBlank
    private String nombre;
    @NotBlank
    private String img;
    @NotBlank
    private String descripcion;

    public DtoProyectos() {
    }

    public DtoProyectos(String nombre, String img, String descripcion) {
        this.nombre = nombre;
        this.img = img;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
