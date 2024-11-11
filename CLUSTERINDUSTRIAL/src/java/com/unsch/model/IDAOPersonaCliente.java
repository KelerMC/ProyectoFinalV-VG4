/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BPersonaCliente;

/**
 *
 * @author ARANGO
 */
public interface IDAOPersonaCliente {

    public BResultadoProceso RegistrarPersonaCliente(BPersonaCliente bPersonaCliente);
}
