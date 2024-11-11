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
public class BMovimiento {

    private int movimientoid;
    private int operacionid;
    private Double subtotal;
    private Double ajusteredondeo;
    private Double totalimporte;
    private String glosa;
    private int monedaid;
    private int extorno;
    private String boucher;
    private Date fecharegistro;
    private Double amortizacionpagado;
    private int certificadoid;
    private String cci;
    private String numerotransaccion;
    private Date fechatransaccion;

    public int getMovimientoid() {
        return movimientoid;
    }

    public void setMovimientoid(int movimientoid) {
        this.movimientoid = movimientoid;
    }

    public int getOperacionid() {
        return operacionid;
    }

    public void setOperacionid(int operacionid) {
        this.operacionid = operacionid;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getAjusteredondeo() {
        return ajusteredondeo;
    }

    public void setAjusteredondeo(Double ajusteredondeo) {
        this.ajusteredondeo = ajusteredondeo;
    }

    public Double getTotalimporte() {
        return totalimporte;
    }

    public void setTotalimporte(Double totalimporte) {
        this.totalimporte = totalimporte;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public int getMonedaid() {
        return monedaid;
    }

    public void setMonedaid(int monedaid) {
        this.monedaid = monedaid;
    }

    public int getExtorno() {
        return extorno;
    }

    public void setExtorno(int extorno) {
        this.extorno = extorno;
    }

    public String getBoucher() {
        return boucher;
    }

    public void setBoucher(String boucher) {
        this.boucher = boucher;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Double getAmortizacionpagado() {
        return amortizacionpagado;
    }

    public void setAmortizacionpagado(Double amortizacionpagado) {
        this.amortizacionpagado = amortizacionpagado;
    }

    public int getCertificadoid() {
        return certificadoid;
    }

    public void setCertificadoid(int certificadoid) {
        this.certificadoid = certificadoid;
    }

    public String getCci() {
        return cci;
    }

    public void setCci(String cci) {
        this.cci = cci;
    }

    public String getNumerotransaccion() {
        return numerotransaccion;
    }

    public void setNumerotransaccion(String numerotransaccion) {
        this.numerotransaccion = numerotransaccion;
    }

    public Date getFechatransaccion() {
        return fechatransaccion;
    }

    public void setFechatransaccion(Date fechatransaccion) {
        this.fechatransaccion = fechatransaccion;
    }

}
