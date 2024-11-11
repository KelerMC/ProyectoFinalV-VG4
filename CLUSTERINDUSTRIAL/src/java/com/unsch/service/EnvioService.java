/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOEnvio;
import com.unsch.domain.BEnvio;
import com.unsch.util.BResultadoProceso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface EnvioService {

 
    public List<BEnvio> listaEnvio() ;

    public BResultadoProceso InsertEnvio(BEnvio bEnvio);


}
