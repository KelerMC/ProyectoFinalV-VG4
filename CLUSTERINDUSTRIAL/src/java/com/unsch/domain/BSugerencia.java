/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

import java.sql.Date;

/**
 *
 * @author hp
 */
public class BSugerencia {

    private int sugerenciaid;
    private int clienteid;
    private int clusteresid;
    private String textosugerencia;
    private Date fechasugerencia;
    private String clasificacion;

    /**
     * @return the sugerenciaid
     */
    public int getSugerenciaid() {
        return sugerenciaid;
    }

    /**
     * @param sugerenciaid the sugerenciaid to set
     */
    public void setSugerenciaid(int sugerenciaid) {
        this.sugerenciaid = sugerenciaid;
    }

    /**
     * @return the clienteid
     */
    public int getClienteid() {
        return clienteid;
    }

    /**
     * @param clienteid the clienteid to set
     */
    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    /**
     * @return the clusteresid
     */
    public int getClusteresid() {
        return clusteresid;
    }

    /**
     * @param clusteresid the clusteresid to set
     */
    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    /**
     * @return the textosugerencia
     */
    public String getTextosugerencia() {
        return textosugerencia;
    }

    /**
     * @param textosugerencia the textosugerencia to set
     */
    public void setTextosugerencia(String textosugerencia) {
        this.textosugerencia = textosugerencia;
    }

    /**
     * @return the fechasugerencia
     */
    public Date getFechasugerencia() {
        return fechasugerencia;
    }

    /**
     * @param fechasugerencia the fechasugerencia to set
     */
    public void setFechasugerencia(Date fechasugerencia) {
        this.fechasugerencia = fechasugerencia;
    }

    /**
     * @return the clasificacion
     */
    public String getClasificacion() {
        return clasificacion;
    }

    /**
     * @param clasificacion the clasificacion to set
     */
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
