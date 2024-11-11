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
public class BEnvio {

    private int envioid;
    private String origen;
    private String destino;
    private Date horasalida;
    private Date horallegada;
    private String tiempoentrega;
    private String conductor;
    private int numeropersonal;
    private String numerocelular;
    private String placavehiculo;
    private String tipovehiculo;
    private String observacion;
    private int certificadoid;
    private int tipoenvioid;

    public int getEnvioid() {
        return envioid;
    }

    public void setEnvioid(int envioid) {
        this.envioid = envioid;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Date horasalida) {
        this.horasalida = horasalida;
    }

    public Date getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(Date horallegada) {
        this.horallegada = horallegada;
    }

    public String getTiempoentrega() {
        return tiempoentrega;
    }

    public void setTiempoentrega(String tiempoentrega) {
        this.tiempoentrega = tiempoentrega;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public int getNumeropersonal() {
        return numeropersonal;
    }

    public void setNumeropersonal(int numeropersonal) {
        this.numeropersonal = numeropersonal;
    }

    public String getNumerocelular() {
        return numerocelular;
    }

    public void setNumerocelular(String numerocelular) {
        this.numerocelular = numerocelular;
    }

    public String getPlacavehiculo() {
        return placavehiculo;
    }

    public void setPlacavehiculo(String placavehiculo) {
        this.placavehiculo = placavehiculo;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCertificadoid() {
        return certificadoid;
    }

    public void setCertificadoid(int certificadoid) {
        this.certificadoid = certificadoid;
    }

    public int getTipoenvioid() {
        return tipoenvioid;
    }

    public void setTipoenvioid(int tipoenvioid) {
        this.tipoenvioid = tipoenvioid;
    }

}
