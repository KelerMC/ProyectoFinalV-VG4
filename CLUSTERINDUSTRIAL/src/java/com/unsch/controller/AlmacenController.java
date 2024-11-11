/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BAlmacen;
import com.unsch.domain.BClusteres;
import com.unsch.service.AlmacenService;
import com.unsch.service.ClusteresService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.dto.BAlmacenCluster;
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
public class AlmacenController {

    @Autowired
    private AlmacenService serviceAlmacen;
    @Autowired
    private ClusteresService serviceClusteres;

    @RequestMapping(value = "/listaAlmacen.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BClusteres> lista = this.serviceClusteres.listaClusteres();
        System.out.println("jsjsjsj tamanio : " + lista.size());
        ModelAndView modelAndView = new ModelAndView("listaAlmacen");
        modelAndView.addObject("listaClusteres", lista);
        return modelAndView;
    }

    @RequestMapping(value = "/recuperarAlmacen.htm", method = RequestMethod.GET)
    public ModelAndView listarAlmacen(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BAlmacenCluster> list = this.serviceAlmacen.listaAlmacen();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BAlmacenCluster harbour : list) {
                JSONArray array = new JSONArray();
                array.put(harbour.getAlmacenid());
                array.put(harbour.getDenominacionC());
                array.put(harbour.getDenominacionA());
                array.put(harbour.getDescripcionA());
                array.put(harbour.getIndestadoapertura());
                array.put(String.valueOf(harbour.getFechaapertura()));
                array.put(harbour.getEstadoalmacen());
                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/insertAlmacen.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertAlmacen(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BAlmacen bAlmacen = new BAlmacen();
        StringF stringF = new StringF();
        bAlmacen.setClusteresid(stringF.nvlfunction(request.getParameter("clusteresid"), 0));
        bAlmacen.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));
        bAlmacen.setDescripcion(stringF.nvlfunction(request.getParameter("descripcion").toUpperCase(), ""));
        bAlmacen.setIndestadoapertura(stringF.nvlfunction(request.getParameter("indestadoapertura").toUpperCase(), ""));

        bAlmacen.setHorareferencia(stringF.nvlfunction(request.getParameter("horareferencia").toUpperCase(), ""));
        bAlmacen.setCantidadvia(Integer.parseInt(stringF.nvlfunction(request.getParameter("cantidadvia"), "0")));
        bAlmacen.setCostotransporte(Double.parseDouble(stringF.nvlfunction(request.getParameter("costotransporte"), "0")));

        bAlmacen.setTelefonoalmacen(stringF.nvlfunction(request.getParameter("telefonoalmacen"), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceAlmacen.InsertAlmacen(bAlmacen);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/updateAlmacen.htm", method = RequestMethod.GET)
    public @ResponseBody
    String updateAlmacen(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BAlmacen bAlmacen = new BAlmacen();
        StringF stringF = new StringF();
        bAlmacen.setAlmacenid(stringF.nvlfunction(request.getParameter("almacenid"), 0));
        bAlmacen.setClusteresid(stringF.nvlfunction(request.getParameter("clusteresid"), 0));
        bAlmacen.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));
        bAlmacen.setDescripcion(stringF.nvlfunction(request.getParameter("descripcion").toUpperCase(), ""));
        bAlmacen.setIndestadoapertura(stringF.nvlfunction(request.getParameter("indestadoapertura").toUpperCase(), ""));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceAlmacen.UpdateAlmacen(bAlmacen);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/deleteAlmacen.htm", method = RequestMethod.GET)
    public @ResponseBody
    String deleteAlmacen(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        BAlmacen bAlmacen = new BAlmacen();
        StringF stringF = new StringF();
        bAlmacen.setAlmacenid(stringF.nvlfunction(request.getParameter("almacenid"), 0));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceAlmacen.DeleteAlmacen(bAlmacen);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public AlmacenService getServiceAlmacen() {
        return serviceAlmacen;
    }

    public void setServiceAlmacen(AlmacenService serviceAlmacen) {
        this.serviceAlmacen = serviceAlmacen;
    }

    public ClusteresService getServiceClusteres() {
        return serviceClusteres;
    }

    public void setServiceClusteres(ClusteresService serviceClusteres) {
        this.serviceClusteres = serviceClusteres;
    }

}
