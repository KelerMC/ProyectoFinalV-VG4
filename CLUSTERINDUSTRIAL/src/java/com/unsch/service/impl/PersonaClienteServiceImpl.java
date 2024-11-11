/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOPersonaCliente;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BPersonaCliente;
import com.unsch.service.PersonaClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class PersonaClienteServiceImpl implements PersonaClienteService{

    @Autowired
    private IDAOPersonaCliente dAOPersonaCliente;

    public BResultadoProceso RegistrarPersonaCliente(BPersonaCliente bPersonaCliente) {
        System.out.println("okkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        return this.dAOPersonaCliente.RegistrarPersonaCliente(bPersonaCliente);
    }

    public IDAOPersonaCliente getdAOPersonaCliente() {
        return dAOPersonaCliente;
    }

    public void setdAOPersonaCliente(IDAOPersonaCliente dAOPersonaCliente) {
        this.dAOPersonaCliente = dAOPersonaCliente;
    }
}
