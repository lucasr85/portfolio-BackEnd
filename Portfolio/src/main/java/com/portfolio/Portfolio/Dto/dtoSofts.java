package com.portfolio.Portfolio.Dto;


/**
 *
 * @author Lucas Robles
 */

import javax.validation.constraints.NotBlank;


public class dtoSofts {
    @NotBlank
    private String nombre;
    @NotBlank
    private String porcentaje;

    public dtoSofts() {
    }

    public dtoSofts(String nombre, String porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }        
}
