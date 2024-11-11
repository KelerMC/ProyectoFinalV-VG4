/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BEnvio;
import com.unsch.domain.BTipoEnvio;
import com.unsch.service.CertificadoService;
import com.unsch.service.EnvioService;
import com.unsch.service.TipoEnvioService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BDetalleCertificado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
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
public class EnvioController {

    @Autowired
    private EnvioService serviceEnvio;
    @Autowired
    private TipoEnvioService serviceTipoEnvio;
    @Autowired
    private CertificadoService serviceCertificado;

    @RequestMapping(value = "/registrarEnvio.htm")
    public ModelAndView menuViewEnvio(HttpServletRequest request) {
//        List<BTipoEnvio> lista = this.serviceTipoEnvio.listaTipoEnvio();
        List<BDetalleCertificado> listaCertificado = this.serviceCertificado.listaCertificadoPagado();
//        System.out.println("jsjsjsj tamanio : " + lista.size());
        ModelAndView modelAndView = new ModelAndView("registrarEnvio");
//        modelAndView.addObject("listTipoEnvio", lista);
        modelAndView.addObject("listCertificado", listaCertificado);
        return modelAndView;
    }

    @RequestMapping(value = "/listaEnvio.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        return new ModelAndView("listaEnvio");
    }

    @RequestMapping(value = "/recuperarEnvio.htm", method = RequestMethod.GET)
    public ModelAndView listarEnvio(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BEnvio> list = this.serviceEnvio.listaEnvio();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BEnvio harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getEnvioid());
                array.put(harbour.getOrigen());
                array.put(harbour.getDestino());
                array.put(String.valueOf(harbour.getHorasalida()));
                array.put(String.valueOf(harbour.getHorallegada()));
                array.put(harbour.getTiempoentrega());
                array.put(harbour.getConductor());
                array.put(harbour.getNumeropersonal());
                array.put(harbour.getNumerocelular());
                array.put(harbour.getPlacavehiculo());
                array.put(harbour.getTipovehiculo());
                array.put(harbour.getObservacion());
                array.put(harbour.getTipoenvioid());
                array.put(harbour.getCertificadoid());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/viewTipoEnvio.htm", method = RequestMethod.GET)
    public ModelAndView listarTipoEnvio(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BTipoEnvio> list = this.serviceTipoEnvio.listaTipoEnvio();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BTipoEnvio harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getTipoenvioid());
                array.put(harbour.getDenominacionenvio());
                array.put(harbour.getCostoenvio());
                array.put(harbour.getNumerovehiculo());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/insertEnvio.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertEnvio(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BEnvio bEnvio = new BEnvio();
        StringF stringF = new StringF();

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date jStartDateSalida = formatoDeFecha.parse(request.getParameter("txthorasalida"));
        java.sql.Date startDateSalida = new java.sql.Date(jStartDateSalida.getTime());

        java.util.Date jStartDateLlegada = formatoDeFecha.parse(request.getParameter("txthorallegada"));
        java.sql.Date startDateLlegada = new java.sql.Date(jStartDateLlegada.getTime());

        bEnvio.setOrigen(stringF.nvlfunction(request.getParameter("txtorigen").toUpperCase(), ""));
        bEnvio.setDestino(stringF.nvlfunction(request.getParameter("txtdestino").toUpperCase(), ""));
        bEnvio.setHorasalida(startDateSalida);
        bEnvio.setHorallegada(startDateLlegada);
        bEnvio.setTiempoentrega(stringF.nvlfunction(request.getParameter("txttiempoentrega").toUpperCase(), ""));
        bEnvio.setConductor(stringF.nvlfunction(request.getParameter("txtconductor").toUpperCase(), ""));
        bEnvio.setNumeropersonal(stringF.nvlfunction(request.getParameter("txtnumeropersonal").toUpperCase(), 0));
        bEnvio.setNumerocelular(stringF.nvlfunction(request.getParameter("txtnumerocelular").toUpperCase(), ""));
        bEnvio.setPlacavehiculo(stringF.nvlfunction(request.getParameter("txtplacavehiculo").toUpperCase(), ""));
        bEnvio.setTipovehiculo(stringF.nvlfunction(request.getParameter("txttipovehiculo").toUpperCase(), ""));
        bEnvio.setObservacion(stringF.nvlfunction(request.getParameter("txtobservacion").toUpperCase(), ""));
        bEnvio.setTipoenvioid(stringF.nvlfunction(request.getParameter("txttipoenvioid"), 0));
        bEnvio.setCertificadoid(stringF.nvlfunction(request.getParameter("txtcertificadoid"), 0));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceEnvio.InsertEnvio(bEnvio);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public EnvioService getServiceEnvio() {
        return serviceEnvio;
    }

    public void setServiceEnvio(EnvioService serviceEnvio) {
        this.serviceEnvio = serviceEnvio;
    }

    public TipoEnvioService getServiceTipoEnvio() {
        return serviceTipoEnvio;
    }

    public void setServiceTipoEnvio(TipoEnvioService serviceTipoEnvio) {
        this.serviceTipoEnvio = serviceTipoEnvio;
    }

    public CertificadoService getServiceCertificado() {
        return serviceCertificado;
    }

    public void setServiceCertificado(CertificadoService serviceCertificado) {
        this.serviceCertificado = serviceCertificado;
    }
}
