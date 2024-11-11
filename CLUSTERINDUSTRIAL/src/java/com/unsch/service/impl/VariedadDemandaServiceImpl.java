/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOVariedad;
import com.unsch.dto.BDetalleVariedad;
import com.unsch.service.VariedadDemandaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class VariedadDemandaServiceImpl implements VariedadDemandaService {

    @Autowired
    private IDAOVariedad dAOVariedad;

    public List<BDetalleVariedad> GraficaVariedadDemanda() {
        return this.dAOVariedad.GraficaVariedadDemanda();
    }

   
}
