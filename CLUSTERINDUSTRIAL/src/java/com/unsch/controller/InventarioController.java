/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BAlmacen;
import com.unsch.domain.BInventario;
import com.unsch.dto.BProductoDetalle;
import com.unsch.domain.BTipoDocumento;
import com.unsch.domain.BTipoMovimiento;
import com.unsch.domain.BUnidadMedida;
import com.unsch.service.AlmacenService;
import com.unsch.service.InventarioService;
import com.unsch.service.ProductoService;
import com.unsch.service.TipoDocumentoService;
import com.unsch.service.TipoMovimientoService;
import com.unsch.service.UnidadMedidaService;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.util.StringF;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.dto.BAlmacenCluster;
import com.unsch.dto.BDetalleInventario;
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
public class InventarioController {

    @Autowired
    private InventarioService serviceInventario;
    @Autowired
    private AlmacenService serviceAlmacen;
    @Autowired
    private ProductoService serviceProducto;
    @Autowired
    private UnidadMedidaService serviceUnidadMedida;
    @Autowired
    private TipoDocumentoService serviceTipoDocumento;
    @Autowired
    private TipoMovimientoService serviceTipoMovimiento;

    @RequestMapping(value = "/registrarInventario.htm")
    public ModelAndView viewInventarioRegistro(HttpServletRequest request) {

        List<BAlmacenCluster> listaAlmacen = this.serviceAlmacen.listaAlmacen();
        List<BProductoDetalle> listaProducto = this.serviceProducto.listaProducto();
        List<BUnidadMedida> listaUnidadMedida = this.serviceUnidadMedida.listaUnidadMedida();
        List<BTipoDocumento> listaTipoDocumento = this.serviceTipoDocumento.listaTipoDocumento();
        List<BTipoMovimiento> listaMovimiento = this.serviceTipoMovimiento.listaTipoMovimiento();

        ModelAndView modelAndView = new ModelAndView("registrarInventario");
        modelAndView.addObject("listaAlmacen", listaAlmacen);
        modelAndView.addObject("listaProducto", listaProducto);
        modelAndView.addObject("listaUnidadMedida", listaUnidadMedida);
        modelAndView.addObject("listaTipoDocumento", listaTipoDocumento);
        modelAndView.addObject("listaMovimiento", listaMovimiento);
        return modelAndView;
    }

    @RequestMapping(value = "/agregarInventario.htm", method = RequestMethod.GET)
    public @ResponseBody
    String insertInventario(HttpServletRequest request, HttpServletResponse response) throws ParseException {

        BInventario bInventario = new BInventario();

        StringF stringF = new StringF();

        bInventario.setAlmacenid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtalmacenid"), "0")));
        bInventario.setProductoid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtproductoid"), "0")));
        bInventario.setUnidadmedidaid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtunidadmedidaid"), "0")));
        bInventario.setTipodocumentoid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txttipodocumentoid"), "0")));
        bInventario.setTipomovimientoid(Integer.parseInt(stringF.nvlfunction(request.getParameter("txttipomovimientoid"), "0")));

        bInventario.setCantidad(Integer.parseInt(stringF.nvlfunction(request.getParameter("txtcantidad"), "0")));
        bInventario.setPreciounitario(Double.parseDouble(stringF.nvlfunction(request.getParameter("txtpreciounitario"), "0")));
        bInventario.setPreciototal(Double.parseDouble(stringF.nvlfunction(request.getParameter("txtpreciototal"), "0")));

        BResultadoProceso bResultadoProceso;
        List<BResultadoProceso> lista = new ArrayList<BResultadoProceso>();
        bResultadoProceso = this.serviceInventario.InsertInventario(bInventario);

        lista.add(bResultadoProceso);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String proceso = gson.toJson(lista);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");
        return proceso;
    }

    @RequestMapping(value = "/listaInventario.htm")
    public ModelAndView menuView(HttpServletRequest request) {
        BArrayList arrayList = new BArrayList();
        arrayList.setId1(2);

        List<BAlmacen> listaAlmacen = this.serviceAlmacen.listaAlmacen(arrayList);
        List<BProductoDetalle> listaProducto = this.serviceProducto.listaProducto();

        ModelAndView modelAndView = new ModelAndView("listaInventario");
        modelAndView.addObject("listaAlmacen", listaAlmacen);
        modelAndView.addObject("listaProducto", listaProducto);

        return modelAndView;
    }

    @RequestMapping(value = "/recuperarInventario.htm", method = RequestMethod.GET)
    public ModelAndView listarInventario(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            List<BDetalleInventario> list = this.serviceInventario.listaInventario();
            System.out.println("tamanio de los datos: " + list.size());
            JSONArray jsonArray = new JSONArray();
            for (BDetalleInventario harbour : list) {
                JSONArray array = new JSONArray();

                array.put(harbour.getInventarioid());
                array.put(harbour.getDenominacionA());
                array.put(harbour.getCodigoproducto());
                array.put(harbour.getDenominacionUM());
                array.put(harbour.getDescripcionTD());
                array.put(harbour.getDenominacionTM());
                array.put(String.valueOf(harbour.getFechamovimiento()));
                array.put(harbour.getCantidad());
                array.put(harbour.getPreciounitario());
                array.put(harbour.getPreciototal());
                array.put(harbour.getEstadoinventario());

                jsonArray.put(array);
            }
            response.getWriter().write(jsonArray.toString());
            return null;
        } catch (Exception e) {
            System.out.println("error is " + e);
        }
        return null;
    }

    public InventarioService getServiceInventario() {
        return serviceInventario;
    }

    public void setServiceInventario(InventarioService serviceInventario) {
        this.serviceInventario = serviceInventario;
    }

    public AlmacenService getServiceAlmacen() {
        return serviceAlmacen;
    }

    public void setServiceAlmacen(AlmacenService serviceAlmacen) {
        this.serviceAlmacen = serviceAlmacen;
    }

    public ProductoService getServiceProducto() {
        return serviceProducto;
    }

    public void setServiceProducto(ProductoService serviceProducto) {
        this.serviceProducto = serviceProducto;
    }

    public UnidadMedidaService getServiceUnidadMedida() {
        return serviceUnidadMedida;
    }

    public void setServiceUnidadMedida(UnidadMedidaService serviceUnidadMedida) {
        this.serviceUnidadMedida = serviceUnidadMedida;
    }

    public TipoDocumentoService getServiceTipoDocumento() {
        return serviceTipoDocumento;
    }

    public void setServiceTipoDocumento(TipoDocumentoService serviceTipoDocumento) {
        this.serviceTipoDocumento = serviceTipoDocumento;
    }

    public TipoMovimientoService getServiceTipoMovimiento() {
        return serviceTipoMovimiento;
    }

    public void setServiceTipoMovimiento(TipoMovimientoService serviceTipoMovimiento) {
        this.serviceTipoMovimiento = serviceTipoMovimiento;
    }

}
