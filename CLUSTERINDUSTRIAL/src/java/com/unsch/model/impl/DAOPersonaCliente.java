/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOPersonaCliente;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BPersonaCliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ARANGO
 */
@Repository
public class DAOPersonaCliente implements IDAOPersonaCliente {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso RegistrarPersonaCliente(final BPersonaCliente bPersonaCliente) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        System.out.println("aqui hssssssssss");
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_PERSONA_CLIENTE.REGISTRO_PERSONA_CLIENTE(:1, :2, :3, :4, :5, :6, :7, :8, :9, :10, :11, :12, :13, :14, :15, :16, :17, :18, :19)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bPersonaCliente.getIdubigeo());
                                cs.setInt(2, bPersonaCliente.getNacionalidadid());
                                cs.setString(3, bPersonaCliente.getNombrepersona());
                                cs.setString(4, bPersonaCliente.getApepaterno());
                                cs.setString(5, bPersonaCliente.getApmaterno());
                                cs.setInt(6, bPersonaCliente.getDocumentoidentidadid());
                                cs.setString(7, bPersonaCliente.getNumerodocumento());
                                cs.setString(8, bPersonaCliente.getDireccion());
                                cs.setString(9, bPersonaCliente.getReferenciadireccion());
                                cs.setString(10, bPersonaCliente.getEmailpersonal());

                                cs.setInt(11, bPersonaCliente.getIdtipotelefono());
                                cs.setString(12, bPersonaCliente.getNumerotelefono());
                                cs.setDate(13, bPersonaCliente.getFechanacimiento());
                                cs.setInt(14, bPersonaCliente.getTipopersonaid());
                                cs.setString(15, bPersonaCliente.getCodigopostal());
                                cs.setString(16, bPersonaCliente.getRegion());
                                cs.setString(17, bPersonaCliente.getNombrecliente());
                                cs.setString(18, bPersonaCliente.getClavecliente());

                                cs.registerOutParameter(19, OracleTypes.VARCHAR);

                                System.out.println("sjjjjjjjjjjjjjjjjjjjj");
                                cs.execute();

                                bResultadoProceso.setRta("OK");
                                bResultadoProceso.setDet_rta("\n El proceso se ejecutó satisfactoriamente");
                                return cs;
                            } catch (Exception e) {
                                bResultadoProceso.setRta("ERR");
                                bResultadoProceso.setDet_rta("\n " + e.getMessage());
                                return null;
                            }
                        }
                    }, new CallableStatementCallback() {
                        @Override
                        public Object doInCallableStatement(CallableStatement cs) {
                            return null;
                        }
                    });
        } catch (Exception ex) {
            System.out.println("...");
        }
        return bResultadoProceso;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
