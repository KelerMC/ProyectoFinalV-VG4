/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAOTipoMovimiento;
import com.unsch.domain.BTipoMovimiento;
import com.unsch.service.TipoMovimientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Morpheus
 */
@Service
public class TipoMovimientoServiceImpl implements TipoMovimientoService {

    @Autowired
    private IDAOTipoMovimiento dAOTipoMovimiento;

    public List<BTipoMovimiento> listaTipoMovimiento() {
        return this.dAOTipoMovimiento.listaTipoMovimiento();
    }

}
