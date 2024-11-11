/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOOperacion;
import com.unsch.domain.BOperacion;
import com.unsch.service.OperacionService;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class OperacionServiceImpl implements OperacionService{

    @Autowired
    private IDAOOperacion dAOOperacion;

    public List<BOperacion> listaOperacion() {
        return this.dAOOperacion.listaOperacion();
    }

    public BResultadoProceso agregarOperacion(BOperacion bOperacion) {
        return this.dAOOperacion.agregarOperacion(bOperacion);
    }
    
    public List<BOperacion>  listaOpracion(BArrayList bOperacion){
        return this.dAOOperacion.listaOpracion(bOperacion);
    }

  
}
