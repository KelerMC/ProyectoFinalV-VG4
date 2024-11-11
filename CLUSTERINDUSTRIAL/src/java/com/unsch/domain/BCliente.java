/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

/**
 *
 * @author SISTEMAS
 */
public class BCliente {

    private int clienteid;
    private int personaid;
    private String codigopostal;
    private String region;
    private String nombrecliente;
    private String clavecliente;
    private String estadocliente;

    private int existe;
    private String nombrecompleto;

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    public String getCodigopostal() {
        return codigopostal;
    }

    public void setCodigopostal(String codigopostal) {
        this.codigopostal = codigopostal;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getClavecliente() {
        return clavecliente;
    }

    public void setClavecliente(String clavecliente) {
        this.clavecliente = clavecliente;
    }

    public String getEstadocliente() {
        return estadocliente;
    }

    public void setEstadocliente(String estadocliente) {
        this.estadocliente = estadocliente;
    }

    public int getExiste() {
        return existe;
    }

    public void setExiste(int existe) {
        this.existe = existe;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }
}
