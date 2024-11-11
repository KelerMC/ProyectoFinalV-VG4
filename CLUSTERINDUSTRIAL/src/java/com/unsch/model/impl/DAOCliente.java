/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOCliente;
import com.unsch.domain.BCliente;
import com.unsch.util.BResultadoProceso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SISTEMAS
 */
@Repository
public class DAOCliente implements IDAOCliente {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso autenticaCliente(final BCliente bCliente) {

        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                CallableStatement cs = con.prepareCall("{CALL WEB_CLIENTE.AUTENTICAR_CLIENTE (?, ?, ?, ?, ?)}");
                                cs.setString(1, bCliente.getNombrecliente());
                                cs.setString(2, bCliente.getClavecliente());
                                cs.setInt(3, 0);
                                cs.setString(4, null);
                                cs.setString(5, null);
                                cs.registerOutParameter(3, Types.NUMERIC);
                                cs.registerOutParameter(4, Types.VARCHAR);
                                cs.registerOutParameter(5, Types.VARCHAR);
                                System.out.println("bCliente.getNombrecliente()..... " + bCliente.getNombrecliente());
                                cs.execute();
                                if (cs.getString(5).equals("OK")) {
                                    System.out.println("entro el ultimo control");
                                    bCliente.setExiste(1);
                                    bCliente.setClienteid(cs.getInt(3));
                                    bCliente.setNombrecompleto(cs.getString(4));
                                    bResultadoProceso.setRta("SUCCESS");
                                    bResultadoProceso.setDet_rta("proceso ok");
                                } else {
                                    bResultadoProceso.setRta("ERR");
                                    bResultadoProceso.setDet_rta(cs.getString(5));
                                }
                                return cs;
                            } catch (Exception e) {
                                //e.printStackTrace();
                                bResultadoProceso.setRta("ERR");
                                bResultadoProceso.setDet_rta(e.getMessage());
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
        }
        return bResultadoProceso;
    }

    @Override
    public BResultadoProceso registrarCliente(final BCliente bEvaluacion) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL PKG_CA_EVALUA.INSERTEVALUA(:1,:2,:3,:4)}";
                                CallableStatement cs = con.prepareCall(query);

//                                cs.setString(1, bEvaluacion.getIdtercero());
//                                cs.setInt(2, bEvaluacion.getNropreg());
//                                cs.setInt(3, bEvaluacion.getIdpreg());
//                                cs.setString(4, bEvaluacion.getRtapreg());
                                cs.execute();
                                bResultadoProceso.setRta("OK");
                                bResultadoProceso.setDet_rta("\n El proceso se ejecutó satisfactoriamente");
                                return cs;
                            } catch (Exception e) {
                                bResultadoProceso.setRta("ERR");
                                bResultadoProceso.setDet_rta("\n " + e.getMessage());
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }, new CallableStatementCallback() {
                        @Override
                        public Object doInCallableStatement(CallableStatement cs) {
                            try {
                                return null;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
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
