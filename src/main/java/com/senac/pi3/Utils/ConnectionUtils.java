/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senac.pi3.Utils;

/**
 *
 * @author Gabri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils 
{

    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Connection connection = null;
        
        
        String dbURL = "jdbc:mysql://root@localhost:3306/gamestore";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("serverTimezone" , "UTC");
        
        
        connection = DriverManager.getConnection(dbURL, properties);
        
        
        return connection;
    }
}