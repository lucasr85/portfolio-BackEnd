
package com.portfolio.Portfolio.Dto;

/**
 *
 * @author Lucas Robles
 */


import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class dtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String nivel;    
    @NotBlank
    private String periodo;
    @NotBlank
    private String estado;
    @NotBlank
    private String logo;
    
    public dtoEducacion(String nombreE, String descripcionE,String nivel, String periodo, String estado, String logo) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;        
        this.nivel = nivel;        
        this.periodo = periodo;
        this.estado = estado;
        this.logo = logo;
    }   

    public dtoEducacion() {
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }


}
