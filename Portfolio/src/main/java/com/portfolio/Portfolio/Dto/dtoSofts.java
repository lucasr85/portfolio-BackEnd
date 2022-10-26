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
    private int porcentaje;

    public dtoSofts() {
    }

    public dtoSofts(String nombre, int porcentaje) {
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
