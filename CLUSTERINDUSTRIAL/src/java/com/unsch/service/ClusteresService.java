/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BClusteres;
import com.unsch.domain.BUbigeo;
import com.unsch.util.BResultadoProceso;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface ClusteresService {

    public List<BClusteres> listaClusteres() ;
    public List<BUbigeo> listaUbigeo() ;
    public BResultadoProceso RegistrarCluster(BClusteres bClusteres);
    public BResultadoProceso UpdateCluster(BClusteres bClusteres) ;
    public BResultadoProceso DeleteCluster(BClusteres bClusteres);


}
