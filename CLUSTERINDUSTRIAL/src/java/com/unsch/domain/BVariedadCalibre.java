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
public class BVariedadCalibre {

    private int variedadcalibreid;
    private int variedadid;
    private int calibresid;
    private String denominacion;
    private String rango;
    private String estado;
    private String peso;

    public int getVariedadcalibreid() {
        return variedadcalibreid;
    }

    public void setVariedadcalibreid(int variedadcalibreid) {
        this.variedadcalibreid = variedadcalibreid;
    }

    public int getVariedadid() {
        return variedadid;
    }

    public void setVariedadid(int variedadid) {
        this.variedadid = variedadid;
    }

    public int getCalibresid() {
        return calibresid;
    }

    public void setCalibresid(int calibresid) {
        this.calibresid = calibresid;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }
}
