/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOMovimiento;
import com.unsch.domain.BMovimiento;
import com.unsch.service.MovimientoService;
import com.unsch.util.BResultadoProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class MovimientoServiceImpl implements MovimientoService{

    @Autowired
    private IDAOMovimiento dAOMovimiento;

    public BResultadoProceso InsertMovimiento(BMovimiento bMovimiento) {
        return this.dAOMovimiento.InsertMovimiento(bMovimiento);
    }

 
}
