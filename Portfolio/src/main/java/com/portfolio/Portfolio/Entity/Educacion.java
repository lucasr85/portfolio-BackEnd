
package com.portfolio.Portfolio.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

/**
 *
 * @author Lucas Robles
 */

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;

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
    private String nivel;
    private String periodo;
    private String estado;
    private String logo;

    public Educacion(String nombreE, String descripcionE,String nivel, String periodo, String estado, String logo) {
       this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.nivel=nivel;
        this.periodo=periodo;
        this.logo=logo;
        this.estado=estado;
    }

    public Educacion() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
