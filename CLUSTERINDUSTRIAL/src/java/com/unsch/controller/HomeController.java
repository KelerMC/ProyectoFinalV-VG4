/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.controller;

import com.unsch.domain.BCliente;
import com.unsch.domain.BUsuario;
import com.unsch.service.ClienteService;
import com.unsch.service.UsuarioService;
import com.unsch.util.BResultadoProceso;
import com.unsch.util.StringF;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ARANGO
 */
@RestController
@RequestMapping("index.htm")
public class HomeController {

    public HttpSession session;
    @Autowired
    private UsuarioService serviceUsuario;
    @Autowired
    private ClienteService serviceCliente;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        return new ModelAndView("index");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BUsuario bUsuario = new BUsuario();
        BCliente bCliente = new BCliente();
        StringF stringF = new StringF();

        String login = request.getParameter("login_remember");
        System.out.println("login......." + login);
        BResultadoProceso bResultadoProceso = new BResultadoProceso();

        if (login == null) {
            System.out.println("aqui ya entre else " + login);
            bCliente.setNombrecliente(stringF.nvlfunction(request.getParameter("txtnombreusuario").toUpperCase(), ""));
            bCliente.setClavecliente(stringF.nvlfunction(request.getParameter("txtclaveusuario").toUpperCase(), ""));
            bResultadoProceso = this.serviceCliente.autenticaCliente(bCliente);
        } else if (login.equalsIgnoreCase("on")) {
            System.out.println("aqui ya entre if " + login);
            bUsuario.setNombreusuario(stringF.nvlfunction(request.getParameter("txtnombreusuario").toUpperCase(), ""));
            bUsuario.setClaveusuario(stringF.nvlfunction(request.getParameter("txtclaveusuario").toUpperCase(), ""));
            System.out.println("por aqui lleog");
            bResultadoProceso = this.serviceUsuario.autenticaUsuario(bUsuario);
            System.out.println("por aqui despues de pasar getExiste "+bUsuario.getExiste());
        }
        System.out.println("a fuera de los ifs");
        bResultadoProceso.setDet_rta(bResultadoProceso.getDet_rta().replace("\n", ""));
        List<BResultadoProceso> listaBResultadoProcesos = new ArrayList<BResultadoProceso>();
        listaBResultadoProcesos.add(0, bResultadoProceso);
        request.setAttribute("proceso", listaBResultadoProcesos);

        if (bUsuario.getExiste() == 1) {
            session = request.getSession(true);
            System.out.println("bUsuario.getNomter1().." + bUsuario.getNombrecompleto());
            session.setAttribute("sesionuser", bUsuario.getNombrecompleto());
            return new ModelAndView("admin");
        } else if (bCliente.getExiste() == 1) {
            session = request.getSession(true);
            System.out.println("bUsuario.getNomter1().." + bCliente.getNombrecompleto());
            session.setAttribute("idsesionclient", bCliente.getClienteid());
            session.setAttribute("sesionclient", bCliente.getNombrecompleto());
            return new ModelAndView("menu");
        } else {
            return new ModelAndView("index");
        }
    }

    public UsuarioService getServiceUsuario() {
        return serviceUsuario;
    }

    public void setServiceUsuario(UsuarioService serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    public ClienteService getServiceCliente() {
        return serviceCliente;
    }

    public void setServiceCliente(ClienteService serviceCliente) {
        this.serviceCliente = serviceCliente;
    }
}
