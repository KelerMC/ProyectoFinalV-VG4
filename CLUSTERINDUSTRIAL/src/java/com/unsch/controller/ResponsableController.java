/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BClusteres;
import com.unsch.domain.BResponsable;
import com.unsch.service.ClusteresService;
import com.unsch.service.ResponsableService;
import com.unsch.service.SocioService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BPersonaSocio;
import com.unsch.dto.BResponsableSocioCluster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ResponsableController {

    @Autowired
    private ResponsableService serviceResponsable;
    @Autowired
    private ClusteresService serviceClusteres;
    @Autowired
    private SocioService serviceSocio;

    @RequestMapping(value = "/listaResponsable.htm", method = RequestMethod.GET)
    public ModelAndView paginaMostrarExamen(HttpServletRequest request) {

        List<BPersonaSocio> listaPersona = this.serviceSocio.listaPersonaSocio();
        List<BClusteres> listaCluster = this.serviceClusteres.listaClusteres();

        ModelAndView modelAndView = new ModelAndView("listaResponsable");
        modelAndView.addObject("listPersona", listaPersona);
        modelAndView.addObject("listCluster", listaCluster);
        return modelAndView;
    }

    @RequestMapping(value = "/agregarResponsable.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertResponsable(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BResponsable bInventario = new BResponsable();
        StringF stringF = new StringF();

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date jStartDate = formatoDeFecha.parse(request.getParameter("txtfechainicio"));
        java.sql.Date startDate = new java.sql.Date(jStartDate.getTime());

        java.util.Date jFinishDate = formatoDeFecha.parse(request.getParameter("txtfechafin"));
        java.sql.Date finischDate = new java.sql.Date(jFinishDate.getTime());

        bInventario.setSocioid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtsocioid"), "0")));
        bInventario.setClusteresid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtclusteresid"), "0")));
        bInventario.setFechainicio(startDate);
        bInventario.setFechafin(finischDate);

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceResponsable.InsertResponsable(bInventario);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/recuperarResponsable.htm", method = RequestMethod.GET)
    public ModelAndView listarResponsableCluster(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BResponsableSocioCluster> list = this.serviceResponsable.listaPersonaResponsable();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BResponsableSocioCluster harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getResponsableid());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getDenominacion());
                System.out.println("harbour.getDenominacion() "+harbour.getDenominacion());
                array.put(String.valueOf(harbour.getFechainicio()));
                System.out.println("harbour.getFechainicio() "+harbour.getFechainicio());
                array.put(String.valueOf(harbour.getFechafin()));
                array.put(harbour.getEstadoresponsable());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    public ResponsableService getServiceResponsable() {
        return serviceResponsable;
    }

    public void setServiceResponsable(ResponsableService serviceResponsable) {
        this.serviceResponsable = serviceResponsable;
    }

    public ClusteresService getServiceClusteres() {
        return serviceClusteres;
    }

    public void setServiceClusteres(ClusteresService serviceClusteres) {
        this.serviceClusteres = serviceClusteres;
    }

    public SocioService getServiceSocio() {
        return serviceSocio;
    }

    public void setServiceSocio(SocioService serviceSocio) {
        this.serviceSocio = serviceSocio;
    }

}
