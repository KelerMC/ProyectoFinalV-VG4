/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service;

import com.unsch.model.IDAOTipoMovimiento;
import com.unsch.domain.BTipoMovimiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Morpheus
 */

public interface TipoMovimientoService {

  

    public List<BTipoMovimiento> listaTipoMovimiento() ;

}
