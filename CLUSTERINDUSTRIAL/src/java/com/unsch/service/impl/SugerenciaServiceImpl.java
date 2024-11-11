/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOSugerencia;
import com.unsch.domain.BSugerencia;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleSugerencia;
import com.unsch.service.SugerenciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class SugerenciaServiceImpl implements SugerenciaService{

    @Autowired
    private IDAOSugerencia dAOSugerencia;

    public List<BDetalleSugerencia> listaSugerenciaDetalle() {
        return this.dAOSugerencia.listaSugerenciaDetalle();
    }

    public BResultadoProceso InsertSugerencia(BSugerencia bSugerencia) {
        return this.dAOSugerencia.InsertSugerencia(bSugerencia);
    }

    
}
