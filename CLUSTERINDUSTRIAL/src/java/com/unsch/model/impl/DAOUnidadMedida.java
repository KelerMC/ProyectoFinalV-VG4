/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOUnidadMedida;
import com.unsch.domain.BUnidadMedida;
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
public class DAOUnidadMedida implements IDAOUnidadMedida {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BUnidadMedida> listaUnidadMedida() {

        String query = "begin :1 := WEB_UNIDADMEDIDA.LIST_UNIDADMEDIDA (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BUnidadMedida>>() {
            @Override
            public List<BUnidadMedida> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BUnidadMedida> list = new ArrayList<BUnidadMedida>();
                while (rs.next()) {
                    BUnidadMedida bPregunta = new BUnidadMedida();

                    bPregunta.setUnidadmedidaid(rs.getInt(1));
                    bPregunta.setDenominacion(rs.getString(2));
                    bPregunta.setEstadounidadmedida(rs.getString(3));
                    bPregunta.setCodigounidad(rs.getString(4));

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
