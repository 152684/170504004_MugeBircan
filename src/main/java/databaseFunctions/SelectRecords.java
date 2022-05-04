/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.mycompany.inf202.Mitarbeiter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mbirc
 */
public class SelectRecords {
    
    public void selectArbeiter(){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM arbeiter"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                System.out.println(rs.getString("name") + "\t" +
                                   rs.getInt("burgerID") +  "\t" +   
                                   rs.getString("anschrift") + "\t" +
                                   rs.getString("email") + "\t" +
                                   rs.getInt("telefonnummer") + "\t" +
                                   rs.getDate("geburtsdatum") + "\t" + 
                                   rs.getInt("personalID")); 
                Mitarbeiter m = new Mitarbeiter(rs.getString("name"), rs.getInt("burgerID"), rs.getString("anschrift"), rs.getString("email"), rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"));
                //mitarbeitern.add(m);
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
              
    }    
}
