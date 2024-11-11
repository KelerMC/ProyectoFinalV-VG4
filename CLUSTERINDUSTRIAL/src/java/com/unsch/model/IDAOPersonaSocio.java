/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.dto.BPersonaSocio;
import com.unsch.util.BResultadoProceso;

/**
 *
 * @author ARANGO
 */
public interface IDAOPersonaSocio {

    public BResultadoProceso registrarPersonaSocio(BPersonaSocio bPersonaSocio);
}
