/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BCalibres;
import com.unsch.domain.BVariedad;
import com.unsch.util.BResultadoProceso;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOCalibres {

    public List<BCalibres> listaCalibres();
    
    public List<BVariedad> listaVariedad();
    
    public BResultadoProceso InsertCalibres(BCalibres bCalibres);

    public BResultadoProceso UpdateCalibres(BCalibres bCalibres);

    public BResultadoProceso DeleteCalibres(BCalibres bCalibres);
}
