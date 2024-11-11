/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BInventario;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleInventario;
import java.util.List;

/**
 *
 * @author ARANGO
 */
public interface IDAOInventario {

    public List<BDetalleInventario> listaInventario();

    public BResultadoProceso InsertInventario(BInventario bInventario);
}
