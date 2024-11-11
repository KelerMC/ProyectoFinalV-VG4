/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOVariedad;
import com.unsch.domain.BAlmacen;
import com.unsch.domain.BUnidadMedida;
import com.unsch.domain.BVariedad;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BVariedadAlmacen;
import com.unsch.service.VariedadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class VariedadServiceImpl implements VariedadService{

    @Autowired
    private IDAOVariedad dAOVariedad;

    public List<BVariedad> listaVariedad() {
        return this.dAOVariedad.listaVariedad();
    }

    public List<BVariedadAlmacen> listaVariedadDetalle() {
        return this.dAOVariedad.listaVariedadDetalle();
    }

    public List<BAlmacen> listaAlmacen() {
        return this.dAOVariedad.listaAlmacen();
    }

    public List<BUnidadMedida> listaUnidad() {
        return this.dAOVariedad.listaUnidad();
    }

    public BResultadoProceso InsertVariedad(BVariedad bVariedad) {
        return this.dAOVariedad.InsertVariedad(bVariedad);
    }

    public BResultadoProceso UpdateVariedad(BVariedad bVariedad) {
        return this.dAOVariedad.UpdateVariedad(bVariedad);
    }

    public BResultadoProceso DeleteVariedad(BVariedad bVariedad) {
        return this.dAOVariedad.DeleteVariedad(bVariedad);
    }

  
}
