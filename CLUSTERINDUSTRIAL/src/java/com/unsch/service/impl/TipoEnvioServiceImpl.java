/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOTipoEnvio;
import com.unsch.domain.BTipoEnvio;
import com.unsch.service.TipoEnvioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class TipoEnvioServiceImpl implements TipoEnvioService{

    @Autowired
    private IDAOTipoEnvio dAOTipoEnvio;

    public List<BTipoEnvio> listaTipoEnvio() {
        return this.dAOTipoEnvio.listaTipoEnvio();
    }

   
}
