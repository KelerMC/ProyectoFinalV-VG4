/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAONacionalidad;
import com.unsch.domain.BNacionalidad;
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
public class DAONacionalidad implements IDAONacionalidad {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BNacionalidad> listaNacionalidad() {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_NACIONALIDAD.LIST_NACIONALIDAD(); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();

                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            System.out.println("dentro while");
                            BNacionalidad bPregunta = new BNacionalidad();
                            bPregunta.setNacionalidadid(rs.getInt(1));
                            bPregunta.setCodigonacionalidad(rs.getString(2));
                            bPregunta.setDenominacion(rs.getString(3));
                            bPregunta.setEstadonacionalidad(rs.getString(4));
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
