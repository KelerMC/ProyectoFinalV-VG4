/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.unsch.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ARANGO
 */
@RestController
public class ReporteAlmacen   {


    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("").toString();

        System.out.println("--PapeletaInfraccionPlacaReporte-handleRequestInternal");
        String uri = request.getRequestURI();
        String format = uri.substring(uri.lastIndexOf(".") + 1);

//        String placa = ServletRequestUtils.getRequiredStringParameter(request, "parametros");
        System.out.println("uri=" + uri);
        System.out.println("format=" + format);

        System.out.println("path=" + path);

        Map model = new HashMap();
        model.clear();
        model.put("format", format);


        return new ModelAndView("reporteEvaPdf", model);
    }
}
