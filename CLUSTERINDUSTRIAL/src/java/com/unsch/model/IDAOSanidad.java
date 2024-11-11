/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BSanidad;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BSanidadCalibre;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOSanidad {

    public BResultadoProceso InsertSanidad(BSanidad bSanidad);

    public List<BSanidadCalibre> listaSanidad();
}
