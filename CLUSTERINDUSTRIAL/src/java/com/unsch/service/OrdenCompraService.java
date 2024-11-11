/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOOrdenCompra;
import com.unsch.domain.BOrdenCompra;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleOrdenCompra;
import com.unsch.dto.BSubDetalleOrdenCompra;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface OrdenCompraService {


    public List<BSubDetalleOrdenCompra> subListaOrdenCompra(BArrayList arrayList);

    public BResultadoProceso InsertOrdenCompra(BOrdenCompra bOrdenCompra);
    public List<BDetalleOrdenCompra> listaOrdenCompra() ;

  
}
