/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOProducto;
import com.unsch.domain.BProducto;
import com.unsch.dto.BProductoDetalle;
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
public class DAOProducto implements IDAOProducto {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso registrarProducto(final BProducto bProducto) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_PRODUCTO.AGREGAR_PRODUCTO(:1, :2, :3, :4, :5, :6)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bProducto.getVariedadcalibreid());
                                cs.setInt(2, bProducto.getSocioid());

                                cs.setString(3, bProducto.getDescripcion());
                                cs.setString(4, bProducto.getImageurl());
                                cs.setString(5, bProducto.getCodigoproducto());
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

    @Override
    public List<BProductoDetalle> listaProducto() {
        String query = "begin :1 := WEB_PRODUCTO.LIST_PRODUCTO (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BProductoDetalle>>() {
            @Override
            public List<BProductoDetalle> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BProductoDetalle> list = new ArrayList<BProductoDetalle>();
                while (rs.next()) {
                    BProductoDetalle bPregunta = new BProductoDetalle();
                    bPregunta.setProductoid(rs.getInt(1));
                    bPregunta.setNombrecompleto(rs.getString(2));
                    bPregunta.setCodigoproducto(rs.getString(3));
                    bPregunta.setDenominacion(rs.getString(4));
                    bPregunta.setDescripcion(rs.getString(5));
                    bPregunta.setImageurl(rs.getString(6));
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
