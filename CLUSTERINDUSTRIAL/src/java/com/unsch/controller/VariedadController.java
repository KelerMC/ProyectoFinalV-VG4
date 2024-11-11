/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BVariedad;
import com.unsch.service.AlmacenService;
import com.unsch.service.UnidadMedidaService;
import com.unsch.service.VariedadService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.dto.BAlmacenCluster;
import com.unsch.dto.BVariedadAlmacen;
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
public class VariedadController {

    @Autowired
    private VariedadService serviceVariedad;
    @Autowired
    private AlmacenService serviceAlmacen;
    @Autowired
    private UnidadMedidaService serviceUnidadMedida;

    @RequestMapping(value = "/listaVariedad.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BAlmacenCluster> listAlmacen = this.serviceAlmacen.listaAlmacen();
        ModelAndView modelAndView = new ModelAndView("listaVariedad");
        modelAndView.addObject("listAlmacen", listAlmacen);
        return modelAndView;
    }

    @RequestMapping(value = "/recuperarVariedad.htm", method = RequestMethod.GET)
    public ModelAndView listarVariedad(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BVariedadAlmacen> list = this.serviceVariedad.listaVariedadDetalle();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BVariedadAlmacen harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getVariedadid());
                System.out.println("harbour.getDenominacionA() " + harbour.getDenominacionA());
                array.put(harbour.getDenominacionA());
                array.put(harbour.getDenominacionV());
                array.put(harbour.getDescripcionV());
                array.put(harbour.getImagen());
                array.put(harbour.getEstadovariedad());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/insertVariedad.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertVariedad(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BVariedad bVariedad = new BVariedad();
        StringF stringF = new StringF();
        bVariedad.setAlmacenid(stringF.nvlfunction(request.getParameter("almacenid"), 0));

        bVariedad.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));
        bVariedad.setDescripcion(stringF.nvlfunction(request.getParameter("descripcion").toUpperCase(), ""));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceVariedad.InsertVariedad(bVariedad);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/updateVariedad.htm", method = RequestMethod.GET)
    public @ResponseBody
    String updateVariedad(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BVariedad bVariedad = new BVariedad();
        StringF stringF = new StringF();
        bVariedad.setVariedadid(stringF.nvlfunction(request.getParameter("variedadid"), 0));
        bVariedad.setAlmacenid(stringF.nvlfunction(request.getParameter("almacenid"), 0));

        bVariedad.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));
        bVariedad.setDescripcion(stringF.nvlfunction(request.getParameter("descripcion").toUpperCase(), ""));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceVariedad.UpdateVariedad(bVariedad);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/deleteVariedad.htm", method = RequestMethod.GET)
    public @ResponseBody
    String deleteVariedad(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        BVariedad bVariedad = new BVariedad();
        StringF stringF = new StringF();
        bVariedad.setVariedadid(stringF.nvlfunction(request.getParameter("variedadid"), 0));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceVariedad.DeleteVariedad(bVariedad);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public VariedadService getServiceVariedad() {
        return serviceVariedad;
    }

    public void setServiceVariedad(VariedadService serviceVariedad) {
        this.serviceVariedad = serviceVariedad;
    }

    public AlmacenService getServiceAlmacen() {
        return serviceAlmacen;
    }

    public void setServiceAlmacen(AlmacenService serviceAlmacen) {
        this.serviceAlmacen = serviceAlmacen;
    }

    public UnidadMedidaService getServiceUnidadMedida() {
        return serviceUnidadMedida;
    }

    public void setServiceUnidadMedida(UnidadMedidaService serviceUnidadMedida) {
        this.serviceUnidadMedida = serviceUnidadMedida;
    }
}
