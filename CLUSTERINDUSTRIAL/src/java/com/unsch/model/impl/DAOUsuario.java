/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOUsuario;
import com.unsch.domain.BUsuario;
import com.unsch.util.BResultadoProceso;
import com.unsch.dto.BDetalleUsuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
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
 * @author Morpheus
 */
@Repository
public class DAOUsuario implements IDAOUsuario {
    
  @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<BDetalleUsuario> listaUsuario() {
        String query = "BEGIN :1 := WEB_USUARIO.LIST_USUARIO (); END;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BDetalleUsuario>>() {
            @Override
            public List<BDetalleUsuario> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BDetalleUsuario> list = new ArrayList<BDetalleUsuario>();
                while (rs.next()) {
                    BDetalleUsuario bPregunta = new BDetalleUsuario();
                    bPregunta.setUsuarioid(rs.getInt(1));
                    bPregunta.setNombrecompleto(rs.getString(2));
                    bPregunta.setEstadousuario(rs.getString(3));

                    list.add(bPregunta);
                }
                return list;
            }
        });
        return lista;
    }

    @Override
    public BResultadoProceso InsertUsuario(final BUsuario bUsuario) {
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_USUARIO.AGREGAR_USUARIO(:1, :2, :3, :4, :5)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setInt(1, bUsuario.getSocioid());
                                cs.setInt(2, bUsuario.getRolusuarioid());
                                cs.setString(3, bUsuario.getNombreusuario());
                                cs.setString(4, bUsuario.getClaveusuario());
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
    public BResultadoProceso autenticaUsuario(final BUsuario bUsuario) {
        System.out.println("....autenticaUsuario..... "+bUsuario.getNombreusuario());
        final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                CallableStatement cs = con.prepareCall("{CALL WEB_USUARIO.VALIDAR_USUARIO (?, ?, ?, ?)}");
                                cs.setString(1, bUsuario.getNombreusuario());
                                cs.setString(2, bUsuario.getClaveusuario());
                                System.out.println("......... "+bUsuario.getNombreusuario());
                                        System.out.println("......... "+bUsuario.getClaveusuario());
                               /* cs.setString(3, null);
                                cs.setString(4, null);*/
                                 System.out.println(".......cs.getString(4).. "+cs.getString(4));
                                cs.registerOutParameter(3, Types.VARCHAR);
                                cs.registerOutParameter(4, Types.VARCHAR);
                                cs.execute();
                                if (cs.getString(4).equals("OK")) {
                                    System.out.println("aqui dentro del dao entro...");
                                    bUsuario.setExiste(1);
                                    bUsuario.setNombrecompleto(cs.getString(3));
                                    bResultadoProceso.setRta("SUCCESS");
                                    bResultadoProceso.setDet_rta("proceso ok");
                                } else {
                                    bResultadoProceso.setRta("ERR");
                                    bResultadoProceso.setDet_rta(cs.getString(4));
                                }
                                return cs;
                            } catch (Exception e) {
                                //e.printStackTrace();
                                bResultadoProceso.setRta("ERR");
                                bResultadoProceso.setDet_rta(e.getMessage());
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
        }
        return bResultadoProceso;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
