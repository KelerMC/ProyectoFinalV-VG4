/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOSugerencia;
import com.unsch.domain.BSugerencia;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleSugerencia;
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
 * @author hp
 */
@Repository
public class DAOSugerencia implements IDAOSugerencia {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleSugerencia> listaSugerenciaDetalle() {
        String query = "BEGIN :1 := WEB_SUGERENCIA.LIST_SUGERENCIA (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleSugerencia>>() {
            @Override
            public List<BDetalleSugerencia> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleSugerencia> list = new ArrayList<BDetalleSugerencia>();
                while (rs.next()) {
                    BDetalleSugerencia bPregunta = new BDetalleSugerencia();
                    bPregunta.setSugerenciaid(rs.getInt(1));
                    bPregunta.setNombrecompleto(rs.getString(2));
                    bPregunta.setDenominacionClu(rs.getString(3));
                    bPregunta.setTextosugerencia(rs.getString(4));
                    bPregunta.setFechasugerencia(rs.getDate(5));
                    bPregunta.setClasificacionS(rs.getString(6));
                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertSugerencia(final BSugerencia bSugerencia) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_SUGERENCIA.INS_SUGERENCIA(:1, :2, :3, :4, :5)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bSugerencia.getClienteid());
                                cs.setInt(2, bSugerencia.getClusteresid());
                                cs.setString(3, bSugerencia.getTextosugerencia());
                                cs.setString(4, bSugerencia.getClasificacion());

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

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
