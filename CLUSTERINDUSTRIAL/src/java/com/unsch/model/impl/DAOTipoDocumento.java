/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOTipoDocumento;
import com.unsch.domain.BTipoDocumento;
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
 * @author SISTEMAS
 */
@Repository
public class DAOTipoDocumento implements IDAOTipoDocumento {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BTipoDocumento> listaTipoDocumento() {

        String query = "begin :1 := WEB_TIPODOCUMENTO.LIST_TIPODOCUMENTO (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BTipoDocumento>>() {
            @Override
            public List<BTipoDocumento> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BTipoDocumento> list = new ArrayList<BTipoDocumento>();
                while (rs.next()) {
                    BTipoDocumento bTipoDocumento = new BTipoDocumento();
                    bTipoDocumento.setTipodocumentoid(rs.getInt(1));
                    bTipoDocumento.setDenominacion(rs.getString(2));
                    bTipoDocumento.setDescripcion(rs.getString(3));
                    bTipoDocumento.setIndventa(rs.getString(4));
                    bTipoDocumento.setIndalmacen(rs.getString(5));
                    bTipoDocumento.setIndalmacenmov(rs.getString(6));
                    bTipoDocumento.setEstadotipodocumento(rs.getString(7));

                    list.add(bTipoDocumento);
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
