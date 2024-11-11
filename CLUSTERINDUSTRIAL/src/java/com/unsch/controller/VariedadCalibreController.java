/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BCalibres;
import com.unsch.domain.BVariedad;
import com.unsch.domain.BVariedadCalibre;
import com.unsch.service.CalibresService;
import com.unsch.service.VariedadService;
import com.unsch.service.VariedadCalibreService;
import com.unsch.dto.BDetalleVariedadCalibre;
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
 * @author Morpheus
 */
@RestController
public class VariedadCalibreController {

    @Autowired
    private VariedadCalibreService serviceVariedadCalibre;
    @Autowired
    private VariedadService serviceVariedad;
    @Autowired
    private CalibresService serviceCalibres;

    @RequestMapping(value = "/listaVariedadCalibre.htm", method = RequestMethod.GET)
    public ModelAndView mostrarVariedadCalibre(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        List<BVariedad> lista = this.serviceVariedad.listaVariedad();

        List<BCalibres> listaCalibres = this.serviceCalibres.listaCalibres();

        System.out.println("jsjsjsj tamanio : " + lista.size());
        ModelAndView modelAndView = new ModelAndView("listaVariedadCalibre");
        modelAndView.addObject("listaVaiedad", lista);
        modelAndView.addObject("listaCalibres", listaCalibres);
        return modelAndView;
    }

    @RequestMapping(value = "/recuperarVariedadCalibre.htm", method = RequestMethod.GET)
    public ModelAndView listarVariedadCalibre(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BDetalleVariedadCalibre> list = this.serviceVariedadCalibre.listaVariedadCalibre();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleVariedadCalibre harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getVariedadcalibreid());
                array.put(harbour.getDenominacionV());
                array.put(harbour.getDenominacionC());
                array.put(harbour.getDenominacionVC());
                array.put(harbour.getRangoVC());
                array.put(harbour.getPesoVC());
                array.put(harbour.getEstadoVC());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "/registarVariedadCalibre.htm", method = RequestMethod.GET)
    public @ResponseBody
    String agregarVariedadCalibre(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BVariedadCalibre bConfigura = new BVariedadCalibre();
        StringF stringF = new StringF();

        bConfigura.setVariedadid(Integer.parseInt(stringF.nvlfunction(request.getParameter("variedadid"), "0")));

        bConfigura.setCalibresid(Integer.parseInt(stringF.nvlfunction(request.getParameter("calibresid"), "0")));
        bConfigura.setDenominacion(stringF.nvlfunction(request.getParameter("denominacion").toUpperCase(), ""));
        bConfigura.setRango(stringF.nvlfunction(request.getParameter("rango").toUpperCase(), ""));
        bConfigura.setPeso(stringF.nvlfunction(request.getParameter("peso").toUpperCase(), ""));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> listaBResultadoProcesos = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceVariedadCalibre.InsertVariedadCalibre(bConfigura);

        listaBResultadoProcesos.add(0, bResultadoProceso);
        request.setAttribute("proceso", listaBResultadoProcesos);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(listaBResultadoProcesos);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public VariedadCalibreService getServiceVariedadCalibre() {
        return serviceVariedadCalibre;
    }

    public void setServiceVariedadCalibre(VariedadCalibreService serviceVariedadCalibre) {
        this.serviceVariedadCalibre = serviceVariedadCalibre;
    }

    public VariedadService getServiceVariedad() {
        return serviceVariedad;
    }

    public void setServiceVariedad(VariedadService serviceVariedad) {
        this.serviceVariedad = serviceVariedad;
    }

    public CalibresService getServiceCalibres() {
        return serviceCalibres;
    }

    public void setServiceCalibres(CalibresService serviceCalibres) {
        this.serviceCalibres = serviceCalibres;
    }
}
