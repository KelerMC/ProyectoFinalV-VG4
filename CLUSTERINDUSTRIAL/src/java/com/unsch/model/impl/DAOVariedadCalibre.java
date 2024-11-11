/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOVariedadCalibre;
import com.unsch.domain.BVariedadCalibre;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleVariedadCalibre;
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
public class DAOVariedadCalibre implements IDAOVariedadCalibre {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleVariedadCalibre> listaVariedadCalibre() {
        String query = "BEGIN :1 := WEB_VARIEDADCALIBRE.LIST_VARIEDADCALIBRE (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleVariedadCalibre>>() {
            @Override
            public List<BDetalleVariedadCalibre> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleVariedadCalibre> list = new ArrayList<BDetalleVariedadCalibre>();
                while (rs.next()) {
                    BDetalleVariedadCalibre bVariedadCalibre = new BDetalleVariedadCalibre();
                    bVariedadCalibre.setVariedadcalibreid(rs.getInt(1));
                    bVariedadCalibre.setDenominacionV(rs.getString(2));
                    bVariedadCalibre.setDenominacionC(rs.getString(3));
                    bVariedadCalibre.setDenominacionVC(rs.getString(4));
                    bVariedadCalibre.setRangoVC(rs.getString(5));
                    bVariedadCalibre.setPesoVC(rs.getString(6));
                    bVariedadCalibre.setEstadoVC(rs.getString(7));

                    list.add(bVariedadCalibre);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertVariedadCalibre(final BVariedadCalibre bVariedadCalibre) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_VARIEDADCALIBRE.AGREGAR_VARIEDADCALIBRE(:1, :2, :3, :4, :5, :6)}";

                                CallableStatement cs = con.prepareCall(query);
                                System.out.println("*********** ----------- " + bVariedadCalibre.getDenominacion());
                                cs.setInt(1, bVariedadCalibre.getVariedadid());
                                cs.setInt(2, bVariedadCalibre.getCalibresid());
                                cs.setString(3, bVariedadCalibre.getDenominacion());
                                cs.setString(4, bVariedadCalibre.getRango());
                                cs.setString(5, bVariedadCalibre.getPeso());
                                cs.setString(6, null);

                                cs.registerOutParameter(6, OracleTypes.VARCHAR);

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
            System.out.println("..." + ex.getMessage());
        }
        return bResultadoProceso;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
