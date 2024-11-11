/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BCalibres;
import com.unsch.service.CalibresService;
import com.unsch.service.VariedadService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class CalibresController {

    @Autowired
    private CalibresService serviceCalibres;
    @Autowired
    private VariedadService serviceVariedad;

    @RequestMapping(value = "/listaCalibres.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BVariedadAlmacen> lista = this.serviceVariedad.listaVariedadDetalle();
        ModelAndView modelAndView = new ModelAndView("listaCalibres");
        modelAndView.addObject("listaVariedad", lista);
        return modelAndView;
    }

    @RequestMapping(value = "/recuperarCalibres.htm", method = RequestMethod.GET)
    public ModelAndView listacalibres(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BCalibres> list = this.serviceCalibres.listaCalibres();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BCalibres harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getCalibresid());
                array.put(harbour.getDenominacion());
                array.put(harbour.getEstadocalibres());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/insertCalibres.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertCalibres(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BCalibres bCalibres = new BCalibres();
        StringF stringF = new StringF();
        System.out.println("request.getParameter() " + request.getParameter("denominacion"));
        bCalibres.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceCalibres.InsertCalibres(bCalibres);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/updateCalibres.htm", method = RequestMethod.GET)
    public @ResponseBody
    String updateCalibres(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BCalibres bCalibres = new BCalibres();
        StringF stringF = new StringF();
        bCalibres.setCalibresid(stringF.nvlfunction(request.getParameter("calibresid"), 0));

        bCalibres.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceCalibres.UpdateCalibres(bCalibres);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/deleteCalibres.htm", method = RequestMethod.GET)
    public @ResponseBody
    String deleteCalibres(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        BCalibres bCalibres = new BCalibres();
        StringF stringF = new StringF();
        bCalibres.setCalibresid(stringF.nvlfunction(request.getParameter("calibresid"), 0));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceCalibres.DeleteCalibres(bCalibres);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public CalibresService getServiceCalibres() {
        return serviceCalibres;
    }

    public void setServiceCalibres(CalibresService serviceCalibres) {
        this.serviceCalibres = serviceCalibres;
    }

    public VariedadService getServiceVariedad() {
        return serviceVariedad;
    }

    public void setServiceVariedad(VariedadService serviceVariedad) {
        this.serviceVariedad = serviceVariedad;
    }
}
