/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOSanidad;
import com.unsch.domain.BSanidad;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BSanidadCalibre;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ARANGO
 */
@Repository
public class DAOSanidad implements IDAOSanidad {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso InsertSanidad(final BSanidad bAlmacen) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_SANIDAD.INS_SANIDAD(:1, :2, :3, :4)}";

                                CallableStatement cs = con.prepareCall(query);
                                System.out.println("bAlmacen.getDenominacionsanidad()..." + bAlmacen.getDenominacionsanidad());
                                cs.setInt(1, bAlmacen.getCalibresid());
                                cs.setString(2, bAlmacen.getDenominacionsanidad());
                                cs.setInt(3, bAlmacen.getValorsanidad());
                                cs.setString(4, null);
                                cs.registerOutParameter(4, OracleTypes.VARCHAR);

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

    @Override
    public List<BSanidadCalibre> listaSanidad() {
        String query = "begin :1 := WEB_SANIDAD.LIST_SANIDAD (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BSanidadCalibre>>() {
            @Override
            public List<BSanidadCalibre> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BSanidadCalibre> list = new ArrayList<BSanidadCalibre>();
                while (rs.next()) {
                    BSanidadCalibre bPregunta = new BSanidadCalibre();
                    bPregunta.setSanidadid(rs.getInt(1));
                    bPregunta.setDenominacionC(rs.getString(2));
                    bPregunta.setDenominacionsanidadS(rs.getString(3));
                    bPregunta.setValorsanidad(rs.getInt(4));
                    bPregunta.setEstadosanidadS(rs.getString(5));
                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
