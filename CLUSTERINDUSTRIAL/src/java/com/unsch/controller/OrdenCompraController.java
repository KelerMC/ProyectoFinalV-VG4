/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BOrdenCompra;
import com.unsch.service.OrdenCompraService;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BDetalleOrdenCompra;
import com.unsch.dto.BSubDetalleOrdenCompra;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ARANGO
 */
@RestController
@SessionAttributes("idsesionclient")
public class OrdenCompraController {

    @Autowired
    private OrdenCompraService serviceOrdenCompra;

    @RequestMapping(value = "/listaOrdenCompra.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        return new ModelAndView("listaOrdenCompra");
    }

    @RequestMapping(value = "/registarOrdenCompra.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertOrdenCompra(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {

        BOrdenCompra bAlmacen = new BOrdenCompra();
        StringF stringF = new StringF();
        System.out.println("..... " + session.getAttribute("idsesionclient"));
        bAlmacen.setClienteid(Integer.parseInt(String.valueOf(session.getAttribute("idsesionclient"))));
        bAlmacen.setInventarioid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtinventarioid"), "0")));
        bAlmacen.setCantidad(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtcantidad"), "0")));
        bAlmacen.setMonedaid(Integer.parseInt(stringF.nvlfunction(request.getParameter("cantidadvia"), "0")));

        bAlmacen.setObservacion(stringF.nvlfunction(request.getParameter("txtobservacion").toUpperCase(), ""));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceOrdenCompra.InsertOrdenCompra(bAlmacen);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/recuperarOrdenCompra.htm", method = RequestMethod.GET)
    public ModelAndView listarOrdenCompra(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {

            List<BDetalleOrdenCompra> list = this.serviceOrdenCompra.listaOrdenCompra();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleOrdenCompra harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getOrdencompraid());
                array.put(harbour.getCodigoproducto());
                array.put(harbour.getCantidadOC());
                array.put(harbour.getPreciounitario());
                array.put(harbour.getDenominacion());
                array.put(String.valueOf(harbour.getFechaorden()));
                array.put(String.valueOf(harbour.getFechaaprobacion()));
                array.put(harbour.getValorventa());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getEstadoorden());

                jsonArray.put(array);
            }

            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is aqui error ....... " + e);
        }
        return null;
    }

    @RequestMapping(value = "/recuperarDetalleOrdenCompra.htm", method = RequestMethod.GET)
    public ModelAndView MostrarDetalleProductoInventario(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "ids", required = false) String ids) {
        try {

            BArrayList bArrayList = new BArrayList();
            System.out.println("ids..... " + ids);
            bArrayList.setString1(ids);
            List<BSubDetalleOrdenCompra> list = this.serviceOrdenCompra.subListaOrdenCompra(bArrayList);
            System.out.println("jhajajajajaj detalle----------" + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BSubDetalleOrdenCompra harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getProductoid());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getDenominacionV());
                array.put(harbour.getDenominacionC());
                array.put(harbour.getDenominacionVC());
                array.put(harbour.getRangoVC());
                array.put(harbour.getPesoVC());
                array.put(harbour.getDescripcionPRO());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception exception) {
            System.out.println("error is detalle" + exception);
        }
        return null;
    }

    public OrdenCompraService getServiceOrdenCompra() {
        return serviceOrdenCompra;
    }

    public void setServiceOrdenCompra(OrdenCompraService serviceOrdenCompra) {
        this.serviceOrdenCompra = serviceOrdenCompra;
    }
}
