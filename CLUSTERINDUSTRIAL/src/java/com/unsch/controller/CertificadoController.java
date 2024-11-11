/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BCertificado;
import com.unsch.service.CertificadoService;
import com.unsch.service.EntidadGaranteService;
import com.unsch.service.OrdenCompraService;
import com.unsch.service.ResponsableService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BDetalleCertificado;
import com.unsch.dto.BDetalleEntidadGarante;
import com.unsch.dto.BDetalleOrdenCompra;
import com.unsch.dto.BResponsableSocioCluster;
import java.text.ParseException;
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
public class CertificadoController {

    @Autowired
    private CertificadoService serviceCertificado;
    @Autowired
    private OrdenCompraService serviceOrdenCompra;
    @Autowired
    private ResponsableService serviceResponsable;
    @Autowired
    private EntidadGaranteService serviceEntidadGarante;

    @RequestMapping(value = "/registrarCertificado.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BResponsableSocioCluster> listaResponsable = this.serviceResponsable.listaPersonaResponsable();
        List<BDetalleEntidadGarante> listaEntidad = this.serviceEntidadGarante.listaEntidadGarante();
        ModelAndView modelAndView = new ModelAndView("registrarCertificado");
        modelAndView.addObject("listResponsable", listaResponsable);
        modelAndView.addObject("listEntidad", listaEntidad);
        return modelAndView;
    }

    @RequestMapping(value = "/registarCertificado.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertCertificado(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BCertificado bAlmacen = new BCertificado();
        StringF stringF = new StringF();
        System.out.println("---------------------- " + request.getParameter("txtcodigocertificado"));
        bAlmacen.setCodigocertificado(stringF.nvlfunction(request.getParameter("txtcodigocertificado").toUpperCase(), ""));
        bAlmacen.setEntidadgaranteid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtentidadgaranteid"), "0")));
        bAlmacen.setResponsableid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtresponsableid"), "0")));
        bAlmacen.setOrdencompraid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtordencompraid"), "0")));
        bAlmacen.setCantidad(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtcantidad"), "0")));
        bAlmacen.setPreciounitario(Double.parseDouble(stringF.nvlfunction(request.getParameter("txtpreciounitario"), "0")));
        bAlmacen.setCostototal(Double.parseDouble(stringF.nvlfunction(request.getParameter("txtcostototal"), "0")));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceCertificado.InsertCertificado(bAlmacen);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/listaCertificado.htm")
    public ModelAndView menuViewCertificado(HttpServletRequest request) {
        return new ModelAndView("listaCertificado");
    }

    @RequestMapping(value = "/activarCertificado.htm", method = RequestMethod.GET)
    public @ResponseBody
    String activarCertificado(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BCertificado bPregunta = new BCertificado();
        bPregunta.setCertificadoid(Integer.parseInt(request.getParameter("id")));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceCertificado.activarCertificado(bPregunta);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/recuperarCertificado.htm", method = RequestMethod.GET)
    public ModelAndView listarCertificado(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            List<BDetalleCertificado> list = this.serviceCertificado.listaCertificado();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleCertificado harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getCertificadoid());
                array.put(harbour.getCodigocertificado());
                array.put(harbour.getNombreentidad());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getOrdencompraid());
                array.put(String.valueOf(harbour.getFechacertificacion()));
                array.put(harbour.getCantidad());
                array.put(harbour.getPreciounitario());
                array.put(harbour.getCostototal());
                array.put(harbour.getIgv());
                array.put(harbour.getCostotrasnporte());
                array.put(harbour.getPrecioventa());
                array.put(harbour.getEstadoresponsable());

                jsonArray.put(array);
            }

            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is aqui error ....... " + e);
        }
        return null;
    }

    @RequestMapping(value = "/recuperarOCCertificado.htm", method = RequestMethod.GET)
    public ModelAndView listarOrdenCompra(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            List<BDetalleOrdenCompra> list = this.serviceOrdenCompra.listaOrdenCompra();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleOrdenCompra harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getOrdencompraid());
                array.put(harbour.getCodigoproducto());
                array.put(harbour.getCantidadOC());
                array.put(harbour.getPreciounitario());
                array.put(harbour.getDenominacion());
                array.put(String.valueOf(harbour.getFechaorden()));
                array.put(String.valueOf(harbour.getFechaaprobacion()));
                array.put(harbour.getValorventa());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getEstadoorden());

                jsonArray.put(array);
            }

            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is aqui error ....... " + e);
        }
        return null;
    }

    public CertificadoService getServiceCertificado() {
        return serviceCertificado;
    }

    public void setServiceCertificado(CertificadoService serviceCertificado) {
        this.serviceCertificado = serviceCertificado;
    }

    public OrdenCompraService getServiceOrdenCompra() {
        return serviceOrdenCompra;
    }

    public void setServiceOrdenCompra(OrdenCompraService serviceOrdenCompra) {
        this.serviceOrdenCompra = serviceOrdenCompra;
    }

    public ResponsableService getServiceResponsable() {
        return serviceResponsable;
    }

    public void setServiceResponsable(ResponsableService serviceResponsable) {
        this.serviceResponsable = serviceResponsable;
    }

    public EntidadGaranteService getServiceEntidadGarante() {
        return serviceEntidadGarante;
    }

    public void setServiceEntidadGarante(EntidadGaranteService serviceEntidadGarante) {
        this.serviceEntidadGarante = serviceEntidadGarante;
    }
}
