/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOCertificado;
import com.unsch.domain.BCertificado;
import com.unsch.util.BArrayList;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleCertificado;
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
public class DAOCertificado implements IDAOCertificado {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleCertificado> listaCertificadoCliente(final BArrayList bArrayList) {
        System.out.println("bArrayList---" + bArrayList.getId1());
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_CERTIFICADO.LIST_CERTIFICADO_CLIENTE(:2); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();
                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                        cs.setInt(2, bArrayList.getId1());
                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            BDetalleCertificado bPregunta = new BDetalleCertificado();

                            bPregunta.setCertificadoid(rs.getInt(1));
                            bPregunta.setCodigocertificado(rs.getString(2));
                            bPregunta.setNombreentidad(rs.getString(3));
                            bPregunta.setNombrecompleto(rs.getString(4));
                            bPregunta.setOrdencompraid(rs.getInt(5));
                            bPregunta.setFechacertificacion(rs.getDate(6));
                            bPregunta.setCantidad(rs.getInt(7));
                            bPregunta.setPreciounitario(rs.getDouble(8));
                            bPregunta.setCostototal(rs.getDouble(9));
                            bPregunta.setIgv(rs.getDouble(10));
                            bPregunta.setCostotrasnporte(rs.getDouble(11));
                            bPregunta.setPrecioventa(rs.getDouble(12));
                            bPregunta.setEstadoresponsable(rs.getString(13));
                            bPregunta.setEstadopagoC(rs.getString(14));
                            list.add(bPregunta);
                        }
                        return list;
                    }
                });
        return result;
    }

    @Override
    public BResultadoProceso activarCertificado(final BCertificado bCertificado) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();

        try {
            jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_CERTIFICADO.ACT_CERTIFICADO(:1,:2)}";
                                CallableStatement cs = con.prepareCall(query);
                                System.out.println("bCertificado.getCertificadoid()****" + bCertificado.getCertificadoid());

                                cs.setInt(1, bCertificado.getCertificadoid());
                                cs.setString(2, null);
                                cs.registerOutParameter(2, OracleTypes.VARCHAR);
                                cs.execute();
                                bResultadoProceso.setRta("OK");
                                bResultadoProceso.setDet_rta("\n El proceso se ejecutó satisfactoriamente");
                                return cs;
                            } catch (Exception e) {
                                bResultadoProceso.setRta("ERR");
                                bResultadoProceso.setDet_rta("\n " + e.getMessage());
                                e.printStackTrace();
                                return null;
                            }
                        }
                    }, new CallableStatementCallback() {
                        @Override
                        public Object doInCallableStatement(CallableStatement cs) {
                            try {
                                return null;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return null;
                        }
                    });
        } catch (Exception ex) {
            System.out.println("...");
        }
        return bResultadoProceso;
    }

    @Override
    public List<BDetalleCertificado> listaCertificadoPagado() {
        String query = "BEGIN :1 := WEB_CERTIFICADO.LIST_CERTIFICADO_PAGADO (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleCertificado>>() {
            @Override
            public List<BDetalleCertificado> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleCertificado> list = new ArrayList<BDetalleCertificado>();
                while (rs.next()) {
                    BDetalleCertificado bPregunta = new BDetalleCertificado();

                    bPregunta.setCertificadoid(rs.getInt(1));
                    bPregunta.setCodigocertificado(rs.getString(2));
                    bPregunta.setNombreentidad(rs.getString(3));
                    bPregunta.setNombrecompleto(rs.getString(4));
                    bPregunta.setOrdencompraid(rs.getInt(5));
                    bPregunta.setFechacertificacion(rs.getDate(6));
                    bPregunta.setCantidad(rs.getInt(7));
                    bPregunta.setPreciounitario(rs.getDouble(8));
                    bPregunta.setCostototal(rs.getDouble(9));
                    bPregunta.setIgv(rs.getDouble(10));
                    bPregunta.setCostotrasnporte(rs.getDouble(11));
                    bPregunta.setPrecioventa(rs.getDouble(12));
                    bPregunta.setEstadoresponsable(rs.getString(13));
                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BDetalleCertificado> listaCertificado() {
        String query = "BEGIN :1 := WEB_CERTIFICADO.LIST_CERTIFICADO (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleCertificado>>() {
            @Override
            public List<BDetalleCertificado> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleCertificado> list = new ArrayList<BDetalleCertificado>();
                while (rs.next()) {
                    BDetalleCertificado bPregunta = new BDetalleCertificado();

                    bPregunta.setCertificadoid(rs.getInt(1));
                    bPregunta.setCodigocertificado(rs.getString(2));
                    bPregunta.setNombreentidad(rs.getString(3));
                    bPregunta.setNombrecompleto(rs.getString(4));
                    bPregunta.setOrdencompraid(rs.getInt(5));
                    bPregunta.setFechacertificacion(rs.getDate(6));
                    bPregunta.setCantidad(rs.getInt(7));
                    bPregunta.setPreciounitario(rs.getDouble(8));
                    bPregunta.setCostototal(rs.getDouble(9));
                    bPregunta.setIgv(rs.getDouble(10));
                    bPregunta.setCostotrasnporte(rs.getDouble(11));
                    bPregunta.setPrecioventa(rs.getDouble(12));
                    bPregunta.setEstadoresponsable(rs.getString(13));
                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertCertificado(final BCertificado bCertificado) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_CERTIFICADO.INS_CERTIFICADO(:1, :2, :3, :4, :5, :6, :7, :8)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setString(1, bCertificado.getCodigocertificado());
                                cs.setInt(2, bCertificado.getEntidadgaranteid());
                                cs.setInt(3, bCertificado.getResponsableid());
                                cs.setInt(4, bCertificado.getOrdencompraid());
                                cs.setInt(5, bCertificado.getCantidad());
                                cs.setDouble(6, bCertificado.getPreciounitario());
                                cs.setDouble(7, bCertificado.getCostototal());
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
