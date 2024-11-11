/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BClusteres;
import com.unsch.domain.BSugerencia;
import com.unsch.service.ClusteresService;
import com.unsch.service.SugerenciaService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BAlmacenCluster;
import com.unsch.dto.BDetalleSugerencia;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hp
 */
@RestController
@SessionAttributes("idsesionclient")
public class SugerenciaController {

    @Autowired
    private SugerenciaService serviceSugerencia;
    @Autowired
    private ClusteresService serviceClusteres;

    @RequestMapping(value = "/listaSugerencia.htm")
    public ModelAndView menuViewSugerencia(HttpServletRequest request) {
        return new ModelAndView("listaSugerencia");
    }

    @RequestMapping(value = "/recuperarSugerenciaDetalle.htm", method = RequestMethod.GET)
    public ModelAndView listarSugerenciaDetalle(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BDetalleSugerencia> list = this.serviceSugerencia.listaSugerenciaDetalle();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleSugerencia harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getSugerenciaid());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getDenominacionClu());
                array.put(harbour.getTextosugerencia());
                array.put(String.valueOf(harbour.getFechasugerencia()));
                array.put(harbour.getClasificacionS());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/registrarSugerencia.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BClusteres> listCluster = this.serviceClusteres.listaClusteres();
        ModelAndView modelAndView = new ModelAndView("registrarSugerencia");
        modelAndView.addObject("listCluster", listCluster);
        return modelAndView;
    }

    @RequestMapping(value = "/insertSugerencia.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertSugerencia(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {

        BSugerencia bVariedad = new BSugerencia();
        StringF stringF = new StringF();
        bVariedad.setClienteid(Integer.parseInt(String.valueOf(session.getAttribute("idsesionclient"))));
        bVariedad.setClusteresid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtclusteresid"), "0")));
        bVariedad.setTextosugerencia(stringF.nvlfunction(request.getParameter("txttextosugerencia").toUpperCase(), ""));
        bVariedad.setClasificacion(stringF.nvlfunction(request.getParameter("txtclasificacion"), "0"));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceSugerencia.InsertSugerencia(bVariedad);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public SugerenciaService getServiceSugerencia() {
        return serviceSugerencia;
    }

    public void setServiceSugerencia(SugerenciaService serviceSugerencia) {
        this.serviceSugerencia = serviceSugerencia;
    }

    public ClusteresService getServiceClusteres() {
        return serviceClusteres;
    }

    public void setServiceClusteres(ClusteresService serviceClusteres) {
        this.serviceClusteres = serviceClusteres;
    }
}
