/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.dto;

/**
 *
 * @author ARANGO
 */
public class BSanidadCalibre {

    private int calibresid;
    private String denominacionC;
    private String estadocalibresC;

    private int sanidadid;

    private String denominacionsanidadS;
    private String estadosanidadS;
    private int valorsanidad;

    public int getCalibresid() {
        return calibresid;
    }

    public void setCalibresid(int calibresid) {
        this.calibresid = calibresid;
    }

    public String getDenominacionC() {
        return denominacionC;
    }

    public void setDenominacionC(String denominacionC) {
        this.denominacionC = denominacionC;
    }

    public String getEstadocalibresC() {
        return estadocalibresC;
    }

    public void setEstadocalibresC(String estadocalibresC) {
        this.estadocalibresC = estadocalibresC;
    }

    public int getSanidadid() {
        return sanidadid;
    }

    public void setSanidadid(int sanidadid) {
        this.sanidadid = sanidadid;
    }

    public String getDenominacionsanidadS() {
        return denominacionsanidadS;
    }

    public void setDenominacionsanidadS(String denominacionsanidadS) {
        this.denominacionsanidadS = denominacionsanidadS;
    }

    public String getEstadosanidadS() {
        return estadosanidadS;
    }

    public void setEstadosanidadS(String estadosanidadS) {
        this.estadosanidadS = estadosanidadS;
    }

    public int getValorsanidad() {
        return valorsanidad;
    }

    public void setValorsanidad(int valorsanidad) {
        this.valorsanidad = valorsanidad;
    }

}
