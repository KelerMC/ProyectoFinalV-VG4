/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BVariedadCalibre;
import com.unsch.util.BResultadoProceso;
import java.util.List;
import com.unsch.dto.BDetalleVariedadCalibre;

/**
 *
 * @author ARANGO
 */
public interface IDAOVariedadCalibre {

    public List<BDetalleVariedadCalibre> listaVariedadCalibre();

    public BResultadoProceso InsertVariedadCalibre(BVariedadCalibre bVariedadCalibre);
}
