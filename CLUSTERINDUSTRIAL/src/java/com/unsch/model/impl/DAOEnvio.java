/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOEnvio;
import com.unsch.domain.BEnvio;
import com.unsch.util.BResultadoProceso;
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
public class DAOEnvio implements IDAOEnvio {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BEnvio> listaEnvio() {
        String query = "BEGIN :1 := WEB_ENVIO.LIST_ENVIO (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BEnvio>>() {
            @Override
            public List<BEnvio> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BEnvio> list = new ArrayList<BEnvio>();
                while (rs.next()) {
                    BEnvio bEnvio = new BEnvio();

                    bEnvio.setEnvioid(rs.getInt(1));
                    bEnvio.setOrigen(rs.getString(2));
                    bEnvio.setDestino(rs.getString(3));
                    bEnvio.setHorasalida(rs.getDate(4));
                    bEnvio.setHorallegada(rs.getDate(5));
                    bEnvio.setTiempoentrega(rs.getString(6));
                    bEnvio.setConductor(rs.getString(7));
                    bEnvio.setNumeropersonal(rs.getInt(8));
                    bEnvio.setNumerocelular(rs.getString(9));
                    bEnvio.setPlacavehiculo(rs.getString(10));
                    bEnvio.setTipovehiculo(rs.getString(11));
                    bEnvio.setObservacion(rs.getString(12));
                    bEnvio.setTipoenvioid(rs.getInt(13));
                    bEnvio.setCertificadoid(rs.getInt(14));

                    list.add(bEnvio);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertEnvio(final BEnvio bEnvio) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_ENVIO.INS_ENVIO(:1, :2, :3, :4, :5, :6, :7, :8, :9, :10, :11, :12, :13, :14)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setString(1, bEnvio.getOrigen());
                                cs.setString(2, bEnvio.getDestino());
                                cs.setDate(3, bEnvio.getHorasalida());
                                cs.setDate(4, bEnvio.getHorallegada());
                                cs.setString(5, bEnvio.getTiempoentrega());
                                cs.setString(6, bEnvio.getConductor());
                                cs.setInt(7, bEnvio.getNumeropersonal());
                                cs.setString(8, bEnvio.getNumerocelular());
                                cs.setString(9, bEnvio.getPlacavehiculo());
                                cs.setString(10, bEnvio.getTipovehiculo());
                                cs.setString(11, bEnvio.getObservacion());
                                cs.setInt(12, bEnvio.getTipoenvioid());
                                cs.setInt(13, bEnvio.getCertificadoid());

                                cs.setString(14, null);

                                cs.registerOutParameter(14, OracleTypes.VARCHAR);

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
