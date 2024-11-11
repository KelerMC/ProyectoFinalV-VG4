/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOEntidadGarante;
import com.unsch.domain.BEntidadGarante;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleEntidadGarante;
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
public class DAOEntidadGarante implements IDAOEntidadGarante {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleEntidadGarante> listaEntidadGarante() {
        String query = "begin :1 := WEB_ENTIDADGARANTE.LIST_ENTIDADGARANTE (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleEntidadGarante>>() {
            @Override
            public List<BDetalleEntidadGarante> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleEntidadGarante> list = new ArrayList<BDetalleEntidadGarante>();
                while (rs.next()) {
                    BDetalleEntidadGarante bVariedad = new BDetalleEntidadGarante();

                    bVariedad.setEntidadgaranteid(rs.getInt(1));
                    bVariedad.setDenominacion(rs.getString(2));
                    bVariedad.setNombreentidad(rs.getString(3));
                    bVariedad.setTelefenofijo(rs.getString(4));
                    bVariedad.setRepresentante(rs.getString(5));
                    bVariedad.setCargo(rs.getString(6));

                    list.add(bVariedad);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertEntidadGarante(final BEntidadGarante bEntidadGarante) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_ENTIDADGARANTE.INS_ENTIDADGARANTE(:1, :2, :3, :4, :5, :6)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bEntidadGarante.getClusteresid());
                                cs.setString(2, bEntidadGarante.getNombreentidad());
                                cs.setString(3, bEntidadGarante.getTelefenofijo());
                                cs.setString(4, bEntidadGarante.getRepresentante());
                                cs.setString(5, bEntidadGarante.getCargo());

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
            System.out.println("...");
        }
        return bResultadoProceso;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
