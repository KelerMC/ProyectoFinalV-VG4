/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOMovimiento;
import com.unsch.domain.BMovimiento;
import com.unsch.util.BResultadoProceso;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ARANGO
 */
@Repository
public class DAOMovimiento implements IDAOMovimiento {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BResultadoProceso InsertMovimiento(final BMovimiento bMovimiento) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_MOVIMIENTO.INS_MOVIMIENTO(:1, :2, :3, :4, :5, :6, :7, :8)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setDouble(1, bMovimiento.getSubtotal());
                                cs.setString(2, bMovimiento.getGlosa());
                                cs.setString(3, bMovimiento.getBoucher());
                                cs.setInt(4, bMovimiento.getCertificadoid());
                                cs.setString(5, bMovimiento.getCci());
                                cs.setString(6, bMovimiento.getNumerotransaccion());
                                cs.setDate(7, bMovimiento.getFechatransaccion());

                                cs.setString(8, null);

                                cs.registerOutParameter(8, OracleTypes.VARCHAR);

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

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
