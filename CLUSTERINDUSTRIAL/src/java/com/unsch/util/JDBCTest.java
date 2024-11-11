/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.util;

/**
 *
 * @author Arango
 */
import java.sql.CallableStatement;
import java.sql.Connection;

/**
 * This class is used to get a record from DB table using CallableStatement.
 *
 * @author w3spoint
 */
public class JDBCTest {

    public static void main(String args[]) {
        Connection conn = null;
        CallableStatement callableStatement = null;
        String proc = "{call WEB_USUARIO.VALIDAR_USUARIO (?, ?, ?, ?)}";
        try {
//get connection
            conn = JDBCUtil.getConnection();
//create callableStatement
            callableStatement = conn.prepareCall(proc);
            callableStatement.setString(1, "CLAUDIO");
            callableStatement.setString(2, "123456");
            callableStatement.registerOutParameter(3,
                    java.sql.Types.VARCHAR);
            callableStatement.registerOutParameter(4,
                    java.sql.Types.VARCHAR);
//execute query
            callableStatement.executeUpdate();
//get employee name
            String empName = callableStatement.getString(3);
            System.out.println("Emp Name: " + empName);
            
             String rpta = callableStatement.getString(4);
            System.out.println("rpta Name: " + rpta);
//close connection
            callableStatement.close();
            conn.close();
            System.out.println("Record inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
