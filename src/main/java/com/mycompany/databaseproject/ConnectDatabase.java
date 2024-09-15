/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tnt25
 */
public class ConnectDatabase {

    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:sqlite:dcoffee.db";
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connect to SQLite has been establish");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally{
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
