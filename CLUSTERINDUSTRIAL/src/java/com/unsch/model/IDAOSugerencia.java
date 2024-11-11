/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BSugerencia;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleSugerencia;
import java.util.List;

/**
 *
 * @author hp
 */
public interface IDAOSugerencia {

    public List<BDetalleSugerencia> listaSugerenciaDetalle();

    public BResultadoProceso InsertSugerencia(BSugerencia bSugerencia);
}
