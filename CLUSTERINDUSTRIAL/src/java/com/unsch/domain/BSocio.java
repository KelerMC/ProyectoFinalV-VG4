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
public class BSocio {

    private int socioid;
    private int personaid;
    private int clusteresid;
    private String clusteres;
    private String persona;
    // private String fechacancelacion;
    private Date fechacancelacion;
    private String obscancelacion;
    private int indiceestado;
    //private String fechasuspencion;
    private Date fechasuspencion;
    private String obssuspencion;
    private int estadocuenta;
    private Date fecharegistro;
    private Date fechaactualizacion;

    public int getSocioid() {
        return socioid;
    }

    public void setSocioid(int socioid) {
        this.socioid = socioid;
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    public String getClusteres() {
        return clusteres;
    }

    public void setClusteres(String clusteres) {
        this.clusteres = clusteres;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public Date getFechacancelacion() {
        return fechacancelacion;
    }

    public void setFechacancelacion(Date fechacancelacion) {
        this.fechacancelacion = fechacancelacion;
    }

    public String getObscancelacion() {
        return obscancelacion;
    }

    public void setObscancelacion(String obscancelacion) {
        this.obscancelacion = obscancelacion;
    }

    public int getIndiceestado() {
        return indiceestado;
    }

    public void setIndiceestado(int indiceestado) {
        this.indiceestado = indiceestado;
    }

    public Date getFechasuspencion() {
        return fechasuspencion;
    }

    public void setFechasuspencion(Date fechasuspencion) {
        this.fechasuspencion = fechasuspencion;
    }

    public String getObssuspencion() {
        return obssuspencion;
    }

    public void setObssuspencion(String obssuspencion) {
        this.obssuspencion = obssuspencion;
    }

    public int getEstadocuenta() {
        return estadocuenta;
    }

    public void setEstadocuenta(int estadocuenta) {
        this.estadocuenta = estadocuenta;
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

//    public String getFechacancelacion() {
//        return fechacancelacion;
//    }
//
//    public void setFechacancelacion(String fechacancelacion) {
//        this.fechacancelacion = fechacancelacion;
//    }
//
//    public String getFechasuspencion() {
//        return fechasuspencion;
//    }
//
//    public void setFechasuspencion(String fechasuspencion) {
//        this.fechasuspencion = fechasuspencion;
//    }
}
