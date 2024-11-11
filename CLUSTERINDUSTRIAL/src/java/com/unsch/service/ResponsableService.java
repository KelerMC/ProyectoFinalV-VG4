/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BResponsable;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BResponsableSocioCluster;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface ResponsableService {

    
    public BResultadoProceso InsertResponsable(BResponsable bResponsable) ;

    public List<BResponsableSocioCluster> listaPersonaResponsable() ;

 
}
