/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model;

import com.unsch.domain.BUsuario;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleUsuario;
import java.util.List;

/**
 *
 * @author Morpheus
 */
public interface IDAOUsuario {

    public BResultadoProceso InsertUsuario(BUsuario bUsuario);

    public BResultadoProceso autenticaUsuario(BUsuario bUsuario);

    public List<BDetalleUsuario> listaUsuario();
}
