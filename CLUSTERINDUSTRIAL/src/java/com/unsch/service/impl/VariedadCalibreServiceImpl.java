/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOVariedadCalibre;
import com.unsch.domain.BVariedadCalibre;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleVariedadCalibre;
import com.unsch.service.VariedadCalibreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class VariedadCalibreServiceImpl implements VariedadCalibreService{

    @Autowired
    private IDAOVariedadCalibre dAOVariedadCalibre;

    public List<BDetalleVariedadCalibre> listaVariedadCalibre() {
        return this.dAOVariedadCalibre.listaVariedadCalibre();
    }

    public BResultadoProceso InsertVariedadCalibre(BVariedadCalibre bVariedadCalibre) {
        return this.dAOVariedadCalibre.InsertVariedadCalibre(bVariedadCalibre);
    }

   
}
