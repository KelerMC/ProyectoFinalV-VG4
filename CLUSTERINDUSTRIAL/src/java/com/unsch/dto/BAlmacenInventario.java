/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.dto;

import java.sql.Date;

/**
 *
 * @author Morpheus
 */
public class BAlmacenInventario {

    private int inventarioid;
    private int almacenid;
    private int productoid;
    private int unidadmedidaid;
    private int tipodocumentoid;
    private int tipomovimientoid;
    private Date fechamovimiento;
    private int cantidad;
    private Double preciounitario;
    private Double preciototal;
    private String estadoinventario;

    private int clusteresid;
    private String denominacion;
    private String descripcion;
    private String indestadoapertura;
    private Date fechaapertura;
    private String estadoalmacen;

    private Double porcentaje;

    public int getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(int inventarioid) {
        this.inventarioid = inventarioid;
    }

    public int getAlmacenid() {
        return almacenid;
    }

    public void setAlmacenid(int almacenid) {
        this.almacenid = almacenid;
    }

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public int getUnidadmedidaid() {
        return unidadmedidaid;
    }

    public void setUnidadmedidaid(int unidadmedidaid) {
        this.unidadmedidaid = unidadmedidaid;
    }

    public int getTipodocumentoid() {
        return tipodocumentoid;
    }

    public void setTipodocumentoid(int tipodocumentoid) {
        this.tipodocumentoid = tipodocumentoid;
    }

    public int getTipomovimientoid() {
        return tipomovimientoid;
    }

    public void setTipomovimientoid(int tipomovimientoid) {
        this.tipomovimientoid = tipomovimientoid;
    }

    public Date getFechamovimiento() {
        return fechamovimiento;
    }

    public void setFechamovimiento(Date fechamovimiento) {
        this.fechamovimiento = fechamovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(Double preciounitario) {
        this.preciounitario = preciounitario;
    }

    public Double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(Double preciototal) {
        this.preciototal = preciototal;
    }

    public String getEstadoinventario() {
        return estadoinventario;
    }

    public void setEstadoinventario(String estadoinventario) {
        this.estadoinventario = estadoinventario;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
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

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
