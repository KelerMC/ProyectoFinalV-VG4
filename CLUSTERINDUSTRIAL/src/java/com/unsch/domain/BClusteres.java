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
public class BClusteres {

    private int clusteresid;
    private int ubigeoid;
    private String ubigeo;
    private String denominacion;
    private String descripcion;
    private String estadoclusteres;

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    public int getUbigeoid() {
        return ubigeoid;
    }

    public void setUbigeoid(int ubigeoid) {
        this.ubigeoid = ubigeoid;
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

    public String getEstadoclusteres() {
        return estadoclusteres;
    }

    public void setEstadoclusteres(String estadoclusteres) {
        this.estadoclusteres = estadoclusteres;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }
}
