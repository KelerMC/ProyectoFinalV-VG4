/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOSocio;
import com.unsch.domain.BClusteres;
import com.unsch.domain.BPersona;
import com.unsch.domain.BSocio;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BClusterSocioPersona;
import com.unsch.dto.BPersonaSocio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface SocioService {

  

    public List<BPersonaSocio> listaPersonaSocio() ;

    public List<BClusterSocioPersona> listaSocio() ;

    public List<BClusteres> listaClusteres(BArrayList bOperacion) ;
    public List<BPersona> listaPersonas(BArrayList bOperacion);

    public BResultadoProceso InsertSocio(BSocio bSocio);

    public BResultadoProceso UpdateSocio(BSocio bSocio) ;

}
