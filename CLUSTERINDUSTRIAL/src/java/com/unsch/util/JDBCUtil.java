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
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This is a utility class for JDBC connection.
 *
 * @author w3spoint
 */
public class JDBCUtil {

    //JDBC and database properties.

    private static final String DB_DRIVER
            = "oracle.jdbc.driver.OracleDriver";
    private static final String DB_URL
            = "jdbc:oracle:thin:@localhost:1521:PROD";
    private static final String DB_USERNAME = "MICROSERVICIOS";
    private static final String DB_PASSWORD = "123456";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Register the JDBC driver
            Class.forName(DB_DRIVER);

            //Open the connection
            conn = DriverManager.
                    getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            if (conn != null) {
                System.out.println("Successfully connected.");
            } else {
                System.out.println("Failed to connect.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
