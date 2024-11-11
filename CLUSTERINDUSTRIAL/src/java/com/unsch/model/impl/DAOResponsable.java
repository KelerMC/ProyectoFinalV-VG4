/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOResponsable;
import com.unsch.domain.BResponsable;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BResponsableSocioCluster;
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
public class DAOResponsable implements IDAOResponsable {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso InsertResponsable(final BResponsable bResponsable) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_RESPONSABLE.INS_RESPONSABLE(:1, :2, :3, :4, :5)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bResponsable.getSocioid());
                                cs.setInt(2, bResponsable.getClusteresid());
                                cs.setDate(3, bResponsable.getFechainicio());
                                cs.setDate(4, bResponsable.getFechafin());
                                cs.setString(5, null);

                                cs.registerOutParameter(5, OracleTypes.VARCHAR);

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
    public List<BResponsableSocioCluster> listaPersonaResponsable() {
        String query = "BEGIN :1 := WEB_RESPONSABLE.LIST_RESPONSABLE (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BResponsableSocioCluster>>() {
            @Override
            public List<BResponsableSocioCluster> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BResponsableSocioCluster> list = new ArrayList<BResponsableSocioCluster>();
                while (rs.next()) {
                    BResponsableSocioCluster bPregunta = new BResponsableSocioCluster();
                    bPregunta.setResponsableid(rs.getInt(1));
                    bPregunta.setNombrecompleto(rs.getString(2));
                    bPregunta.setDenominacion(rs.getString(3));
                    bPregunta.setFechainicio(rs.getDate(4));
                    bPregunta.setFechafin(rs.getDate(5));
                    bPregunta.setEstadoresponsable(rs.getString(6));

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
