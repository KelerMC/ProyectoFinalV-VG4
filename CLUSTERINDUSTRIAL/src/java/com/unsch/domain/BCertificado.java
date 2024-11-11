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
public class BCertificado {

    private int certificadoid;
    private String codigocertificado;
    private int entidadgaranteid;
    private int responsableid;
    private int ordencompraid;
    private Date fechacertificacion;
    private int cantidad;
    private Double preciounitario;
    private Double costototal;
    private Double igv;
    private Double costotrasnporte;
    private Double precioventa;
    private String estadoresponsable;
    private String estadogarante;

    public int getCertificadoid() {
        return certificadoid;
    }

    public void setCertificadoid(int certificadoid) {
        this.certificadoid = certificadoid;
    }

    public String getCodigocertificado() {
        return codigocertificado;
    }

    public void setCodigocertificado(String codigocertificado) {
        this.codigocertificado = codigocertificado;
    }

    public int getEntidadgaranteid() {
        return entidadgaranteid;
    }

    public void setEntidadgaranteid(int entidadgaranteid) {
        this.entidadgaranteid = entidadgaranteid;
    }

    public int getResponsableid() {
        return responsableid;
    }

    public void setResponsableid(int responsableid) {
        this.responsableid = responsableid;
    }

    public int getOrdencompraid() {
        return ordencompraid;
    }

    public void setOrdencompraid(int ordencompraid) {
        this.ordencompraid = ordencompraid;
    }

    public Date getFechacertificacion() {
        return fechacertificacion;
    }

    public void setFechacertificacion(Date fechacertificacion) {
        this.fechacertificacion = fechacertificacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public Double getCostototal() {
        return costototal;
    }

    public void setCostototal(Double costototal) {
        this.costototal = costototal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getCostotrasnporte() {
        return costotrasnporte;
    }

    public void setCostotrasnporte(Double costotrasnporte) {
        this.costotrasnporte = costotrasnporte;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public String getEstadoresponsable() {
        return estadoresponsable;
    }

    public void setEstadoresponsable(String estadoresponsable) {
        this.estadoresponsable = estadoresponsable;
    }

    public String getEstadogarante() {
        return estadogarante;
    }

    public void setEstadogarante(String estadogarante) {
        this.estadogarante = estadogarante;
    }
}
