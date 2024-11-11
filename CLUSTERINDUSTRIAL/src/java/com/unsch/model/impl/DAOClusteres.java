/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOClusteres;
import com.unsch.domain.BClusteres;
import com.unsch.domain.BUbigeo;
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
public class DAOClusteres implements IDAOClusteres {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BClusteres> listaClusteres() {
        String query = "BEGIN :1 := WEB_CLUSTERES.LIST_CLUSTERES (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BClusteres>>() {
            @Override
            public List<BClusteres> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BClusteres> list = new ArrayList<BClusteres>();
                while (rs.next()) {
                    BClusteres bClusteres = new BClusteres();
                    bClusteres.setClusteresid(rs.getInt(1));
                    bClusteres.setUbigeoid(rs.getInt(2));
                    bClusteres.setUbigeo(rs.getString(3));
                    bClusteres.setDenominacion(rs.getString(4));
                    bClusteres.setDescripcion(rs.getString(5));
                    bClusteres.setEstadoclusteres(rs.getString(6));
                    list.add(bClusteres);
                }
                return list;
            }
        });
        return lista;

    }

    @Override
    public List<BUbigeo> listaUbigeo() {
        String query = "begin :1 := WEB_CLUSTERES.LIST_UBIGEO (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BUbigeo>>() {
            @Override
            public List<BUbigeo> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BUbigeo> list = new ArrayList<BUbigeo>();
                while (rs.next()) {
                    BUbigeo bUbigeo = new BUbigeo();
                    bUbigeo.setUbigeoid(rs.getInt(1));
                    bUbigeo.setDescripcion(rs.getString(2));
                    list.add(bUbigeo);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso RegistrarCluster(final BClusteres bClusteres) {
        System.out.println("bClusteres.getDenominacion()--" + bClusteres.getDenominacion());
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_CLUSTERES.INS_CLUSTERES(:1, :2, :3, :4)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bClusteres.getUbigeoid());
                                cs.setString(2, bClusteres.getDenominacion());
                                cs.setString(3, bClusteres.getDescripcion());
                                cs.setString(4, null);

                                cs.registerOutParameter(4, OracleTypes.VARCHAR);

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
    public BResultadoProceso UpdateCluster(final BClusteres bClusteres) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_CLUSTERES.UPD_CLUSTERES(:1, :2, :3, :4, :5)}";

                                CallableStatement cs = con.prepareCall(query);
                                cs.setInt(1, bClusteres.getClusteresid());
                                cs.setInt(2, bClusteres.getUbigeoid());
                                cs.setString(3, bClusteres.getDenominacion());
                                cs.setString(4, bClusteres.getDescripcion());
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
    public BResultadoProceso DeleteCluster(final BClusteres bClusteres) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_CLUSTERES.DEL_CLUSTERES(:1, :2)}";

                                CallableStatement cs = con.prepareCall(query);
                                cs.setInt(1, bClusteres.getClusteresid());
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
