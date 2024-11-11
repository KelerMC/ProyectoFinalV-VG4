/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BCliente;
import com.unsch.util.BResultadoProceso;

/**
 *
 * @author SISTEMAS
 */
public interface IDAOCliente {

    public BResultadoProceso autenticaCliente(BCliente bCliente);

    public BResultadoProceso registrarCliente(BCliente bEvaluacion);
}
