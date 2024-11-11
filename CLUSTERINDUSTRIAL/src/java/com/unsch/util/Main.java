/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ARANGO
 */
public class Main {

    public static void main(String args[]) throws SQLException {

        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:PROD", "MICROSERVICIOS", "123456");
        // driver@machineName:port:SID           ,  userid,  password

        Statement stmt = conn.createStatement();
        ResultSet rset
                = stmt.executeQuery("select * from clusteres");
        while (rset.next()) {
            System.out.println(rset.getInt(1) + "---" + rset.getString(2)+ "---" + rset.getString(3));   // Print col 1
        }
        stmt.close();
    }
}
