/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BClusteres;
import com.unsch.domain.BEntidadGarante;
import com.unsch.service.ClusteresService;
import com.unsch.service.EntidadGaranteService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BDetalleEntidadGarante;
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
public class EntidadGaranteController {

    @Autowired
    private EntidadGaranteService serviceEntidadGarante;
    @Autowired
    private ClusteresService serviceClusteres;

    @RequestMapping(value = "/listaEntidadGarante.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BClusteres> listaCluster = this.serviceClusteres.listaClusteres();
        System.out.println("jsjsjsj tamanio : " + listaCluster.size());
        ModelAndView modelAndView = new ModelAndView("listaEntidadGarante");
        modelAndView.addObject("listaCluster", listaCluster);
        return modelAndView;
    }

    @RequestMapping(value = "/recuperarEntidadGarante.htm", method = RequestMethod.GET)
    public ModelAndView listarEntidadGarante(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BDetalleEntidadGarante> list = this.serviceEntidadGarante.listaEntidadGarante();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleEntidadGarante harbour : list) {
                JSONArray array = new JSONArray();
                array.put(harbour.getEntidadgaranteid());
                array.put(harbour.getDenominacion());
                array.put(harbour.getNombreentidad());
                array.put(harbour.getTelefenofijo());
                array.put(harbour.getRepresentante());
                array.put(harbour.getCargo());
                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/insertEntidadGarante.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertEntidadGarante(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BEntidadGarante bAlmacen = new BEntidadGarante();
        StringF stringF = new StringF();
        bAlmacen.setClusteresid(stringF.nvlfunction(request.getParameter("txtclusteresid"), 0));
        bAlmacen.setNombreentidad(stringF.nvlfunction(request.getParameter("txtnombreentidad").toUpperCase(), ""));
        bAlmacen.setTelefenofijo(stringF.nvlfunction(request.getParameter("txttelefenofijo"), ""));
        bAlmacen.setRepresentante(stringF.nvlfunction(request.getParameter("txtrepresentante").toUpperCase(), ""));
        bAlmacen.setCargo(stringF.nvlfunction(request.getParameter("txtcargo").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceEntidadGarante.InsertEntidadGarante(bAlmacen);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public EntidadGaranteService getServiceEntidadGarante() {
        return serviceEntidadGarante;
    }

    public void setServiceEntidadGarante(EntidadGaranteService serviceEntidadGarante) {
        this.serviceEntidadGarante = serviceEntidadGarante;
    }

    public ClusteresService getServiceClusteres() {
        return serviceClusteres;
    }

    public void setServiceClusteres(ClusteresService serviceClusteres) {
        this.serviceClusteres = serviceClusteres;
    }

}
