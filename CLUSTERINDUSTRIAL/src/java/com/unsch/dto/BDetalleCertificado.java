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
public class BDetalleCertificado {

    private int certificadoid;
    private String codigocertificado;
    private int entidadgaranteid;
    private int responsableid;
    private int ordencompraid;
    private Date fechacertificacion;
    private int cantidad;
    private Double preciounitario;
    private Double costototal;
    private Double igv;
    private Double costotrasnporte;
    private Double precioventa;
    private String estadoresponsable;
    private String estadogarante;
    private String estadopagoC;

    private int clusteresid;
    private String nombreentidad;
    private String telefenofijo;
    private String representante;
    private String cargo;

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

    public int getCertificadoid() {
        return certificadoid;
    }

    public void setCertificadoid(int certificadoid) {
        this.certificadoid = certificadoid;
    }

    public String getCodigocertificado() {
        return codigocertificado;
    }

    public void setCodigocertificado(String codigocertificado) {
        this.codigocertificado = codigocertificado;
    }

    public int getEntidadgaranteid() {
        return entidadgaranteid;
    }

    public void setEntidadgaranteid(int entidadgaranteid) {
        this.entidadgaranteid = entidadgaranteid;
    }

    public int getResponsableid() {
        return responsableid;
    }

    public void setResponsableid(int responsableid) {
        this.responsableid = responsableid;
    }

    public int getOrdencompraid() {
        return ordencompraid;
    }

    public void setOrdencompraid(int ordencompraid) {
        this.ordencompraid = ordencompraid;
    }

    public Date getFechacertificacion() {
        return fechacertificacion;
    }

    public void setFechacertificacion(Date fechacertificacion) {
        this.fechacertificacion = fechacertificacion;
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

    public Double getCostototal() {
        return costototal;
    }

    public void setCostototal(Double costototal) {
        this.costototal = costototal;
    }

    public Double getIgv() {
        return igv;
    }

    public void setIgv(Double igv) {
        this.igv = igv;
    }

    public Double getCostotrasnporte() {
        return costotrasnporte;
    }

    public void setCostotrasnporte(Double costotrasnporte) {
        this.costotrasnporte = costotrasnporte;
    }

    public Double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(Double precioventa) {
        this.precioventa = precioventa;
    }

    public String getEstadoresponsable() {
        return estadoresponsable;
    }

    public void setEstadoresponsable(String estadoresponsable) {
        this.estadoresponsable = estadoresponsable;
    }

    public String getEstadogarante() {
        return estadogarante;
    }

    public void setEstadogarante(String estadogarante) {
        this.estadogarante = estadogarante;
    }

    public String getEstadopagoC() {
        return estadopagoC;
    }

    public void setEstadopagoC(String estadopagoC) {
        this.estadopagoC = estadopagoC;
    }

    public int getClusteresid() {
        return clusteresid;
    }

    public void setClusteresid(int clusteresid) {
        this.clusteresid = clusteresid;
    }

    public String getNombreentidad() {
        return nombreentidad;
    }

    public void setNombreentidad(String nombreentidad) {
        this.nombreentidad = nombreentidad;
    }

    public String getTelefenofijo() {
        return telefenofijo;
    }

    public void setTelefenofijo(String telefenofijo) {
        this.telefenofijo = telefenofijo;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
}
