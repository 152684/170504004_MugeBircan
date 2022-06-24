/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mbirc
 * 
 * Klasse, um eine Verbindung mit dem Database zu erschaffen
 */
public class Connect {
 
     /**
     * Connect to a sample database
     */
    public Connection connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/AgencyDB.db"; /**< Lokation der Database*/
            conn = DriverManager.getConnection(url); /**< Verbindung mit der Database zu erschaffen*/            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Fehler");
        } 
        return conn;
    }
    
}
