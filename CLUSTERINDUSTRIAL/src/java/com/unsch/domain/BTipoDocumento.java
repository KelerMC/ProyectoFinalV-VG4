/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

/**
 *
 * @author SISTEMAS
 */
public class BTipoDocumento {

    private int tipodocumentoid;
    private String denominacion;
    private String descripcion;
    private String indventa;
    private String indalmacen;
    private String indalmacenmov;
    private String estadotipodocumento;

    public int getTipodocumentoid() {
        return tipodocumentoid;
    }

    public void setTipodocumentoid(int tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIndventa() {
        return indventa;
    }

    public void setIndventa(String indventa) {
        this.indventa = indventa;
    }

    public String getIndalmacen() {
        return indalmacen;
    }

    public void setIndalmacen(String indalmacen) {
        this.indalmacen = indalmacen;
    }

    public String getIndalmacenmov() {
        return indalmacenmov;
    }

    public void setIndalmacenmov(String indalmacenmov) {
        this.indalmacenmov = indalmacenmov;
    }

    public String getEstadotipodocumento() {
        return estadotipodocumento;
    }

    public void setEstadotipodocumento(String estadotipodocumento) {
        this.estadotipodocumento = estadotipodocumento;
    }
}
