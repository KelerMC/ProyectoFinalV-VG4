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
public class BTipoEnvio {

    private int tipoenvioid;
    private String denominacionenvio;
    private Double costoenvio;
    private int numerovehiculo;

    public int getTipoenvioid() {
        return tipoenvioid;
    }

    public void setTipoenvioid(int tipoenvioid) {
        this.tipoenvioid = tipoenvioid;
    }

    public String getDenominacionenvio() {
        return denominacionenvio;
    }

    public void setDenominacionenvio(String denominacionenvio) {
        this.denominacionenvio = denominacionenvio;
    }

    public Double getCostoenvio() {
        return costoenvio;
    }

    public void setCostoenvio(Double costoenvio) {
        this.costoenvio = costoenvio;
    }

    public int getNumerovehiculo() {
        return numerovehiculo;
    }

    public void setNumerovehiculo(int numerovehiculo) {
        this.numerovehiculo = numerovehiculo;
    }
}
