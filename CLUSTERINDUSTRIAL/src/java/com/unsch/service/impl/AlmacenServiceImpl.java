/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOAlmacen;
import com.unsch.domain.BAlmacen;
import com.unsch.domain.BClusteres;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BAlmacenCluster;
import com.unsch.service.AlmacenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class AlmacenServiceImpl implements AlmacenService{

    @Autowired
    private IDAOAlmacen dAOAlmacen;

    public List<BAlmacen> listaAlmacen(BArrayList arrayList) {
        return this.dAOAlmacen.listaAlmacen(arrayList);
    }

    public List<BAlmacenCluster> listaAlmacen() {
        return this.dAOAlmacen.listaAlmacen();
    }

    public List<BClusteres> listaCluster() {
        return this.dAOAlmacen.listaCluster();
    }

    public BResultadoProceso InsertAlmacen(BAlmacen bAlmacen) {
        return this.dAOAlmacen.InsertAlmacen(bAlmacen);
    }

    public BResultadoProceso UpdateAlmacen(BAlmacen bAlmacen) {
        return this.dAOAlmacen.UpdateAlmacen(bAlmacen);
    }

    public BResultadoProceso DeleteAlmacen(BAlmacen bAlmacen) {
        return this.dAOAlmacen.DeleteAlmacen(bAlmacen);
    }

   
}
