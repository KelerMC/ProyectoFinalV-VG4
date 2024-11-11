/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOVariedad;
import com.unsch.domain.BAlmacen;
import com.unsch.domain.BUnidadMedida;
import com.unsch.domain.BVariedad;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BVariedadAlmacen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */

public interface VariedadService {


    public List<BVariedad> listaVariedad();

    public List<BVariedadAlmacen> listaVariedadDetalle();

    public List<BAlmacen> listaAlmacen() ;

    public List<BUnidadMedida> listaUnidad() ;

    public BResultadoProceso InsertVariedad(BVariedad bVariedad) ;

    public BResultadoProceso UpdateVariedad(BVariedad bVariedad) ;

    public BResultadoProceso DeleteVariedad(BVariedad bVariedad) ;



}
