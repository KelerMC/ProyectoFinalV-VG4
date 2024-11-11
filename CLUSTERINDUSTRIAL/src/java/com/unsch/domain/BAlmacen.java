/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

import java.sql.Date;

/**
 *
 * @author ARANGO
 */
public class BAlmacen {

    private int almacenid;
    private int clusteresid;
    private String denominacion;
    private String descripcion;
    private String indestadoapertura;
    private Date fechaapertura;
    private String estadoalmacen;
    private String horareferencia;
    private int cantidadvia;
    private Double costotransporte;
    private String telefonoalmacen;

    public int getAlmacenid() {
        return almacenid;
    }

    public void setAlmacenid(int almacenid) {
        this.almacenid = almacenid;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
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

    public String getHorareferencia() {
        return horareferencia;
    }

    public void setHorareferencia(String horareferencia) {
        this.horareferencia = horareferencia;
    }

    public int getCantidadvia() {
        return cantidadvia;
    }

    public void setCantidadvia(int cantidadvia) {
        this.cantidadvia = cantidadvia;
    }

    public Double getCostotransporte() {
        return costotransporte;
    }

    public void setCostotransporte(Double costotransporte) {
        this.costotransporte = costotransporte;
    }

    public String getTelefonoalmacen() {
        return telefonoalmacen;
    }

    public void setTelefonoalmacen(String telefonoalmacen) {
        this.telefonoalmacen = telefonoalmacen;
    }
}