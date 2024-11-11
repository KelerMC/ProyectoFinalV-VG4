package com.unsch.service.impl;

import com.unsch.model.IDAOUsuario;
import com.unsch.domain.BUsuario;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleUsuario;
import com.unsch.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Morpheus
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private IDAOUsuario dAOUsuario;

    public BResultadoProceso InsertUsuario(BUsuario bUsuario) {
        return this.dAOUsuario.InsertUsuario(bUsuario);
    }

    public BResultadoProceso autenticaUsuario(BUsuario bUsuario) {
        return this.dAOUsuario.autenticaUsuario(bUsuario);
    }

    public List<BDetalleUsuario> listaUsuario() {
        return this.dAOUsuario.listaUsuario();
    }

   
}
