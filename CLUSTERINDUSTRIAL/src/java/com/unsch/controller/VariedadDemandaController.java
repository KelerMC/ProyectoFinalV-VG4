/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.unsch.service.VariedadDemandaService;
import com.unsch.util.EstrategiaExclusion;
import com.unsch.dto.BDetalleVariedad;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class VariedadDemandaController {

    @Autowired
    private VariedadDemandaService serviceVariedadDemanda;

    @RequestMapping(value = "/viewGraficaVariedadDemanda.htm", method = RequestMethod.GET)
    public ModelAndView showForm(HttpServletRequest request) {
        return new ModelAndView("viewVariedadDemanda");
    }
    Map<String, LinkedList> map = new HashMap<String, LinkedList>();

    @RequestMapping(value = "/listarVariedadDemanda.htm", method = RequestMethod.GET)
    public @ResponseBody
    String listarVariedadDemanda(HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<BDetalleVariedad> listData = this.serviceVariedadDemanda.GraficaVariedadDemanda();

        LinkedList bus_list1 = new LinkedList();
        LinkedList bus_list2 = new LinkedList();
        LinkedList bus_list3 = new LinkedList();
        LinkedList bus_list4 = new LinkedList();
        LinkedList bus_list5 = new LinkedList();

        LinkedList bus_list6 = new LinkedList();

        for (int i = 0; i < listData.size(); i++) {
            bus_list1.add(i, listData.get(i).getVariedadid());
            bus_list2.add(i, listData.get(i).getDenominacion());
            bus_list3.add(i, listData.get(i).getCantidad());
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

    public VariedadDemandaService getServiceVariedadDemanda() {
        return serviceVariedadDemanda;
    }

    public void setServiceVariedadDemanda(VariedadDemandaService serviceVariedadDemanda) {
        this.serviceVariedadDemanda = serviceVariedadDemanda;
    }
}
