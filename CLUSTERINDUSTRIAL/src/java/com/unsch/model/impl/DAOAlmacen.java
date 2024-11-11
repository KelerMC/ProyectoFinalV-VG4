/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOAlmacen;
import com.unsch.domain.BAlmacen;
import com.unsch.domain.BClusteres;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BAlmacenCluster;
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
public class DAOAlmacen implements IDAOAlmacen {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BAlmacen> listaAlmacen(final BArrayList arrayList) {
        String query = "BEGIN :1 := WEB_ALMACEN.LIST_ALMACEN (:2); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BAlmacen>>() {
            @Override
            public List<BAlmacen> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.setInt(2, arrayList.getId1());
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BAlmacen> list = new ArrayList<BAlmacen>();
                while (rs.next()) {
                    BAlmacen almacen = new BAlmacen();
                    almacen.setAlmacenid(rs.getInt(1));
                    almacen.setClusteresid(rs.getInt(2));
                    almacen.setDenominacion(rs.getString(3));
                    almacen.setDescripcion(rs.getString(4));
                    almacen.setIndestadoapertura(rs.getString(5));
                    almacen.setFechaapertura(rs.getDate(6));
                    almacen.setEstadoalmacen(rs.getString(7));
                    list.add(almacen);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BAlmacenCluster> listaAlmacen() {
        String query = "BEGIN :1 := WEB_ALMACEN.LIST_ALMACEN (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BAlmacenCluster>>() {
            @Override
            public List<BAlmacenCluster> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BAlmacenCluster> list = new ArrayList<BAlmacenCluster>();
                while (rs.next()) {
                    BAlmacenCluster bPregunta = new BAlmacenCluster();
                    bPregunta.setAlmacenid(rs.getInt(1));
                    bPregunta.setDenominacionC(rs.getString(2));
                    bPregunta.setDenominacionA(rs.getString(3));
                    bPregunta.setDescripcionA(rs.getString(4));
                    bPregunta.setIndestadoapertura(rs.getString(5));
                    bPregunta.setFechaapertura(rs.getDate(6));
                    bPregunta.setEstadoalmacen(rs.getString(7));
                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BClusteres> listaCluster() {
        String query = "begin :1 := WEB_ALMACEN.LIST_CLUSTERES (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BClusteres>>() {
            @Override
            public List<BClusteres> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BClusteres> list = new ArrayList<BClusteres>();
                while (rs.next()) {
                    BClusteres bClusteres = new BClusteres();
                    bClusteres.setUbigeoid(rs.getInt(1));
                    bClusteres.setDescripcion(rs.getString(2));
                    list.add(bClusteres);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertAlmacen(final BAlmacen bAlmacen) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_ALMACEN.INS_ALMACEN(:1, :2, :3, :4, :5, :6, :7, :8, :9)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bAlmacen.getClusteresid());
                                cs.setString(2, bAlmacen.getDenominacion());
                                cs.setString(3, bAlmacen.getDescripcion());
                                cs.setString(4, bAlmacen.getIndestadoapertura());
                                cs.setString(5, bAlmacen.getHorareferencia());
                                cs.setInt(6, bAlmacen.getCantidadvia());
                                cs.setDouble(7, bAlmacen.getCostotransporte());
                                cs.setString(8, bAlmacen.getTelefonoalmacen());

                                cs.setString(9, null);

                                cs.registerOutParameter(9, OracleTypes.VARCHAR);

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
    public BResultadoProceso UpdateAlmacen(final BAlmacen bAlmacen) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_ALMACEN.UPD_ALMACEN(:1, :2, :3, :4, :5, :6)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bAlmacen.getAlmacenid());
                                cs.setInt(2, bAlmacen.getClusteresid());
                                cs.setString(3, bAlmacen.getDenominacion());
                                cs.setString(4, bAlmacen.getDescripcion());
                                cs.setString(5, bAlmacen.getIndestadoapertura());
                                cs.setString(6, null);

                                cs.registerOutParameter(6, OracleTypes.VARCHAR);

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
    public BResultadoProceso DeleteAlmacen(final BAlmacen bAlmacen) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_ALMACEN.DEL_ALMACEN(:1, :2)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bAlmacen.getAlmacenid());
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
