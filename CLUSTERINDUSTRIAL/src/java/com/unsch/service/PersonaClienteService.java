/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BPersonaCliente;

/**
 *
 * @author ARANGO
 */

public interface PersonaClienteService {



    public BResultadoProceso RegistrarPersonaCliente(BPersonaCliente bPersonaCliente);
}
