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
public class BDetalleCompraProducto {

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

    private int variedadid;
    private int socioid;
    private int sanidadid;
    private double precio;
    private int stock;
    private String descripcionP;
    private String imageurl;

    private String codigoproducto;

    private String denominacionV;
    private String descripcionV;
    private String imagen;
    private String estadovariedad;

    private String denominacionUM;
    private String estadounidadmedida;
    private String codigounidad;

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

    public int getSanidadid() {
        return sanidadid;
    }

    public void setSanidadid(int sanidadid) {
        this.sanidadid = sanidadid;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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

    public String getDenominacionV() {
        return denominacionV;
    }

    public void setDenominacionV(String denominacionV) {
        this.denominacionV = denominacionV;
    }

    public String getDescripcionV() {
        return descripcionV;
    }

    public void setDescripcionV(String descripcionV) {
        this.descripcionV = descripcionV;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstadovariedad() {
        return estadovariedad;
    }

    public void setEstadovariedad(String estadovariedad) {
        this.estadovariedad = estadovariedad;
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
}
