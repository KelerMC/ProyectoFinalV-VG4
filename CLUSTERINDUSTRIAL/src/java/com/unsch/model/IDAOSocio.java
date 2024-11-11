/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BClusteres;
import com.unsch.domain.BPersona;
import com.unsch.domain.BSocio;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BClusterSocioPersona;
import com.unsch.dto.BPersonaSocio;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOSocio {

    public List<BClusterSocioPersona> listaSocio();

    public List<BClusteres> listaClusteres(BArrayList bOperacion);

    public List<BPersona> listaPersonas(BArrayList bOperacion);

    public BResultadoProceso InsertSocio(BSocio bSocio);

    public BResultadoProceso UpdateSocio(BSocio bSocio);

    public List<BPersonaSocio> listaPersonaSocio();
}
