/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BNacionalidad;
import com.unsch.domain.BUbigeo;
import com.unsch.domain.BValorTabla;
import com.unsch.service.NacionalidadService;
import com.unsch.service.PersonaClienteService;
import com.unsch.service.UbigeoService;
import com.unsch.service.ValorTablaService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BPersonaCliente;
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
public class PersonaClienteController {

    @Autowired
    private NacionalidadService serviceNacionalidad;
    @Autowired
    private ValorTablaService serviceValorTabla;
    @Autowired
    private UbigeoService serviceUbigeo;
    @Autowired
    private PersonaClienteService servicePersonaCliente;

    @RequestMapping(value = "/registrarCuentaCliente.htm")
    public ModelAndView solicitarCuenta(HttpServletRequest request) {
        List<BNacionalidad> lista = this.serviceNacionalidad.listaNacionalidad();
        List<BValorTabla> lista1 = this.serviceValorTabla.listaDocumentoIdentidad();
        List<BValorTabla> lista2 = this.serviceValorTabla.listaTipoPersona();
        List<BValorTabla> lista3 = this.serviceValorTabla.listaTipoTelefono();

        List<BUbigeo> lista4 = this.serviceUbigeo.listaUbigeo();

        ModelAndView modelAndView = new ModelAndView("registrarCuentaCliente");

        modelAndView.addObject("bObjectList", lista);
        modelAndView.addObject("listaDocumento", lista1);
        modelAndView.addObject("listaTipoPersona", lista2);
        modelAndView.addObject("listaTipoTelefono", lista3);
        modelAndView.addObject("listaUbigeo", lista4);
        return modelAndView;
    }

    @RequestMapping(value = "/RegitrarPersonaCliente.htm", method = RequestMethod.GET)
    public @ResponseBody
    String agregarPersonaCliente(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        System.out.println("aquiiiiiiiiiiiii ------- ");
        BPersonaCliente bClusteres = new BPersonaCliente();
        StringF stringF = new StringF();
        System.out.println("aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date jStartDate = formatoDeFecha.parse(request.getParameter("txtfechanacimiento"));
        java.sql.Date startDate = new java.sql.Date(jStartDate.getTime());

        bClusteres.setIdubigeo(stringF.nvlfunction(request.getParameter("txtidubigeo"), 0));
        bClusteres.setNacionalidadid(stringF.nvlfunction(request.getParameter("txtnacionalidadid"), 0));
        bClusteres.setNombrepersona(stringF.nvlfunction(request.getParameter("txtnombrepersona").toUpperCase(), ""));
        bClusteres.setApepaterno(stringF.nvlfunction(request.getParameter("txtapepaterno").toUpperCase(), ""));
        bClusteres.setApmaterno(stringF.nvlfunction(request.getParameter("txtapmaterno").toUpperCase(), ""));
        bClusteres.setDocumentoidentidadid(stringF.nvlfunction(request.getParameter("txtdocumentoidentidadid"), 0));
        bClusteres.setNumerodocumento(stringF.nvlfunction(request.getParameter("txtnumerodocumento"), ""));
        bClusteres.setDireccion(stringF.nvlfunction(request.getParameter("txtdireccion").toUpperCase(), ""));
        bClusteres.setReferenciadireccion(stringF.nvlfunction(request.getParameter("txtreferenciadireccion").toUpperCase(), ""));
        bClusteres.setEmailpersonal(stringF.nvlfunction(request.getParameter("txtemailpersonal").toUpperCase(), ""));
        bClusteres.setIdtipotelefono(stringF.nvlfunction(request.getParameter("txtidtipotelefono"), 0));
        bClusteres.setNumerotelefono(stringF.nvlfunction(request.getParameter("txtnumerotelefono"), ""));
        bClusteres.setFechanacimiento(startDate);
        bClusteres.setTipopersonaid(stringF.nvlfunction(request.getParameter("txttipopersonaid"), 0));
        bClusteres.setCodigopostal(stringF.nvlfunction(request.getParameter("txtcodigopostal").toUpperCase(), ""));
        bClusteres.setRegion(stringF.nvlfunction(request.getParameter("txtregion").toUpperCase(), ""));
        bClusteres.setNombrecliente(stringF.nvlfunction(request.getParameter("txtnombrecliente").toUpperCase(), ""));
        bClusteres.setClavecliente(stringF.nvlfunction(request.getParameter("txtclavecliente").toUpperCase(), ""));
        System.out.println("            aaaaabjjjjjjjjjjjjjjjo ");
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.servicePersonaCliente.RegistrarPersonaCliente(bClusteres);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
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

    public UbigeoService getServiceUbigeo() {
        return serviceUbigeo;
    }

    public void setServiceUbigeo(UbigeoService serviceUbigeo) {
        this.serviceUbigeo = serviceUbigeo;
    }

    public PersonaClienteService getServicePersonaCliente() {
        return servicePersonaCliente;
    }

    public void setServicePersonaCliente(PersonaClienteService servicePersonaCliente) {
        this.servicePersonaCliente = servicePersonaCliente;
    }

}
