/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BOrdenCompra;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleOrdenCompra;
import com.unsch.dto.BSubDetalleOrdenCompra;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOOrdenCompra {

    public List<BSubDetalleOrdenCompra> subListaOrdenCompra(BArrayList arrayList);

    public BResultadoProceso InsertOrdenCompra(BOrdenCompra bOrdenCompra);

    public List<BDetalleOrdenCompra> listaOrdenCompra();
}
