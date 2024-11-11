/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.domain.BMovimiento;
import com.unsch.service.CertificadoService;
import com.unsch.service.MovimientoService;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.unsch.dto.BDetalleCertificado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class MovimientoController {

    @Autowired
    private CertificadoService serviceCertificado;

    @Autowired
    private MovimientoService serviceMovimiento;

    @RequestMapping(value = "/registrarMovimiento.htm")
    public ModelAndView menuViewMovimiento(HttpServletRequest request) {
        return new ModelAndView("registrarMovimiento");
    }

    @RequestMapping(value = "/registrarMovimientoPago.htm", method = RequestMethod.GET)
    public @ResponseBody
    String registrarMovimientoPago(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ParseException {

        BMovimiento bAlmacen = new BMovimiento();
        StringF stringF = new StringF();
        SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd/MM/yyyy");

        java.util.Date jStartDate = formatoDeFecha.parse(request.getParameter("txtfechatransaccion"));
        java.sql.Date startDate = new java.sql.Date(jStartDate.getTime());

        bAlmacen.setSubtotal(Double.parseDouble(stringF.nvlfunction(request.getParameter("txtsubtotal"), "0")));
        bAlmacen.setGlosa(stringF.nvlfunction(request.getParameter("txtglosa").toUpperCase(), ""));
        bAlmacen.setBoucher(stringF.nvlfunction(request.getParameter("txtboucher"), ""));
        bAlmacen.setCertificadoid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtcertificadoid"), "0")));
        bAlmacen.setCci(stringF.nvlfunction(request.getParameter("txtcci"), ""));
        bAlmacen.setNumerotransaccion((stringF.nvlfunction(request.getParameter("txtnumerotransaccion"), "")));
        bAlmacen.setFechatransaccion(startDate);

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceMovimiento.InsertMovimiento(bAlmacen);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/recuperarCertificadoPago.htm", method = RequestMethod.GET)
    public ModelAndView listarCertificadoPago(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
        try {
            BArrayList bArrayList = new BArrayList();
            bArrayList.setId1(Integer.parseInt(String.valueOf(session.getAttribute("idsesionclient"))));
            List<BDetalleCertificado> list = this.serviceCertificado.listaCertificadoCliente(bArrayList);
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleCertificado harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getCertificadoid());
                array.put(harbour.getCodigocertificado());
                array.put(harbour.getNombreentidad());
                array.put(harbour.getNombrecompleto());
                array.put(harbour.getOrdencompraid());
                array.put(String.valueOf(harbour.getFechacertificacion()));
                array.put(harbour.getCantidad());
                array.put(harbour.getPreciounitario());
                array.put(harbour.getCostototal());
                array.put(harbour.getIgv());
                array.put(harbour.getCostotrasnporte());
                array.put(harbour.getPrecioventa());
                array.put(harbour.getEstadoresponsable());
                array.put(harbour.getEstadopagoC());
                jsonArray.put(array);
            }

            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is aqui error ....... " + e);
        }
        return null;
    }

    public CertificadoService getServiceCertificado() {
        return serviceCertificado;
    }

    public void setServiceCertificado(CertificadoService serviceCertificado) {
        this.serviceCertificado = serviceCertificado;
    }

    public MovimientoService getServiceMovimiento() {
        return serviceMovimiento;
    }

    public void setServiceMovimiento(MovimientoService serviceMovimiento) {
        this.serviceMovimiento = serviceMovimiento;
    }
}
