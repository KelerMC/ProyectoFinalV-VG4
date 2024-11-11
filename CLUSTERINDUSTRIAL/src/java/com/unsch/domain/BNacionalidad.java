/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

/**
 *
 * @author ARANGO
 */
public class BNacionalidad {

    private int nacionalidadid;
    private String codigonacionalidad;
    private String denominacion;
    private String estadonacionalidad;

    public int getNacionalidadid() {
        return nacionalidadid;
    }

    public void setNacionalidadid(int nacionalidadid) {
        this.nacionalidadid = nacionalidadid;
    }

    public String getCodigonacionalidad() {
        return codigonacionalidad;
    }

    public void setCodigonacionalidad(String codigonacionalidad) {
        this.codigonacionalidad = codigonacionalidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getEstadonacionalidad() {
        return estadonacionalidad;
    }

    public void setEstadonacionalidad(String estadonacionalidad) {
        this.estadonacionalidad = estadonacionalidad;
    }
}
