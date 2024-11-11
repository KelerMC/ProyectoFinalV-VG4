/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOPersona;
import com.unsch.domain.BPersona;
import com.unsch.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private IDAOPersona dAOPersona;

    public List<BPersona> listaPersonaSocio() {
        return this.dAOPersona.listaPersonaSocio();
    }

  
}
