/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BClusteres;
import com.unsch.domain.BNacionalidad;
import com.unsch.dto.BPersonaSocio;
import com.unsch.domain.BUbigeo;
import com.unsch.domain.BValorTabla;
import com.unsch.service.ClusteresService;
import com.unsch.service.NacionalidadService;
import com.unsch.service.PersonaSocioService;
import com.unsch.service.UbigeoService;
import com.unsch.service.ValorTablaService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ARANGO
 */
@RestController
public class PersonaSocioController {

    @Autowired
    private PersonaSocioService servicePersonaSocio;
    @Autowired
    private UbigeoService serviceUbigeo;
    @Autowired
    private NacionalidadService serviceNacionalidad;
    @Autowired
    private ValorTablaService serviceValorTabla;
    @Autowired
    private ClusteresService serviceClusteres;

    @RequestMapping(value = "/registrarPersonaSocio")
    public ModelAndView mostrarPersona() {
        List<BUbigeo> listaUbigeo = this.serviceUbigeo.listaUbigeo();
        List<BNacionalidad> listaNacionalidad = this.serviceNacionalidad.listaNacionalidad();

        List<BValorTabla> listaDocumento = this.serviceValorTabla.listaDocumentoIdentidad();
        List<BValorTabla> listaTipoPersona = this.serviceValorTabla.listaTipoPersona();
        List<BValorTabla> listaTipoTelefono = this.serviceValorTabla.listaTipoTelefono();

        List<BClusteres> listaCluster = this.serviceClusteres.listaClusteres();

        ModelAndView modelAndView = new ModelAndView("registrarPersonaSocio");
        modelAndView.addObject("listaUbigeo", listaUbigeo);
        modelAndView.addObject("listaNacionalidad", listaNacionalidad);
        modelAndView.addObject("listaDocumento", listaDocumento);
        modelAndView.addObject("listaTipoPersona", listaTipoPersona);
        modelAndView.addObject("listaTipoTelefono", listaTipoTelefono);
        modelAndView.addObject("listaCluster", listaCluster);
        return modelAndView;
    }

    @RequestMapping(value = "/registarPersonaSocio.htm", method = RequestMethod.GET)
    public @ResponseBody
    String agregarPregunta(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BPersonaSocio bPregunta = new BPersonaSocio();
        StringF stringF = new StringF();
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date jStartDate = formatoDeFecha.parse(request.getParameter("txtfechanacimiento"));
        java.sql.Date startDate = new java.sql.Date(jStartDate.getTime());

        bPregunta.setIdubigeo(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtidubigeo"), "0")));
        bPregunta.setNacionalidadid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtnacionalidadid"), "0")));
        bPregunta.setNombrepersona(stringF.nvlfunction(request.getParameter("txtnombrepersona").toUpperCase(), ""));
        bPregunta.setApepaterno(stringF.nvlfunction(request.getParameter("txtapepaterno").toUpperCase(), ""));
        bPregunta.setApmaterno(stringF.nvlfunction(request.getParameter("txtapmaterno").toUpperCase(), ""));
        bPregunta.setDocumentoidentidadid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtdocumentoidentidadid"), "0")));
        bPregunta.setNumerodocumento(stringF.nvlfunction(request.getParameter("txtnumerodocumento"), ""));
        bPregunta.setDireccion(stringF.nvlfunction(request.getParameter("txtdireccion").toUpperCase(), ""));
        bPregunta.setReferenciadireccion(stringF.nvlfunction(request.getParameter("txtreferenciadireccion").toUpperCase(), ""));
        bPregunta.setEmailpersonal(stringF.nvlfunction(request.getParameter("txtemailpersonal").toUpperCase(), ""));
        bPregunta.setIdtipotelefono(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtidtipotelefono"), "0")));
        bPregunta.setNumerotelefono(stringF.nvlfunction(request.getParameter("txtnumerotelefono"), ""));
        bPregunta.setFechanacimiento(startDate);
        bPregunta.setTipopersonaid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txttipopersonaid"), "0")));
        bPregunta.setClusteresid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtclusteresid"), "0")));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.servicePersonaSocio.registrarPersonaSocio(bPregunta);

        lista.add(bResultadoProceso);
        System.out.println("lista" + lista);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public PersonaSocioService getServicePersonaSocio() {
        return servicePersonaSocio;
    }

    public void setServicePersonaSocio(PersonaSocioService servicePersonaSocio) {
        this.servicePersonaSocio = servicePersonaSocio;
    }

    public UbigeoService getServiceUbigeo() {
        return serviceUbigeo;
    }

    public void setServiceUbigeo(UbigeoService serviceUbigeo) {
        this.serviceUbigeo = serviceUbigeo;
    }

    public NacionalidadService getServiceNacionalidad() {
        return serviceNacionalidad;
    }

    public void setServiceNacionalidad(NacionalidadService serviceNacionalidad) {
        this.serviceNacionalidad = serviceNacionalidad;
    }

    public ValorTablaService getServiceValorTabla() {
        return serviceValorTabla;
    }

    public void setServiceValorTabla(ValorTablaService serviceValorTabla) {
        this.serviceValorTabla = serviceValorTabla;
    }

    public ClusteresService getServiceClusteres() {
        return serviceClusteres;
    }

    public void setServiceClusteres(ClusteresService serviceClusteres) {
        this.serviceClusteres = serviceClusteres;
    }
}
