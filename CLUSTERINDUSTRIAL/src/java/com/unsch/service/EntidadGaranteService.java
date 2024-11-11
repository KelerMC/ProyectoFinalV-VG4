/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BEntidadGarante;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleEntidadGarante;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface EntidadGaranteService {


    public List<BDetalleEntidadGarante> listaEntidadGarante();

    public BResultadoProceso InsertEntidadGarante(BEntidadGarante bEntidadGarante);
  
}
