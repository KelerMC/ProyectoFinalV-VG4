/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BAlmacen;
import com.unsch.domain.BClusteres;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BAlmacenCluster;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface AlmacenService {

  

    public List<BAlmacen> listaAlmacen(BArrayList arrayList) ;

    public List<BAlmacenCluster> listaAlmacen();

    public List<BClusteres> listaCluster() ;
    public BResultadoProceso InsertAlmacen(BAlmacen bAlmacen);
    public BResultadoProceso UpdateAlmacen(BAlmacen bAlmacen) ;

    public BResultadoProceso DeleteAlmacen(BAlmacen bAlmacen) ;


}
