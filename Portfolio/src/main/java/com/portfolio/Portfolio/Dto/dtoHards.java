package com.portfolio.Portfolio.Dto;


/**
 *
 * @author Lucas Robles
 */

import javax.validation.constraints.NotBlank;


public class dtoHards {
    @NotBlank
    private String nombre;
    @NotBlank
    private String porcentaje;

    public dtoHards() {
    }

    public dtoHards(String nombre, String porcentaje) {
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
