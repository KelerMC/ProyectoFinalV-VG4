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
public class BDetalleVariedad {

    private int variedadid;
    private int almacenid;
    private String denominacion;
    private String descripcion;
    private String imagen;
    private String estadovariedad;
    private int cantidad;

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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
