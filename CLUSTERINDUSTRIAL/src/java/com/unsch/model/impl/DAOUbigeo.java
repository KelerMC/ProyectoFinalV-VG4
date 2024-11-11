/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOUbigeo;
import com.unsch.domain.BUbigeo;
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
public class DAOUbigeo implements IDAOUbigeo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BUbigeo> listaUbigeo() {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_UBIGEO.LIST_UBIGEO(); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();

                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            BUbigeo bUbigeo = new BUbigeo();
                            bUbigeo.setUbigeoid(rs.getInt(1));
                            bUbigeo.setDescripcion(rs.getString(2));
                            bUbigeo.setCoddpto(rs.getString(3));
                            bUbigeo.setCodprov(rs.getString(4));
                            bUbigeo.setCoddist(rs.getString(5));
                            bUbigeo.setFecharegistro(rs.getDate(6));
                            bUbigeo.setFechaactualizacion(rs.getDate(7));
                            list.add(bUbigeo);
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
