/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.util.BArrayList;
import com.unsch.dto.BDetalleCompraProducto;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOProductoInventario {

    public List<BDetalleCompraProducto> listaProductoInventario(BArrayList arrayList);
}
