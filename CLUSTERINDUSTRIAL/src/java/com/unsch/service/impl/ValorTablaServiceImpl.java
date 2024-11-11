/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOValorTabla;
import com.unsch.domain.BValorTabla;
import com.unsch.service.ValorTablaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ARANGO
 */
@Service
public class ValorTablaServiceImpl implements  ValorTablaService{

    @Autowired
    private IDAOValorTabla dAOValorTabla;

    public List<BValorTabla> listaDocumentoIdentidad() {
        return this.dAOValorTabla.listaDocumentoIdentidad();
    }

    public List<BValorTabla> listaTipoPersona() {
        return this.dAOValorTabla.listaTipoPersona();
    }

    public List<BValorTabla> listaTipoTelefono() {
        return this.dAOValorTabla.listaTipoTelefono();
    }

    
}
