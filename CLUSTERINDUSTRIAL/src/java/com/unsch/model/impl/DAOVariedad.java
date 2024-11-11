/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOVariedad;
import com.unsch.domain.BAlmacen;
import com.unsch.domain.BUnidadMedida;
import com.unsch.domain.BVariedad;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BAlmacenInventario;
import com.unsch.dto.BDetalleVariedad;
import com.unsch.dto.BVariedadAlmacen;
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
public class DAOVariedad implements IDAOVariedad {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleVariedad> GraficaVariedadDemanda() {
        String query = "begin :1 := WEB_VARIEDAD_DEMANDA.LIST_VARIEDAD_DEMANDA (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleVariedad>>() {
            @Override
            public List<BDetalleVariedad> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleVariedad> list = new ArrayList<BDetalleVariedad>();
                while (rs.next()) {
                    BDetalleVariedad bPregunta = new BDetalleVariedad();
                    bPregunta.setVariedadid(rs.getInt(1));
                    bPregunta.setDenominacion(rs.getString(2));
                    bPregunta.setCantidad(rs.getInt(3));
                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BVariedad> listaVariedad() {
        String query = "begin :1 := WEB_VARIEDAD.LIST_VARIEDAD (); end;";
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
                    bVariedad.setAlmacenid(rs.getInt(2));
                    bVariedad.setDenominacion(rs.getString(3));
                    bVariedad.setDescripcion(rs.getString(4));
                    bVariedad.setImagen(rs.getString(5));
                    bVariedad.setEstadovariedad(rs.getString(6));

                    list.add(bVariedad);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BVariedadAlmacen> listaVariedadDetalle() {
        String query = "begin :1 := WEB_VARIEDAD.LIST_VARIEDAD_DETALLE (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BVariedadAlmacen>>() {
            @Override
            public List<BVariedadAlmacen> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BVariedadAlmacen> list = new ArrayList<BVariedadAlmacen>();
                while (rs.next()) {
                    BVariedadAlmacen bVariedad = new BVariedadAlmacen();

                    bVariedad.setVariedadid(rs.getInt(1));
                    bVariedad.setDenominacionA(rs.getString(2));
                    bVariedad.setDenominacionV(rs.getString(3));
                    bVariedad.setDescripcionV(rs.getString(4));
                    bVariedad.setImagen(rs.getString(5));
                    bVariedad.setEstadovariedad(rs.getString(6));

                    list.add(bVariedad);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BAlmacen> listaAlmacen() {
        String query = "begin :1 := WEB_VARIEDAD.LIST_ALMACEN (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BAlmacen>>() {
            @Override
            public List<BAlmacen> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BAlmacen> list = new ArrayList<BAlmacen>();
                while (rs.next()) {
                    BAlmacen bAlmacen = new BAlmacen();
                    bAlmacen.setAlmacenid(rs.getInt(1));
                    bAlmacen.setDenominacion(rs.getString(2));
                    bAlmacen.setDescripcion(rs.getString(3));
                    bAlmacen.setEstadoalmacen(rs.getString(4));
                    list.add(bAlmacen);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public List<BUnidadMedida> listaUnidad() {
        String query = "begin :1 := WEB_VARIEDAD.LIST_UNIDAD (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BUnidadMedida>>() {
            @Override
            public List<BUnidadMedida> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BUnidadMedida> list = new ArrayList<BUnidadMedida>();
                while (rs.next()) {
                    BUnidadMedida bUnidadMedida = new BUnidadMedida();
                    bUnidadMedida.setUnidadmedidaid(rs.getInt(1));
                    bUnidadMedida.setDenominacion(rs.getString(2));
                    bUnidadMedida.setEstadounidadmedida(rs.getString(3));
                    list.add(bUnidadMedida);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertVariedad(final BVariedad bVariedad) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_VARIEDAD.INS_VARIEDAD(:1, :2, :3, :4)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bVariedad.getAlmacenid());
                                cs.setString(2, bVariedad.getDenominacion());
                                cs.setString(3, bVariedad.getDescripcion());
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
    public BResultadoProceso UpdateVariedad(final BVariedad bVariedad) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_VARIEDAD.UPD_VARIEDAD(:1, :2, :3, :4, :5, :6)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bVariedad.getVariedadid());
                                cs.setInt(2, bVariedad.getAlmacenid());

                                cs.setString(4, bVariedad.getDenominacion());
                                cs.setString(5, bVariedad.getDescripcion());
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
    public BResultadoProceso DeleteVariedad(final BVariedad bVariedad) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_VARIEDAD.DEL_VARIEDAD(:1, :2)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bVariedad.getVariedadid());
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
