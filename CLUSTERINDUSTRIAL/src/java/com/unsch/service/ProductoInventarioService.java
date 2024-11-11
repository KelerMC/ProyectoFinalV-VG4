/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOProductoInventario;
import com.unsch.util.BArrayList;
import com.unsch.dto.BDetalleCompraProducto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface ProductoInventarioService {

   
    public List<BDetalleCompraProducto> listaProductoInventario(BArrayList arrayList) ;

  
}
