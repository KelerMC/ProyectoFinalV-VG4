/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOProductoInventario;
import com.unsch.util.BArrayList;
import com.unsch.dto.BDetalleCompraProducto;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ARANGO
 */
@Repository
public class DAOProductoInventario implements IDAOProductoInventario {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleCompraProducto> listaProductoInventario(final BArrayList arrayList) {
        String query = "begin :1 := WEB_PRODUCTO_INVENTARIO.LIST_PRODUCTO_INVENTARIO (:2); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleCompraProducto>>() {
            @Override
            public List<BDetalleCompraProducto> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.setInt(2, arrayList.getId1());
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleCompraProducto> list = new ArrayList<BDetalleCompraProducto>();
                while (rs.next()) {
                    BDetalleCompraProducto bPregunta = new BDetalleCompraProducto();
                    System.out.println("******** "+rs.getString(2));
                    bPregunta.setInventarioid(rs.getInt(1));
                    bPregunta.setCodigoproducto(rs.getString(2));
                    bPregunta.setDenominacionV(rs.getString(3));
                    bPregunta.setDescripcionP(rs.getString(4));
                    bPregunta.setDenominacionUM(rs.getString(5));
                    bPregunta.setCantidad(rs.getInt(6));
                    bPregunta.setPreciounitario(rs.getDouble(7));

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
