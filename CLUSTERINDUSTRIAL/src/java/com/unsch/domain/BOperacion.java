/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

import java.sql.Date;

/**
 *
 * @author ARANGO
 */
public class BOperacion {

    private int operacionid;
    private String denominacionoperacion;
    private Date fecharegistro;
    private Date fechaactualizacion;
    private String estadooperacion;

    public int getOperacionid() {
        return operacionid;
    }

    public void setOperacionid(int operacionid) {
        this.operacionid = operacionid;
    }

    public String getDenominacionoperacion() {
        return denominacionoperacion;
    }

    public void setDenominacionoperacion(String denominacionoperacion) {
        this.denominacionoperacion = denominacionoperacion;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public String getEstadooperacion() {
        return estadooperacion;
    }

    public void setEstadooperacion(String estadooperacion) {
        this.estadooperacion = estadooperacion;
    }
}
