/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOCliente;
import com.unsch.domain.BCliente;
import com.unsch.util.BResultadoProceso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface ClienteService {


    public BResultadoProceso autenticaCliente(BCliente bCliente) ;

    public BResultadoProceso registrarCliente(BCliente bEvaluacion) ;

 
}
