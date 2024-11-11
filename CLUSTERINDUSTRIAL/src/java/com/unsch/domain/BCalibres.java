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
public class BCalibres {

    private int calibresid;
    private String denominacion;
    private String estadocalibres;

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

    public String getEstadocalibres() {
        return estadocalibres;
    }

    public void setEstadocalibres(String estadocalibres) {
        this.estadocalibres = estadocalibres;
    }
}
