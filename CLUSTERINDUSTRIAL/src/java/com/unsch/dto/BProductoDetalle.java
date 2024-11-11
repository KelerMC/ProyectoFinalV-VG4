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
public class BProductoDetalle {

    private int productoid;
    private int variedadid;
    private int socioid;
    private String descripcion;
    private String imageurl;
    private String codigoproducto;

    private int personaid;
    private int idubigeo;
    private int nacionalidadid;
    private String nombrepersona;
    private String apepaterno;
    private String apmaterno;
    private int documentoidentidadid;
    private String numerodocumento;
    private String direccion;
    private String referenciadireccion;
    private String emailpersonal;
    private String nombrecompleto;
    private int idtipotelefono;
    private String numerotelefono;
    private Date fechanacimiento;
    private int tipopersonaid;
    private Date fecharegistro;
    private Date fechaactualizacion;

    private int almacenid;
    private int unidadmedidaid;
    private String almacen;
    private String unidadmedida;
    private String denominacion;

    private String imagen;
    private String estadovariedad;

    public int getProductoid() {
        return productoid;
    }

    public void setProductoid(int productoid) {
        this.productoid = productoid;
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

    public String getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(String codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public int getPersonaid() {
        return personaid;
    }

    public void setPersonaid(int personaid) {
        this.personaid = personaid;
    }

    public int getIdubigeo() {
        return idubigeo;
    }

    public void setIdubigeo(int idubigeo) {
        this.idubigeo = idubigeo;
    }

    public int getNacionalidadid() {
        return nacionalidadid;
    }

    public void setNacionalidadid(int nacionalidadid) {
        this.nacionalidadid = nacionalidadid;
    }

    public String getNombrepersona() {
        return nombrepersona;
    }

    public void setNombrepersona(String nombrepersona) {
        this.nombrepersona = nombrepersona;
    }

    public String getApepaterno() {
        return apepaterno;
    }

    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }

    public String getApmaterno() {
        return apmaterno;
    }

    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    public int getDocumentoidentidadid() {
        return documentoidentidadid;
    }

    public void setDocumentoidentidadid(int documentoidentidadid) {
        this.documentoidentidadid = documentoidentidadid;
    }

    public String getNumerodocumento() {
        return numerodocumento;
    }

    public void setNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getReferenciadireccion() {
        return referenciadireccion;
    }

    public void setReferenciadireccion(String referenciadireccion) {
        this.referenciadireccion = referenciadireccion;
    }

    public String getEmailpersonal() {
        return emailpersonal;
    }

    public void setEmailpersonal(String emailpersonal) {
        this.emailpersonal = emailpersonal;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public int getIdtipotelefono() {
        return idtipotelefono;
    }

    public void setIdtipotelefono(int idtipotelefono) {
        this.idtipotelefono = idtipotelefono;
    }

    public String getNumerotelefono() {
        return numerotelefono;
    }

    public void setNumerotelefono(String numerotelefono) {
        this.numerotelefono = numerotelefono;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getTipopersonaid() {
        return tipopersonaid;
    }

    public void setTipopersonaid(int tipopersonaid) {
        this.tipopersonaid = tipopersonaid;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Date getFechaactualizacion() {
        return fechaactualizacion;
    }

    public void setFechaactualizacion(Date fechaactualizacion) {
        this.fechaactualizacion = fechaactualizacion;
    }

    public int getAlmacenid() {
        return almacenid;
    }

    public void setAlmacenid(int almacenid) {
        this.almacenid = almacenid;
    }

    public int getUnidadmedidaid() {
        return unidadmedidaid;
    }

    public void setUnidadmedidaid(int unidadmedidaid) {
        this.unidadmedidaid = unidadmedidaid;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(String unidadmedida) {
        this.unidadmedida = unidadmedida;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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
}
