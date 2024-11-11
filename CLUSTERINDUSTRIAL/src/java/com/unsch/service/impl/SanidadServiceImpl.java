/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOSanidad;
import com.unsch.domain.BSanidad;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BSanidadCalibre;
import com.unsch.service.SanidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class SanidadServiceImpl implements   SanidadService{

    @Autowired
    private IDAOSanidad dAOSanidad;

    public BResultadoProceso InsertSanidad(BSanidad bSanidad) {
        return this.dAOSanidad.InsertSanidad(bSanidad);
    }

    public List<BSanidadCalibre> listaSanidad() {
        return this.dAOSanidad.listaSanidad();
    }

  
}
