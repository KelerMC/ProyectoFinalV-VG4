/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BCalibres;
import com.unsch.domain.BSanidad;
import com.unsch.service.CalibresService;
import com.unsch.service.SanidadService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BSanidadCalibre;
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
public class SanidadController {

    @Autowired
    private CalibresService serviceCalibres;
    @Autowired
    private SanidadService serviceSanidad;

    @RequestMapping(value = "/listaSanidad.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        List<BCalibres> listCalibres = this.serviceCalibres.listaCalibres();
        ModelAndView modelAndView = new ModelAndView("listaSanidad");
        modelAndView.addObject("listCalibres", listCalibres);
        return modelAndView;
    }

    @RequestMapping(value = "/insertSanidad.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertSanidad(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BSanidad bSanidad = new BSanidad();
        StringF stringF = new StringF();
        bSanidad.setCalibresid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtcalibresid"), "0")));
        bSanidad.setDenominacionsanidad(stringF.nvlfunction(request.getParameter("txtdenominacionsanidad").toUpperCase(), ""));
        bSanidad.setValorsanidad(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtvalorsanidad"), "0")));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceSanidad.InsertSanidad(bSanidad);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/recuperarSanidad.htm", method = RequestMethod.GET)
    public ModelAndView listarSanidad(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BSanidadCalibre> list = this.serviceSanidad.listaSanidad();
            System.out.println("jjjjjjj " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BSanidadCalibre harbour : list) {
                JSONArray array = new JSONArray();
                array.put(harbour.getSanidadid());
                array.put(harbour.getDenominacionC());
                array.put(harbour.getDenominacionsanidadS());
                array.put(harbour.getValorsanidad());
                array.put(harbour.getEstadosanidadS());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception exception) {
            System.out.println("error is " + exception);
        }
        return null;
    }

    /**
     * @return the serviceCalibres
     */
    public CalibresService getServiceCalibres() {
        return serviceCalibres;
    }

    /**
     * @param serviceCalibres the serviceCalibres to set
     */
    public void setServiceCalibres(CalibresService serviceCalibres) {
        this.serviceCalibres = serviceCalibres;
    }

    /**
     * @return the serviceSanidad
     */
    public SanidadService getServiceSanidad() {
        return serviceSanidad;
    }

    /**
     * @param serviceSanidad the serviceSanidad to set
     */
    public void setServiceSanidad(SanidadService serviceSanidad) {
        this.serviceSanidad = serviceSanidad;
    }

}
