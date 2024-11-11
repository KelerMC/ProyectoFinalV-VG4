/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAORolUsuario;
import com.unsch.domain.BRolUsuario;
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
public class DAORolUsuario implements IDAORolUsuario {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BRolUsuario> listaRolUsuario() {
        String query = "BEGIN :1 := WEB_ROLUSUARIO.LIST_ROLUSUARIO (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BRolUsuario>>() {
            @Override
            public List<BRolUsuario> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BRolUsuario> list = new ArrayList<BRolUsuario>();
                while (rs.next()) {
                    BRolUsuario bPregunta = new BRolUsuario();
                    bPregunta.setIdrolusuario(rs.getInt(1));
                    bPregunta.setDenominacionrol(rs.getString(2));
                    bPregunta.setEstadorolusuario(rs.getString(3));

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
