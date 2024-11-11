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
public class BSanidad {

    private int sanidadid;
    private int calibresid;
    private String denominacionsanidad;
    private String estadosanidad;
    private int valorsanidad;

    public int getSanidadid() {
        return sanidadid;
    }

    public void setSanidadid(int sanidadid) {
        this.sanidadid = sanidadid;
    }

    public int getCalibresid() {
        return calibresid;
    }

    public void setCalibresid(int calibresid) {
        this.calibresid = calibresid;
    }

    public String getDenominacionsanidad() {
        return denominacionsanidad;
    }

    public void setDenominacionsanidad(String denominacionsanidad) {
        this.denominacionsanidad = denominacionsanidad;
    }

    public String getEstadosanidad() {
        return estadosanidad;
    }

    public void setEstadosanidad(String estadosanidad) {
        this.estadosanidad = estadosanidad;
    }

    public int getValorsanidad() {
        return valorsanidad;
    }

    public void setValorsanidad(int valorsanidad) {
        this.valorsanidad = valorsanidad;
    }

}
