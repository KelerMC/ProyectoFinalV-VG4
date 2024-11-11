/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOTipoMovimiento;
import com.unsch.domain.BTipoMovimiento;
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
public class DAOTipoMovimiento implements IDAOTipoMovimiento {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BTipoMovimiento> listaTipoMovimiento() {
        String query = "begin :1 := WEB_TIPOMOVIMIENTO.LIST_TIPOMOVIMIENTO (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BTipoMovimiento>>() {
            @Override
            public List<BTipoMovimiento> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BTipoMovimiento> list = new ArrayList<BTipoMovimiento>();
                while (rs.next()) {
                    BTipoMovimiento bTipoMovimiento = new BTipoMovimiento();

                    bTipoMovimiento.setTipomovimientoid(rs.getInt(1));
                    bTipoMovimiento.setDenominacion(rs.getString(2));
                    bTipoMovimiento.setDescripcion(rs.getString(3));
                    bTipoMovimiento.setIndentrada(rs.getString(4));
                    bTipoMovimiento.setIndtransferencia(rs.getString(5));
                    bTipoMovimiento.setInddevolucion(rs.getString(6));
                    bTipoMovimiento.setEstadotipomovimiento(rs.getString(7));

                    list.add(bTipoMovimiento);
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
