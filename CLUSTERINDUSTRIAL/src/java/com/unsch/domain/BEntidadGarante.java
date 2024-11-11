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
public class BEntidadGarante {

    private int entidadgaranteid;
    private int clusteresid;
    private String nombreentidad;
    private String telefenofijo;
    private String representante;
    private String cargo;

    public int getEntidadgaranteid() {
        return entidadgaranteid;
    }

    public void setEntidadgaranteid(int entidadgaranteid) {
        this.entidadgaranteid = entidadgaranteid;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    public String getTelefenofijo() {
        return telefenofijo;
    }

    public void setTelefenofijo(String telefenofijo) {
        this.telefenofijo = telefenofijo;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
