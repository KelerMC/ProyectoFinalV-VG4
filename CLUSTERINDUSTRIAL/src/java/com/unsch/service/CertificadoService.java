/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.domain.BCertificado;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleCertificado;
import java.util.List;

/**
 *
 * @author ARANGO
 */

public interface CertificadoService {


    public List<BDetalleCertificado> listaCertificadoPagado();

    public List<BDetalleCertificado> listaCertificadoCliente(BArrayList bArrayList);

    public BResultadoProceso activarCertificado(BCertificado bCertificado);

    public List<BDetalleCertificado> listaCertificado();
    public BResultadoProceso InsertCertificado(BCertificado bCertificado) ;
   
}
