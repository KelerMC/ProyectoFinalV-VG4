/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOOrdenCompra;
import com.unsch.domain.BOrdenCompra;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleOrdenCompra;
import com.unsch.dto.BSubDetalleOrdenCompra;
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
public class DAOOrdenCompra implements IDAOOrdenCompra {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BSubDetalleOrdenCompra> subListaOrdenCompra(final BArrayList arrayList) {
        String query = "begin :1 := WEB_ORDENCOMPRA.LIST_ORDENCOMPRA_DETALLE (:2); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BSubDetalleOrdenCompra>>() {
            @Override
            public List<BSubDetalleOrdenCompra> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.setString(2, arrayList.getString1());
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BSubDetalleOrdenCompra> list = new ArrayList<BSubDetalleOrdenCompra>();
                while (rs.next()) {
                    BSubDetalleOrdenCompra bPregunta = new BSubDetalleOrdenCompra();

                    bPregunta.setProductoid(rs.getInt(1));
                    bPregunta.setNombrecompleto(rs.getString(2));
                    bPregunta.setDenominacionV(rs.getString(3));
                    bPregunta.setDenominacionC(rs.getString(4));
                    bPregunta.setDenominacionVC(rs.getString(5));
                    bPregunta.setRangoVC(rs.getString(6));
                    bPregunta.setPesoVC(rs.getString(7));
                    bPregunta.setDescripcionPRO(rs.getString(8));

                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BDetalleOrdenCompra> listaOrdenCompra() {
        String query = "begin :1 := WEB_ORDENCOMPRA.LIST_ORDENCOMPRA (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleOrdenCompra>>() {
            @Override
            public List<BDetalleOrdenCompra> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleOrdenCompra> list = new ArrayList<BDetalleOrdenCompra>();
                while (rs.next()) {
                    BDetalleOrdenCompra bPregunta = new BDetalleOrdenCompra();
                    bPregunta.setOrdencompraid(rs.getInt(1));
                    bPregunta.setCodigoproducto(rs.getString(2));
                    bPregunta.setCantidadOC(rs.getInt(3));
                    bPregunta.setPreciounitario(rs.getDouble(4));
                    bPregunta.setDenominacion(rs.getString(5));
                    bPregunta.setFechaorden(rs.getDate(6));
                    bPregunta.setFechaaprobacion(rs.getDate(7));
                    bPregunta.setValorventa(rs.getDouble(8));
                    bPregunta.setNombrecompleto(rs.getString(9));
                    bPregunta.setEstadoorden(rs.getString(10));

                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertOrdenCompra(final BOrdenCompra bAlmacen) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_ORDENCOMPRA.INS_ORDENCOMPRA(:1, :2, :3, :4, :5, :6)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bAlmacen.getClienteid());
                                cs.setInt(2, bAlmacen.getInventarioid());
                                cs.setInt(3, bAlmacen.getCantidad());
                                cs.setInt(4, bAlmacen.getMonedaid());
                                cs.setString(5, bAlmacen.getObservacion());
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
