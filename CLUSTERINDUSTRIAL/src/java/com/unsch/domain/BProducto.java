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
public class BProducto {

    private int productoid;
    private int variedadcalibreid;
    private int socioid;
    private int sanidadid;
    private double precio;
    private int stock;
    private String descripcion;
    private String imageurl;
    private int unidadmedidaid;
    private String codigoproducto;

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
    }

    public int getVariedadcalibreid() {
        return variedadcalibreid;
    }

    public void setVariedadcalibreid(int variedadcalibreid) {
        this.variedadcalibreid = variedadcalibreid;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getUnidadmedidaid() {
        return unidadmedidaid;
    }

    public void setUnidadmedidaid(int unidadmedidaid) {
        this.unidadmedidaid = unidadmedidaid;
    }

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

}
