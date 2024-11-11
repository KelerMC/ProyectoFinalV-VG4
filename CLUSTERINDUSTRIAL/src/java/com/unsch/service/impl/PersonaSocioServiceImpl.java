/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOPersonaSocio;
import com.unsch.dto.BPersonaSocio;
import com.unsch.service.PersonaSocioService;
import com.unsch.util.BResultadoProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class PersonaSocioServiceImpl implements PersonaSocioService{

    @Autowired
    private IDAOPersonaSocio dAOPersonaSocio;

    public BResultadoProceso registrarPersonaSocio(BPersonaSocio bPersonaSocio) {
        return this.dAOPersonaSocio.registrarPersonaSocio(bPersonaSocio);
    }

    
}
