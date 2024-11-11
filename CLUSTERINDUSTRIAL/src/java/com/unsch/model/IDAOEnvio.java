/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BEnvio;
import com.unsch.util.BResultadoProceso;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOEnvio {

    public List<BEnvio> listaEnvio();

    public BResultadoProceso InsertEnvio(BEnvio bEnvio);
}
