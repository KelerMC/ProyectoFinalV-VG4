/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BValorTabla;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface ValorTablaService {


    public List<BValorTabla> listaDocumentoIdentidad() ;

    public List<BValorTabla> listaTipoPersona() ;
    public List<BValorTabla> listaTipoTelefono() ;
}
