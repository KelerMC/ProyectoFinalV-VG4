/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOCalibres;
import com.unsch.domain.BCalibres;
import com.unsch.domain.BVariedad;
import com.unsch.util.BResultadoProceso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ARANGO
 */
@Repository
public class DAOCalibres implements IDAOCalibres {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BCalibres> listaCalibres() {
        String query = "begin :1 := WEB_CALIBRES.LIST_CALIBRES (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BCalibres>>() {
            @Override
            public List<BCalibres> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BCalibres> list = new ArrayList<BCalibres>();
                while (rs.next()) {
                    BCalibres bCalibres = new BCalibres();
                    bCalibres.setCalibresid(rs.getInt(1));                          
                    bCalibres.setDenominacion(rs.getString(2));                
                    bCalibres.setEstadocalibres(rs.getString(3));
                    list.add(bCalibres);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BVariedad> listaVariedad() {
        String query = "begin :1 := WEB_CALIBRES.LIST_VARIEDAD (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BVariedad>>() {
            @Override
            public List<BVariedad> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BVariedad> list = new ArrayList<BVariedad>();
                while (rs.next()) {
                    BVariedad bVariedad = new BVariedad();
                    bVariedad.setVariedadid(rs.getInt(1)); 
                    bVariedad.setDenominacion(rs.getString(2));
                    bVariedad.setDescripcion(rs.getString(3));                   
                    bVariedad.setEstadovariedad(rs.getString(4));
                    list.add(bVariedad);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertCalibres(final BCalibres bCalibres) {
       final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection con) {
                    try {
                        String query = "{CALL WEB_CALIBRES.INS_CALIBRES(:1, :2)}";

                        CallableStatement cs = con.prepareCall(query);    
                        System.out.println("......... "+bCalibres.getDenominacion());
                        cs.setString(1, bCalibres.getDenominacion());                                   
                        cs.setString(2, null);
                        cs.registerOutParameter(2, OracleTypes.VARCHAR);
                     
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

    @Override
    public BResultadoProceso UpdateCalibres(final BCalibres bCalibres) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection con) {
                    try {
                        String query = "{CALL WEB_CALIBRES.UPD_CALIBRES(:1, :2, :3, :4, :5)}";
                        CallableStatement cs = con.prepareCall(query);
                        cs.setInt(1, bCalibres.getCalibresid());
                                  
                        cs.setString(3, bCalibres.getDenominacion());
                  
                        cs.setString(5, null);
                        cs.registerOutParameter(5, OracleTypes.VARCHAR);
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

    @Override
    public BResultadoProceso DeleteCalibres(final BCalibres bCalibres) {
       final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                @Override
                public CallableStatement createCallableStatement(Connection con) {
                    try {
                        String query = "{CALL WEB_CALIBRES.DEL_CALIBRES(:1, :2)}";

                        CallableStatement cs = con.prepareCall(query);

                        cs.setInt(1, bCalibres.getCalibresid());                        
                        cs.setString(2, null);

                        cs.registerOutParameter(2, OracleTypes.VARCHAR);

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
