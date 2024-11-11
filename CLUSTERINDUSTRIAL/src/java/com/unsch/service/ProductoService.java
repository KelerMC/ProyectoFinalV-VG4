/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BProducto;
import com.unsch.dto.BProductoDetalle;
import com.unsch.util.BResultadoProceso;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface ProductoService {


    public BResultadoProceso registrarProducto(BProducto bProducto);
    public List<BProductoDetalle> listaProducto() ;

}
