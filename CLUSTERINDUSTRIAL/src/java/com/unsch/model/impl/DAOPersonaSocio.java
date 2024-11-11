/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOPersonaSocio;
import com.unsch.dto.BPersonaSocio;
import com.unsch.util.BResultadoProceso;
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
public class DAOPersonaSocio implements IDAOPersonaSocio {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso registrarPersonaSocio(final BPersonaSocio bPersonaSocio) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_PERSONA_SOCIO.REGISTRAR_PERSONA_SOCIO(:1, :2, :3, :4, :5, :6, :7, :8, :9, :10, :11, :12, :13, :14, :15, :16)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bPersonaSocio.getIdubigeo());
                                cs.setInt(2, bPersonaSocio.getNacionalidadid());
                                cs.setString(3, bPersonaSocio.getNombrepersona());
                                cs.setString(4, bPersonaSocio.getApepaterno());
                                cs.setString(5, bPersonaSocio.getApmaterno());
                                cs.setInt(6, bPersonaSocio.getDocumentoidentidadid());
                                cs.setString(7, bPersonaSocio.getNumerodocumento());
                                cs.setString(8, bPersonaSocio.getDireccion());
                                cs.setString(9, bPersonaSocio.getReferenciadireccion());
                                cs.setString(10, bPersonaSocio.getEmailpersonal());
                                cs.setInt(11, bPersonaSocio.getIdtipotelefono());
                                cs.setString(12, bPersonaSocio.getNumerotelefono());
                                cs.setDate(13, bPersonaSocio.getFechanacimiento());
                                cs.setInt(14, bPersonaSocio.getTipopersonaid());
                                cs.setInt(15, bPersonaSocio.getClusteresid());
                                cs.setString(16, null);

                                cs.registerOutParameter(16, OracleTypes.VARCHAR);

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
