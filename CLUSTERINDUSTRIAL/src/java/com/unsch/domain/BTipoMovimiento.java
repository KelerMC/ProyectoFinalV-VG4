/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.domain;

/**
 *
 * @author Morpheus
 */
public class BTipoMovimiento {

    private int tipomovimientoid;
    private String denominacion;
    private String descripcion;
    private String indentrada;
    private String indtransferencia;
    private String inddevolucion;
    private String estadotipomovimiento;

    public int getTipomovimientoid() {
        return tipomovimientoid;
    }

    public void setTipomovimientoid(int tipomovimientoid) {
        this.tipomovimientoid = tipomovimientoid;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIndentrada() {
        return indentrada;
    }

    public void setIndentrada(String indentrada) {
        this.indentrada = indentrada;
    }

    public String getIndtransferencia() {
        return indtransferencia;
    }

    public void setIndtransferencia(String indtransferencia) {
        this.indtransferencia = indtransferencia;
    }

    public String getInddevolucion() {
        return inddevolucion;
    }

    public void setInddevolucion(String inddevolucion) {
        this.inddevolucion = inddevolucion;
    }

    public String getEstadotipomovimiento() {
        return estadotipomovimiento;
    }

    public void setEstadotipomovimiento(String estadotipomovimiento) {
        this.estadotipomovimiento = estadotipomovimiento;
    }
}
