/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.model.impl;

import com.unsch.model.IDAOOperacion;
import com.unsch.domain.BInventario;
import com.unsch.domain.BOperacion;
import com.unsch.util.BArrayList;
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
public class DAOOperacion implements IDAOOperacion {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
     public BResultadoProceso agregarOperacion(final BOperacion bOperacion){
          final BResultadoProceso bResultadoProceso = new BResultadoProceso();
        try {
            this.jdbcTemplate.execute(
                    new CallableStatementCreator() {
                        @Override
                        public CallableStatement createCallableStatement(Connection con) {
                            try {
                                String query = "{CALL WEB_OPERACION.REGISTRAR_OPERACION(:1, :2)}";

                                CallableStatement cs = con.prepareCall(query);

                                cs.setString(1, bOperacion.getDenominacionoperacion());
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
    public List<BOperacion> listaOperacion() {
        String query = "begin :1 := WEB_OPERACION.LIST_OPERACION (); end;";
        List lista = this.jdbcTemplate.execute(query, new CallableStatementCallback<List<BOperacion>>() {
            @Override
            public List<BOperacion> doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                cs.registerOutParameter(1, OracleTypes.CURSOR);
                cs.execute();
                ResultSet rs = (ResultSet) cs.getObject(1);
                List<BOperacion> list = new ArrayList<BOperacion>();
                while (rs.next()) {
                    System.out.println("aqui----------------------");
                    BOperacion bPregunta = new BOperacion();
                    bPregunta.setOperacionid(rs.getInt(1));
                    bPregunta.setDenominacionoperacion(rs.getString(2));
                    bPregunta.setFecharegistro(rs.getDate(3));
                    bPregunta.setFechaactualizacion(rs.getDate(4));
                    bPregunta.setEstadooperacion(rs.getString(5));
                    list.add(bPregunta);
                }
                return list;
            }//select OPERACIONID, DENOMINACIONOPERACION, FECHAREGISTRO, FECHAACTUALIZACION, ESTADOOPERACION from operacion
        });
        return lista;
    }
@Override
    public List<BOperacion> listaOpracion(final BArrayList bArrayList) {       
        List result = (List) this.jdbcTemplate.execute("BEGIN :1 := WEB_OPERACION.LIST_OPERACION (:2); END;",
                new CallableStatementCallback() {
                    @Override
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        List list = new ArrayList();
                        cs.registerOutParameter(1, OracleTypes.CURSOR);
                        cs.setString(2, bArrayList.getString1());
                        cs.execute();
                        ResultSet rs = (ResultSet) cs.getObject(1);
                        while (rs.next()) {
                            BOperacion bOperacion = new BOperacion();
                            bOperacion.setOperacionid(rs.getInt(1));
                            bOperacion.setDenominacionoperacion(rs.getString(2));                           
                            list.add(bOperacion);
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
