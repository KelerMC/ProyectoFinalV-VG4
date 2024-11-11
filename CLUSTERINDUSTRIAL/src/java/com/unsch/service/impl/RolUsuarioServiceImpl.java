/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.service.impl;

import com.unsch.model.IDAORolUsuario;
import com.unsch.domain.BRolUsuario;
import com.unsch.service.RolUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author SISTEMAS
 */
@Service
public class RolUsuarioServiceImpl implements RolUsuarioService{

    @Autowired
    private IDAORolUsuario dAORolUsuario;

    public List<BRolUsuario> listaRolUsuario() {
        return this.dAORolUsuario.listaRolUsuario();
    }

}
