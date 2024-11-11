/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOOrdenCompra;
import com.unsch.domain.BOrdenCompra;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleOrdenCompra;
import com.unsch.dto.BSubDetalleOrdenCompra;
import com.unsch.service.OrdenCompraService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class OrdenCompraServiceImpl implements  OrdenCompraService{

    @Autowired
    private IDAOOrdenCompra dAOOrdenCompra;

    public List<BSubDetalleOrdenCompra> subListaOrdenCompra(BArrayList arrayList) {
        return this.dAOOrdenCompra.subListaOrdenCompra(arrayList);
    }

    public BResultadoProceso InsertOrdenCompra(BOrdenCompra bOrdenCompra) {
        return this.dAOOrdenCompra.InsertOrdenCompra(bOrdenCompra);
    }

    public List<BDetalleOrdenCompra> listaOrdenCompra() {
        return this.dAOOrdenCompra.listaOrdenCompra();
    }

   
}
