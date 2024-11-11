/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BMovimiento;
import com.unsch.util.BResultadoProceso;

/**
 *
 * @author ARANGO
 */
public interface IDAOMovimiento {

    public BResultadoProceso InsertMovimiento(BMovimiento bMovimiento);
}
