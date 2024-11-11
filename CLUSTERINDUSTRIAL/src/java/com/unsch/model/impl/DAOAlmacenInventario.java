/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOAlmacenInventario;
import com.unsch.dto.BAlmacenInventario;
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
 * @author Morpheus
 */
@Repository
public class DAOAlmacenInventario implements IDAOAlmacenInventario {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BAlmacenInventario> GraficaAlmacenInventario() {
        String query = "begin :1 := WEB_ALMACEN_INVENTARIO.LIST_ALMACEN_INVENTARIO (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BAlmacenInventario>>() {
            @Override
            public List<BAlmacenInventario> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BAlmacenInventario> list = new ArrayList<BAlmacenInventario>();
                while (rs.next()) {
                    BAlmacenInventario bPregunta = new BAlmacenInventario();
                    bPregunta.setInventarioid(rs.getInt(1));
                    bPregunta.setDenominacion(rs.getString(2));
                    bPregunta.setCantidad(rs.getInt(3));
                    bPregunta.setPreciounitario(rs.getDouble(4));
                    bPregunta.setPreciototal(rs.getDouble(5));
                    bPregunta.setPorcentaje(rs.getDouble(6));

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
