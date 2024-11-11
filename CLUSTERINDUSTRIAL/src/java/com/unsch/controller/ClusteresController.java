/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BClusteres;
import com.unsch.domain.BUbigeo;
import com.unsch.service.ClusteresService;
import com.unsch.service.UbigeoService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class ClusteresController {

    @Autowired
    private ClusteresService serviceClusteres;
    @Autowired
    private UbigeoService serviceUbigeo;

    @RequestMapping(value = "/listaClusteres.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BUbigeo> lista = this.serviceUbigeo.listaUbigeo();
        System.out.println("jajaja tamanio datos : " + lista.size());
        ModelAndView modelAndView = new ModelAndView("listaClusteres");
        modelAndView.addObject("listaUbigeo", lista);
        return modelAndView;
    }

    @RequestMapping(value = "/recuperarClusteres.htm", method = RequestMethod.GET)
    public ModelAndView listaClusteres(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BClusteres> list = this.serviceClusteres.listaClusteres();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BClusteres harbour : list) {
                JSONArray array = new JSONArray();
                array.put(harbour.getClusteresid());
                array.put(harbour.getUbigeoid());
                array.put(harbour.getUbigeo());
                array.put(harbour.getDenominacion());
                array.put(harbour.getDescripcion());
                array.put(harbour.getEstadoclusteres());
                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/RegitrarCluster.htm", method = RequestMethod.GET)
    public @ResponseBody
    String agregarCluster(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BClusteres bClusteres = new BClusteres();
        StringF stringF = new StringF();

        bClusteres.setUbigeoid(stringF.nvlfunction(request.getParameter("ubigeoid"), 0));
        bClusteres.setDenominacion(stringF.nvlfunction(request.getParameter("txtdenominacioncluster").toUpperCase(), ""));
        bClusteres.setDescripcion(stringF.nvlfunction(request.getParameter("txtdescripcionclaster").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceClusteres.RegistrarCluster(bClusteres);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/UpdateCluster.htm", method = RequestMethod.GET)
    public @ResponseBody
    String UpdateCluster(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BClusteres bClusteres = new BClusteres();
        StringF stringF = new StringF();
        bClusteres.setClusteresid(stringF.nvlfunction(request.getParameter("clusteresid"), 0));
        bClusteres.setUbigeoid(stringF.nvlfunction(request.getParameter("ubigeoid"), 0));
        bClusteres.setDenominacion(stringF.nvlfunction(request.getParameter("txtdenominacioncluster").toUpperCase(), ""));
        bClusteres.setDescripcion(stringF.nvlfunction(request.getParameter("txtdescripcionclaster").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceClusteres.UpdateCluster(bClusteres);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/DeleteCluster.htm", method = RequestMethod.GET)
    public @ResponseBody
    String DeleteCluster(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        BClusteres bClusteres = new BClusteres();
        StringF stringF = new StringF();
        bClusteres.setClusteresid(stringF.nvlfunction(request.getParameter("clusteresid"), 0));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceClusteres.DeleteCluster(bClusteres);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public ClusteresService getServiceClusteres() {
        return serviceClusteres;
    }

    public void setServiceClusteres(ClusteresService serviceClusteres) {
        this.serviceClusteres = serviceClusteres;
    }

    public UbigeoService getServiceUbigeo() {
        return serviceUbigeo;
    }

    public void setServiceUbigeo(UbigeoService serviceUbigeo) {
        this.serviceUbigeo = serviceUbigeo;
    }
}
