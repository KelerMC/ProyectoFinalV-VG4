/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOInventario;
import com.unsch.domain.BInventario;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleInventario;
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
public class DAOInventario implements IDAOInventario {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso InsertInventario(final BInventario bInventario) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_INVENTARIO.AGREGAR_INVENTARIO(:1, :2, :3, :4, :5, :6, :7, :8, :9)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bInventario.getAlmacenid());
                                cs.setInt(2, bInventario.getProductoid());
                                cs.setInt(3, bInventario.getUnidadmedidaid());
                                cs.setInt(4, bInventario.getTipodocumentoid());
                                cs.setInt(5, bInventario.getTipomovimientoid());

                                cs.setInt(6, bInventario.getCantidad());
                                cs.setDouble(7, bInventario.getPreciounitario());
                                cs.setDouble(8, bInventario.getPreciototal());
                                cs.setString(9, null);

                                cs.registerOutParameter(9, OracleTypes.VARCHAR);

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
    public List<BDetalleInventario> listaInventario() {
        String query = "begin :1 := WEB_INVENTARIO.LIST_INVENTARIO (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleInventario>>() {
            @Override
            public List<BDetalleInventario> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleInventario> list = new ArrayList<BDetalleInventario>();
                while (rs.next()) {
                    BDetalleInventario bPregunta = new BDetalleInventario();
                    bPregunta.setInventarioid(rs.getInt(1));
                    bPregunta.setDenominacionA(rs.getString(2));
                    bPregunta.setCodigoproducto(rs.getString(3));
                    bPregunta.setDenominacionUM(rs.getString(4));
                    bPregunta.setDescripcionTD(rs.getString(5));
                    bPregunta.setDenominacionTM(rs.getString(6));
                    bPregunta.setFechamovimiento(rs.getDate(7));
                    bPregunta.setCantidad(rs.getInt(8));
                    bPregunta.setPreciounitario(rs.getDouble(9));
                    bPregunta.setPreciototal(rs.getDouble(10));
                    bPregunta.setEstadoinventario(rs.getString(11));

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
