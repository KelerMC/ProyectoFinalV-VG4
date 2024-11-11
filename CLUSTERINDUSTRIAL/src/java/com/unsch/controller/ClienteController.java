/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ARANGO
 */
@RestController
public class ClienteController {

    @RequestMapping(value = "/listaCliente.htm")
    public ModelAndView mostrarCliente(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("listaCliente");
    }
}
