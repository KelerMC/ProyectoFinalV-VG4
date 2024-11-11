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
public class BDetalleOrdenCompra {

    private int ordencompraid;
    private int clienteid;
    private int inventarioid;
    private int cantidadOC;
    private Date fechaorden;
    private Date fechaaprobacion;
    private Double valorventa;
    private String estadoorden;
    private int monedaid;
    private String observacion;

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

    private int tipodocumentoid;
    private int tipomovimientoid;
    private Date fechamovimiento;
    private int cantidad;
    private Double preciounitario;
    private Double preciototal;
    private String estadoinventario;

    private String denominacion;
    private String estadounidadmedida;
    private String codigounidad;

    public int getOrdencompraid() {
        return ordencompraid;
    }

    public void setOrdencompraid(int ordencompraid) {
        this.ordencompraid = ordencompraid;
    }

    public int getClienteid() {
        return clienteid;
    }

    public void setClienteid(int clienteid) {
        this.clienteid = clienteid;
    }

    public int getInventarioid() {
        return inventarioid;
    }

    public void setInventarioid(int inventarioid) {
        this.inventarioid = inventarioid;
    }

    public int getCantidadOC() {
        return cantidadOC;
    }

    public void setCantidadOC(int cantidadOC) {
        this.cantidadOC = cantidadOC;
    }

    public Date getFechaorden() {
        return fechaorden;
    }

    public void setFechaorden(Date fechaorden) {
        this.fechaorden = fechaorden;
    }

    public Date getFechaaprobacion() {
        return fechaaprobacion;
    }

    public void setFechaaprobacion(Date fechaaprobacion) {
        this.fechaaprobacion = fechaaprobacion;
    }

    public Double getValorventa() {
        return valorventa;
    }

    public void setValorventa(Double valorventa) {
        this.valorventa = valorventa;
    }

    public String getEstadoorden() {
        return estadoorden;
    }

    public void setEstadoorden(String estadoorden) {
        this.estadoorden = estadoorden;
    }

    public int getMonedaid() {
        return monedaid;
    }

    public void setMonedaid(int monedaid) {
        this.monedaid = monedaid;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

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

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
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