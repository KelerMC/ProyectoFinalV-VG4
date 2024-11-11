/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.dto;

import java.sql.Date;

/**
 *
 * @author ARANGO
 */
public class BDetalleInventario {

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
    private String denominacionA;
    private String descripcionA;
    private String indestadoapertura;
    private Date fechaapertura;
    private String estadoalmacen;

    private int variedadid;
    private int socioid;
    private String descripcionP;
    private String imageurl;
    private String codigoproducto;

    private String denominacionUM;
    private String estadounidadmedida;
    private String codigounidad;

    private String denominacionTD;
    private String descripcionTD;
    private String indventa;
    private String indalmacen;
    private String indalmacenmov;
    private String estadotipodocumento;

    private String denominacionTM;
    private String descripcionTM;
    private String indentrada;
    private String indtransferencia;
    private String inddevolucion;
    private String estadotipomovimiento;

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

    public String getDenominacionA() {
        return denominacionA;
    }

    public void setDenominacionA(String denominacionA) {
        this.denominacionA = denominacionA;
    }

    public String getDescripcionA() {
        return descripcionA;
    }

    public void setDescripcionA(String descripcionA) {
        this.descripcionA = descripcionA;
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

    public int getVariedadid() {
        return variedadid;
    }

    public void setVariedadid(int variedadid) {
        this.variedadid = variedadid;
    }

    public int getSocioid() {
        return socioid;
    }

    public void setSocioid(int socioid) {
        this.socioid = socioid;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getDenominacionUM() {
        return denominacionUM;
    }

    public void setDenominacionUM(String denominacionUM) {
        this.denominacionUM = denominacionUM;
    }

    public String getEstadounidadmedida() {
        return estadounidadmedida;
    }

    public void setEstadounidadmedida(String estadounidadmedida) {
        this.estadounidadmedida = estadounidadmedida;
    }

    public String getCodigounidad() {
        return codigounidad;
    }

    public void setCodigounidad(String codigounidad) {
        this.codigounidad = codigounidad;
    }

    public String getDenominacionTD() {
        return denominacionTD;
    }

    public void setDenominacionTD(String denominacionTD) {
        this.denominacionTD = denominacionTD;
    }

    public String getDescripcionTD() {
        return descripcionTD;
    }

    public void setDescripcionTD(String descripcionTD) {
        this.descripcionTD = descripcionTD;
    }

    public String getIndventa() {
        return indventa;
    }

    public void setIndventa(String indventa) {
        this.indventa = indventa;
    }

    public String getIndalmacen() {
        return indalmacen;
    }

    public void setIndalmacen(String indalmacen) {
        this.indalmacen = indalmacen;
    }

    public String getIndalmacenmov() {
        return indalmacenmov;
    }

    public void setIndalmacenmov(String indalmacenmov) {
        this.indalmacenmov = indalmacenmov;
    }

    public String getEstadotipodocumento() {
        return estadotipodocumento;
    }

    public void setEstadotipodocumento(String estadotipodocumento) {
        this.estadotipodocumento = estadotipodocumento;
    }

    public String getDenominacionTM() {
        return denominacionTM;
    }

    public void setDenominacionTM(String denominacionTM) {
        this.denominacionTM = denominacionTM;
    }

    public String getDescripcionTM() {
        return descripcionTM;
    }

    public void setDescripcionTM(String descripcionTM) {
        this.descripcionTM = descripcionTM;
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
