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
public class BResponsable {

    private int responsableid;
    private int socioid;
    private int clusteresid;
    private Date fechainicio;
    private Date fechafin;
    private String estadoresponsable;

    public int getResponsableid() {
        return responsableid;
    }

    public void setResponsableid(int responsableid) {
        this.responsableid = responsableid;
    }

    public int getSocioid() {
        return socioid;
    }

    public void setSocioid(int socioid) {
        this.socioid = socioid;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public String getEstadoresponsable() {
        return estadoresponsable;
    }

    public void setEstadoresponsable(String estadoresponsable) {
        this.estadoresponsable = estadoresponsable;
    }
}
