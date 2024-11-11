/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BOperacion;
import com.unsch.service.OperacionService;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ARANGO
 */
@RestController
public class OperacionController {

    @Autowired
    private OperacionService serviceOperacion;

    @RequestMapping(value = "/listaOperacion.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        return new ModelAndView("listaOperacion");
    }

    @RequestMapping(value = "/recuperarOperacion.htm", method = RequestMethod.GET)
    public ModelAndView listarOperacion(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BOperacion> list = this.serviceOperacion.listaOperacion();
            JSONArray jsonArray = new JSONArray();
            for (BOperacion harbour : list) {
                JSONArray array = new JSONArray();
                array.put(harbour.getOperacionid());
                System.out.println("kkkkkkkkkk " + harbour.getDenominacionoperacion());
                array.put(harbour.getDenominacionoperacion());
                array.put(String.valueOf(harbour.getFecharegistro()));
                array.put(String.valueOf(harbour.getFechaactualizacion()));
                array.put(harbour.getEstadooperacion());
                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception exception) {
            System.out.println("error is " + exception);
        }
        return null;
    }

    @RequestMapping(value = "/registarOperacion.htm", method = RequestMethod.GET)
    public @ResponseBody
    String agregarGrupo(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BOperacion bPregunta = new BOperacion();
        StringF stringF = new StringF();
        System.out.println("****" + request.getParameter("nomgrupo"));
        bPregunta.setDenominacionoperacion(stringF.nvlfunction(request.getParameter("denominacionoperacion").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceOperacion.agregarOperacion(bPregunta);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "buscarOpracion.htm", method = RequestMethod.GET)
    public void buscarTrabajadores(HttpServletRequest request, HttpServletResponse response, @RequestParam String pClave) throws IOException {
        System.out.println("name.." + pClave);
        BArrayList bArrayList = new BArrayList();
        bArrayList.setString1(pClave.toUpperCase());
        List<BOperacion> lista = this.serviceOperacion.listaOpracion(bArrayList);
        response.getWriter().write(new Gson().toJson(lista));
    }

    public OperacionService getServiceOperacion() {
        return serviceOperacion;
    }

    public void setServiceOperacion(OperacionService serviceOperacion) {
        this.serviceOperacion = serviceOperacion;
    }

}
