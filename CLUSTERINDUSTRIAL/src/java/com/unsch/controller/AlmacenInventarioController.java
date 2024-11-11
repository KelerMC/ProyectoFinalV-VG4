/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import javax.servlet.http.HttpServletRequest;
import com.unsch.dto.BAlmacenInventario;
import com.unsch.service.AlmacenInventarioService;
import com.unsch.util.EstrategiaExclusion;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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
public class AlmacenInventarioController {

    @Autowired
    private AlmacenInventarioService serviceAlmacenInventario;

    @RequestMapping(value = "/viewGraficaAlmacenProducto.htm", method = RequestMethod.GET)
    public ModelAndView showForm(HttpServletRequest request) {
        return new ModelAndView("viewGraficaAlmacenProducto");
    }
    Map<String, LinkedList> map = new HashMap<String, LinkedList>();

    @RequestMapping(value = "/listarAlmacenInventario.htm", method = RequestMethod.GET)
    public @ResponseBody
    String listarAlmacenInventario(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<BAlmacenInventario> listData = this.serviceAlmacenInventario.GraficaAlmacenInventario();

        LinkedList bus_list1 = new LinkedList();
        LinkedList bus_list2 = new LinkedList();
        LinkedList bus_list3 = new LinkedList();
        LinkedList bus_list4 = new LinkedList();
        LinkedList bus_list5 = new LinkedList();

        LinkedList bus_list6 = new LinkedList();

        for (int i = 0; i < listData.size(); i++) {
            bus_list1.add(i, listData.get(i).getInventarioid());
            bus_list2.add(i, listData.get(i).getDenominacion());
            bus_list3.add(i, listData.get(i).getCantidad());

            bus_list4.add(i, listData.get(i).getPreciounitario());
            bus_list5.add(i, listData.get(i).getPreciototal());

            bus_list6.add(i, listData.get(i).getPorcentaje());

        }

        System.out.println("bus_list---" + bus_list1.size());
        System.out.println("lista" + bus_list1);

        map.put("data1", bus_list1);
        map.put("data2", bus_list2);
        map.put("data3", bus_list3);
        map.put("data4", bus_list4);
        map.put("data5", bus_list5);
        map.put("data6", bus_list6);

        Gson gson = new GsonBuilder().setExclusionStrategies(new EstrategiaExclusion(List.class)).create();
        String json = gson.toJson(map);
        response.addHeader("Content-Type", "text/html; charset=iso-8859-1");

        return json;
    }

    public AlmacenInventarioService getServiceAlmacenInventario() {
        return serviceAlmacenInventario;
    }

    public void setServiceAlmacenInventario(AlmacenInventarioService serviceAlmacenInventario) {
        this.serviceAlmacenInventario = serviceAlmacenInventario;
    }

}
