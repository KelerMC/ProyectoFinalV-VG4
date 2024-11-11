/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BOperacion;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOOperacion {

    public List<BOperacion> listaOperacion();

    public BResultadoProceso agregarOperacion(BOperacion bOperacion);

    public List<BOperacion> listaOpracion(BArrayList bOperacion);

}
