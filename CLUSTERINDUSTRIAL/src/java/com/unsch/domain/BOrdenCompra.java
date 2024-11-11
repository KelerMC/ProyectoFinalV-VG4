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
public class BOrdenCompra {

    private int ordencompraid;
    private int clienteid;
    private int inventarioid;
    private int cantidad;
    private Date fechaorden;
    private Date fechaaprobacion;
    private Double valorventa;
    private String estadoorden;
    private int monedaid;
    private String observacion;

    public int getOrdencompraid() {
        return ordencompraid;
    }

    public void setOrdencompraid(int ordencompraid) {
        this.ordencompraid = ordencompraid;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(int inventarioid) {
        this.inventarioid = inventarioid;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public Double getValorventa() {
        return valorventa;
    }

    public void setValorventa(Double valorventa) {
        this.valorventa = valorventa;
    }

    public String getEstadoorden() {
        return estadoorden;
    }

    public void setEstadoorden(String estadoorden) {
        this.estadoorden = estadoorden;
    }

    public int getMonedaid() {
        return monedaid;
    }

    public void setMonedaid(int monedaid) {
        this.monedaid = monedaid;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
