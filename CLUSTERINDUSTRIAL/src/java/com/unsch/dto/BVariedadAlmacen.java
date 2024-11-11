/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.dto;

import java.sql.Date;

/**
 *
 * @author ARANGO
 */
public class BVariedadAlmacen {

    private int variedadid;
    private int almacenid;
    private String denominacionV;
    private String descripcionV;
    private String imagen;
    private String estadovariedad;

    private int clusteresid;
    private String denominacionA;
    private String descripcionA;
    private String indestadoapertura;
    private Date fechaapertura;
    private String estadoalmacen;

    public int getVariedadid() {
        return variedadid;
    }

    public void setVariedadid(int variedadid) {
        this.variedadid = variedadid;
    }

    public int getAlmacenid() {
        return almacenid;
    }

    public void setAlmacenid(int almacenid) {
        this.almacenid = almacenid;
    }

    public String getDenominacionV() {
        return denominacionV;
    }

    public void setDenominacionV(String denominacionV) {
        this.denominacionV = denominacionV;
    }

    public String getDescripcionV() {
        return descripcionV;
    }

    public void setDescripcionV(String descripcionV) {
        this.descripcionV = descripcionV;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstadovariedad() {
        return estadovariedad;
    }

    public void setEstadovariedad(String estadovariedad) {
        this.estadovariedad = estadovariedad;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    public String getDenominacionA() {
        return denominacionA;
    }

    public void setDenominacionA(String denominacionA) {
        this.denominacionA = denominacionA;
    }

    public String getDescripcionA() {
        return descripcionA;
    }

    public void setDescripcionA(String descripcionA) {
        this.descripcionA = descripcionA;
    }

    public String getIndestadoapertura() {
        return indestadoapertura;
    }

    public void setIndestadoapertura(String indestadoapertura) {
        this.indestadoapertura = indestadoapertura;
    }

    public Date getFechaapertura() {
        return fechaapertura;
    }

    public void setFechaapertura(Date fechaapertura) {
        this.fechaapertura = fechaapertura;
    }

    public String getEstadoalmacen() {
        return estadoalmacen;
    }

    public void setEstadoalmacen(String estadoalmacen) {
        this.estadoalmacen = estadoalmacen;
    }

}
