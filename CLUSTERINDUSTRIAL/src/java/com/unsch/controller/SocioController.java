/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BClusteres;
import com.unsch.domain.BPersona;
import com.unsch.domain.BSocio;
import com.unsch.service.SocioService;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.dto.BClusterSocioPersona;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
public class SocioController {

    @Autowired
    private SocioService serviceSocio;

    @RequestMapping(value = "/listaSocio.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        return new ModelAndView("listaSocio");
    }

    @RequestMapping(value = "/recuperarSocio.htm", method = RequestMethod.GET)
    public ModelAndView listarSocio(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BClusterSocioPersona> list = this.serviceSocio.listaSocio();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BClusterSocioPersona harbour : list) {
                JSONArray array = new JSONArray();
                array.put(harbour.getSocioid());
                array.put(harbour.getPersonaid());
                array.put(harbour.getClusteresid());
                array.put(harbour.getDenominacion());
                array.put(harbour.getNombrecompleto());
                System.out.println("harbour.getNombrecompleto());... "+harbour.getNombrecompleto());
                array.put(String.valueOf(harbour.getFecharegistro()));
                array.put(harbour.getEstadocuenta());
                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    @RequestMapping(value = "buscarPersonas.htm", method = RequestMethod.GET)
    public void buscarPersonas(HttpServletRequest request, HttpServletResponse response, @RequestParam String pClave) throws IOException {
        BArrayList bArrayList = new BArrayList();
        bArrayList.setString1(pClave.toUpperCase());
        List<BPersona> lista = this.serviceSocio.listaPersonas(bArrayList);
        response.getWriter().write(new Gson().toJson(lista));
    }

    @RequestMapping(value = "buscarClusteres.htm", method = RequestMethod.GET)
    public void buscarClusteres(HttpServletRequest request, HttpServletResponse response, @RequestParam String pClave) throws IOException {
        BArrayList bArrayList = new BArrayList();
        bArrayList.setString1(pClave.toUpperCase());
        List<BClusteres> lista = this.serviceSocio.listaClusteres(bArrayList);
        response.getWriter().write(new Gson().toJson(lista));
    }

    @RequestMapping(value = "/insertSocio.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertAlmacen(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BSocio bSocio = new BSocio();
        StringF stringF = new StringF();
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date jStartDate = formatoDeFecha.parse(request.getParameter("fechacancelacion"));
        java.sql.Date startDate = new java.sql.Date(jStartDate.getTime());

        java.util.Date jStartDate1 = formatoDeFecha.parse(request.getParameter("fechasuspension"));
        java.sql.Date startDate1 = new java.sql.Date(jStartDate1.getTime());

        bSocio.setClusteresid(stringF.nvlfunction(request.getParameter("personaid"), 0));
        bSocio.setClusteresid(stringF.nvlfunction(request.getParameter("clusteresid"), 0));
        bSocio.setFechacancelacion(startDate);
        //  bSocio.setFechacancelacion(stringF.nvlfunction(request.getParameter("fechacancelacion"),null));
        bSocio.setObscancelacion(stringF.nvlfunction(request.getParameter("obscancelacion").toUpperCase(), ""));
        bSocio.setClusteresid(stringF.nvlfunction(request.getParameter("indiceestado"), 0));
        bSocio.setFechasuspencion(startDate1);
        // bSocio.setFechasuspencion(stringF.nvlfunction(request.getParameter("fechasuspension"),null));
        bSocio.setObssuspencion(stringF.nvlfunction(request.getParameter("obssuspension").toUpperCase(), ""));
        bSocio.setEstadocuenta(stringF.nvlfunction(request.getParameter("estadocuenta"), 0));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceSocio.InsertSocio(bSocio);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/updateSocio.htm", method = RequestMethod.GET)
    public @ResponseBody
    String updateAlmacen(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        BSocio bSocio = new BSocio();
        StringF stringF = new StringF();
        //   SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", new Locale("es", "ES"));

        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date jStartDate = formatoDeFecha.parse(request.getParameter("fechacancelacion"));
        java.sql.Date startDate = new java.sql.Date(jStartDate.getTime());

        java.util.Date jStartDate1 = formatoDeFecha.parse(request.getParameter("fechasuspension"));
        java.sql.Date startDate1 = new java.sql.Date(jStartDate1.getTime());

        bSocio.setSocioid(stringF.nvlfunction(request.getParameter("socioid"), 0));
        bSocio.setClusteresid(stringF.nvlfunction(request.getParameter("personaid"), 0));
        bSocio.setClusteresid(stringF.nvlfunction(request.getParameter("clusteresid"), 0));
        bSocio.setFechacancelacion(startDate);
        //  bSocio.setFechacancelacion(stringF.nvlfunction(request.getParameter("fechacancelacion"),null));
        bSocio.setObscancelacion(stringF.nvlfunction(request.getParameter("obscancelacion").toUpperCase(), ""));
        bSocio.setClusteresid(stringF.nvlfunction(request.getParameter("indiceestado"), 0));
        bSocio.setFechasuspencion(startDate1);
        // bSocio.setFechasuspencion(stringF.nvlfunction(request.getParameter("fechasuspension"),null));
        bSocio.setObssuspencion(stringF.nvlfunction(request.getParameter("obssuspension").toUpperCase(), ""));
        bSocio.setEstadocuenta(stringF.nvlfunction(request.getParameter("estadocuenta"), 0));
        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceSocio.InsertSocio(bSocio);
        lista.add(bResultadoProceso);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    public SocioService getServiceSocio() {
        return serviceSocio;
    }

    public void setServiceSocio(SocioService serviceSocio) {
        this.serviceSocio = serviceSocio;
    }
}
