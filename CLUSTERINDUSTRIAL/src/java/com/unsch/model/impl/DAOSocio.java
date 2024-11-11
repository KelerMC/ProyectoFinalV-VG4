/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOSocio;
import com.unsch.domain.BClusteres;
import com.unsch.domain.BPersona;
import com.unsch.domain.BSocio;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BClusterSocioPersona;
import com.unsch.dto.BPersonaSocio;
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
public class DAOSocio implements IDAOSocio {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BPersonaSocio> listaPersonaSocio() {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_SOCIO.LISTA_PERSONA_SOCIO(); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();
                        cs.registerOutParameter(1, OracleTypes.CURSOR);

                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            BPersonaSocio bPersona = new BPersonaSocio();
                            bPersona.setSocioid(rs.getInt(1));
                            bPersona.setNombrecompleto(rs.getString(2));
                            list.add(bPersona);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Override
    public List<BClusterSocioPersona> listaSocio() {
        String query = "BEGIN :1 := WEB_SOCIO.LIST_SOCIO (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BClusterSocioPersona>>() {
            @Override
            public List<BClusterSocioPersona> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BClusterSocioPersona> list = new ArrayList<BClusterSocioPersona>();
                while (rs.next()) {
                    BClusterSocioPersona bSocio = new BClusterSocioPersona();
                    bSocio.setSocioid(rs.getInt(1));
                    bSocio.setPersonaid(rs.getInt(2));
                    bSocio.setClusteresid(rs.getInt(3));
                    bSocio.setDenominacion(rs.getString(4));
                    bSocio.setNombrecompleto(rs.getString(5));
                    bSocio.setFecharegistro(rs.getDate(6));
                    bSocio.setEstadocuenta(rs.getInt(7));

                    list.add(bSocio);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BClusteres> listaClusteres(final BArrayList bArrayList) {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_SOCIO.LIST_CLUSTERES (:2); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();
                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                        cs.setString(2, bArrayList.getString1());
                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            BClusteres bClusteres = new BClusteres();
                            bClusteres.setClusteresid(rs.getInt(1));
                            bClusteres.setDenominacion(rs.getString(2));
                            list.add(bClusteres);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Override
    public List<BPersona> listaPersonas(final BArrayList bArrayList) {
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_SOCIO.LIST_PERSONA (:2); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();
                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                        cs.setString(2, bArrayList.getString1());
                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            BPersona bPersona = new BPersona();
                            bPersona.setPersonaid(rs.getInt(1));
                            bPersona.setNombrecompleto(rs.getString(2));
                            list.add(bPersona);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Override
    public BResultadoProceso InsertSocio(final BSocio bSocio) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_SOCIO.INS_SOCIO(:1, :2,:3,:4,:5,:6,:7,:8,:9)}";
                                System.out.println("aquiiiiiiiiiiiiiiiiiiiiiiiii");
                                CallableStatement cs = con.prepareCall(query);
                                cs.setInt(1, bSocio.getPersonaid());
                                cs.setInt(2, bSocio.getClusteresid());
                                cs.setDate(3, bSocio.getFechacancelacion());
                                cs.setString(4, bSocio.getObscancelacion());
                                cs.setInt(5, bSocio.getIndiceestado());
                                cs.setDate(6, bSocio.getFechasuspencion());
                                cs.setString(7, bSocio.getObssuspencion());
                                cs.setInt(8, bSocio.getEstadocuenta());
                                cs.setString(9, null);
                                cs.registerOutParameter(9, OracleTypes.VARCHAR);
                                System.out.println("kkkkkkkk----" + cs.execute());
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
            System.out.println("..." + ex.toString());
        }
        return bResultadoProceso;
    }

    @Override
    public BResultadoProceso UpdateSocio(final BSocio bSocio) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_SOCIO.UPD_SOCIO(:1, :2,:3,:4,:5,:6,:7,:8,:9,:10)}";

                                CallableStatement cs = con.prepareCall(query);
                                cs.setInt(1, bSocio.getSocioid());
                                cs.setInt(2, bSocio.getPersonaid());
                                cs.setInt(3, bSocio.getClusteresid());
                                cs.setDate(4, bSocio.getFechacancelacion());
                                cs.setString(5, bSocio.getObscancelacion());
                                cs.setInt(6, bSocio.getIndiceestado());
                                cs.setDate(7, bSocio.getFechasuspencion());
                                cs.setString(8, bSocio.getObssuspencion());
                                cs.setInt(9, bSocio.getEstadocuenta());
                                cs.setString(10, null);
                                cs.registerOutParameter(10, OracleTypes.VARCHAR);
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
