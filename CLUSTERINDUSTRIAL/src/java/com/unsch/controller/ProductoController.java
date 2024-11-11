/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BProducto;
import com.unsch.dto.BProductoDetalle;
import com.unsch.domain.BUnidadMedida;
import com.unsch.service.PersonaService;
import com.unsch.service.ProductoService;
import com.unsch.service.SanidadService;
import com.unsch.service.SocioService;
import com.unsch.service.UnidadMedidaService;
import com.unsch.service.VariedadService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.service.VariedadCalibreService;
import com.unsch.dto.BDetalleVariedadCalibre;
import com.unsch.dto.BPersonaSocio;
import com.unsch.dto.BSanidadCalibre;
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
public class ProductoController {

    @Autowired
    private ProductoService serviceProducto;
    @Autowired
    private SanidadService serviceSanidad;
    @Autowired
    private VariedadService serviceVariedad;
    @Autowired
    private SocioService serviceSocio;
    @Autowired
    private PersonaService servicePersona;
    @Autowired
    private UnidadMedidaService serviceUnidadMedida;
    @Autowired
    private VariedadCalibreService serviceVariedadCalibre;

    @RequestMapping(value = "/registrarProducto.htm")
    public ModelAndView registrarProducto(HttpServletRequest request, HttpServletResponse response) {

        List<BVariedadAlmacen> bvs = this.serviceVariedad.listaVariedadDetalle();
        List<BPersonaSocio> bses = this.serviceSocio.listaPersonaSocio();
        List<BSanidadCalibre> sanidads = this.serviceSanidad.listaSanidad();

        List<BUnidadMedida> bums = this.serviceUnidadMedida.listaUnidadMedida();

        ModelAndView modelAndView = new ModelAndView("registrarProducto");
        modelAndView.addObject("lista1", bvs);
        modelAndView.addObject("bses", bses);
        modelAndView.addObject("sanidads", sanidads);
        modelAndView.addObject("bums", bums);
        return modelAndView;
    }

    @RequestMapping(value = "/viewVariedadCalibre.htm", method = RequestMethod.GET)
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

    @RequestMapping(value = "/registarDatosProducto.htm", method = RequestMethod.GET)
    public @ResponseBody
    String agregarProducto(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BProducto bProducto = new BProducto();
        StringF stringF = new StringF();

        bProducto.setVariedadcalibreid(Integer.parseInt(stringF.nvlfunction(request.getParameter("variedadid"), "0")));
        bProducto.setSocioid(Integer.parseInt(stringF.nvlfunction(request.getParameter("socioid"), "0")));
        bProducto.setCodigoproducto(stringF.nvlfunction(request.getParameter("codigoproducto").toUpperCase(), ""));

        bProducto.setDescripcion(stringF.nvlfunction(request.getParameter("descripcion").toUpperCase(), ""));
        bProducto.setImageurl(stringF.nvlfunction(request.getParameter("imageurl"), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceProducto.registrarProducto(bProducto);

        lista.add(bResultadoProceso);
        System.out.println("lista" + lista);
        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/listaProducto.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        return new ModelAndView("listaProducto");
    }

    @RequestMapping(value = "/recuperarProducto.htm", method = RequestMethod.GET)
    public ModelAndView listaProducto(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) {
        try {
            List<BProductoDetalle> list = this.serviceProducto.listaProducto();
            JSONArray jsonArray = new JSONArray();
            for (BProductoDetalle harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getProductoid());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getCodigoproducto());
                array.put(harbour.getDenominacion());
                array.put(harbour.getDescripcion());
                array.put(harbour.getImageurl());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception exception) {
            System.out.println("error is " + exception);
        }
        return null;
    }

    public ProductoService getServiceProducto() {
        return serviceProducto;
    }

    public void setServiceProducto(ProductoService serviceProducto) {
        this.serviceProducto = serviceProducto;
    }

    public SanidadService getServiceSanidad() {
        return serviceSanidad;
    }

    public void setServiceSanidad(SanidadService serviceSanidad) {
        this.serviceSanidad = serviceSanidad;
    }

    public VariedadService getServiceVariedad() {
        return serviceVariedad;
    }

    public void setServiceVariedad(VariedadService serviceVariedad) {
        this.serviceVariedad = serviceVariedad;
    }

    public SocioService getServiceSocio() {
        return serviceSocio;
    }

    public void setServiceSocio(SocioService serviceSocio) {
        this.serviceSocio = serviceSocio;
    }

    public PersonaService getServicePersona() {
        return servicePersona;
    }

    public void setServicePersona(PersonaService servicePersona) {
        this.servicePersona = servicePersona;
    }

    public UnidadMedidaService getServiceUnidadMedida() {
        return serviceUnidadMedida;
    }

    public void setServiceUnidadMedida(UnidadMedidaService serviceUnidadMedida) {
        this.serviceUnidadMedida = serviceUnidadMedida;
    }

    public VariedadCalibreService getServiceVariedadCalibre() {
        return serviceVariedadCalibre;
    }

    public void setServiceVariedadCalibre(VariedadCalibreService serviceVariedadCalibre) {
        this.serviceVariedadCalibre = serviceVariedadCalibre;
    }
}
