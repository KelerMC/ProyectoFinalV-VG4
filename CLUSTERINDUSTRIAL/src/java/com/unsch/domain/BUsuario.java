package com.unsch.domain;

public class BUsuario {

    private int usuarioid;
    private int socioid;
    private int rolusuarioid;
    private String nombreusuario;
    private String claveusuario;
    private String estadousuario;
    private int existe;
    private String nombrecompleto;

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getSocioid() {
        return socioid;
    }

    public void setSocioid(int socioid) {
        this.socioid = socioid;
    }

    public int getRolusuarioid() {
        return rolusuarioid;
    }

    public void setRolusuarioid(int rolusuarioid) {
        this.rolusuarioid = rolusuarioid;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getClaveusuario() {
        return claveusuario;
    }

    public void setClaveusuario(String claveusuario) {
        this.claveusuario = claveusuario;
    }

    public String getEstadousuario() {
        return estadousuario;
    }

    public void setEstadousuario(String estadousuario) {
        this.estadousuario = estadousuario;
    }

    public int getExiste() {
        return existe;
    }

    public void setExiste(int existe) {
        this.existe = existe;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }
}
