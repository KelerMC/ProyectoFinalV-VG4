/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOValorTabla;
import com.unsch.domain.BValorTabla;
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
public class DAOValorTabla implements IDAOValorTabla {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BValorTabla> listaDocumentoIdentidad() {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_VALORTABLA.LIST_VALORTABLA_DOCUMENTO(); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();

                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            System.out.println("dentro while");
                            BValorTabla bPregunta = new BValorTabla();
                            bPregunta.setTablaid(rs.getInt(1));
                            bPregunta.setItemid(rs.getInt(2));
                            bPregunta.setDenominacion(rs.getString(3));
                            bPregunta.setDescorta(rs.getString(4));
                            bPregunta.setValor(rs.getString(5));
                            list.add(bPregunta);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Override
    public List<BValorTabla> listaTipoPersona() {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_VALORTABLA.LIST_VALORTABLA_TIPO_PERSONA(); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();

                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            System.out.println("dentro while");
                            BValorTabla bPregunta = new BValorTabla();
                            bPregunta.setTablaid(rs.getInt(1));
                            bPregunta.setItemid(rs.getInt(2));
                            bPregunta.setDenominacion(rs.getString(3));
                            bPregunta.setDescorta(rs.getString(4));
                            bPregunta.setValor(rs.getString(5));
                            list.add(bPregunta);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Override
    public List<BValorTabla> listaTipoTelefono() {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_VALORTABLA.LIST_VALORTABLA_TELEFONO(); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();

                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            System.out.println("dentro while");
                            BValorTabla bPregunta = new BValorTabla();
                            bPregunta.setTablaid(rs.getInt(1));
                            bPregunta.setItemid(rs.getInt(2));
                            bPregunta.setDenominacion(rs.getString(3));
                            bPregunta.setDescorta(rs.getString(4));
                            bPregunta.setValor(rs.getString(5));
                            list.add(bPregunta);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
