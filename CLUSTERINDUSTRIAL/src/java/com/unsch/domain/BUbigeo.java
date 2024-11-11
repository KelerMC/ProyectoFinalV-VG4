/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

import java.sql.Date;

/**
 *
 * @author 
 */
public class BUbigeo {

    private int ubigeoid;
    private String descripcion;
    private String coddpto;
    private String codprov;
    private String coddist;
    private Date fecharegistro;
    private Date fechaactualizacion;

    public int getUbigeoid() {
        return ubigeoid;
    }

    public void setUbigeoid(int ubigeoid) {
        this.ubigeoid = ubigeoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCoddpto() {
        return coddpto;
    }

    public void setCoddpto(String coddpto) {
        this.coddpto = coddpto;
    }

    public String getCodprov() {
        return codprov;
    }

    public void setCodprov(String codprov) {
        this.codprov = codprov;
    }

    public String getCoddist() {
        return coddist;
    }

    public void setCoddist(String coddist) {
        this.coddist = coddist;
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
}
