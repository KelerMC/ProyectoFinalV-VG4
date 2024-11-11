package com.unsch.service;

import com.unsch.domain.BUsuario;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleUsuario;
import java.util.List;

/**
 *
 * @author Morpheus
 */

public interface UsuarioService {



    public BResultadoProceso InsertUsuario(BUsuario bUsuario) ;

    public BResultadoProceso autenticaUsuario(BUsuario bUsuario) ;

    public List<BDetalleUsuario> listaUsuario();
}
