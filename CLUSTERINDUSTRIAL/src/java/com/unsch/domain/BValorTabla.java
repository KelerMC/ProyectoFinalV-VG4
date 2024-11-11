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
public class BValorTabla {

    private int tablaid;
    private int itemid;
    private String denominacion;
    private String descorta;
    private String valor;

    public int getTablaid() {
        return tablaid;
    }

    public void setTablaid(int tablaid) {
        this.tablaid = tablaid;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescorta() {
        return descorta;
    }

    public void setDescorta(String descorta) {
        this.descorta = descorta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
