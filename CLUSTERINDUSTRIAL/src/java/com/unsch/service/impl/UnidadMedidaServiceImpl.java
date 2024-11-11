/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOUnidadMedida;
import com.unsch.domain.BUnidadMedida;
import com.unsch.service.UnidadMedidaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class UnidadMedidaServiceImpl implements UnidadMedidaService{

    @Autowired
    private IDAOUnidadMedida dAOUnidadMedida;

    public List<BUnidadMedida> listaUnidadMedida() {
        return this.dAOUnidadMedida.listaUnidadMedida();
    }

}
