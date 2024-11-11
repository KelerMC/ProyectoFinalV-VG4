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
public class BAlmacenCluster {

    private int almacenid;
    private int clusteresid;
    private String denominacionA;
    private String descripcionA;
    private String indestadoapertura;
    private Date fechaapertura;
    private String estadoalmacen;
    private int horareferencia;
    private int cantidadvia;
    private Double costotransporte;

    private int ubigeoid;
    private String ubigeo;
    private String denominacionC;
    private String descripcionC;
    private String estadoclusteres;

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

    public int getHorareferencia() {
        return horareferencia;
    }

    public void setHorareferencia(int horareferencia) {
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

    public int getUbigeoid() {
        return ubigeoid;
    }

    public void setUbigeoid(int ubigeoid) {
        this.ubigeoid = ubigeoid;
    }

    public String getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(String ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDenominacionC() {
        return denominacionC;
    }

    public void setDenominacionC(String denominacionC) {
        this.denominacionC = denominacionC;
    }

    public String getDescripcionC() {
        return descripcionC;
    }

    public void setDescripcionC(String descripcionC) {
        this.descripcionC = descripcionC;
    }

    public String getEstadoclusteres() {
        return estadoclusteres;
    }

    public void setEstadoclusteres(String estadoclusteres) {
        this.estadoclusteres = estadoclusteres;
    }
}
