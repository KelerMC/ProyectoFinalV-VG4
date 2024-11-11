/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOUnidadMedida;
import com.unsch.domain.BUnidadMedida;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface UnidadMedidaService {


    public List<BUnidadMedida> listaUnidadMedida();
}
