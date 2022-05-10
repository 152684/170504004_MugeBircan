/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.mycompany.inf202.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mbirc
 */
public class SelectRecords {
    
    public static void allMitarbeiterInArray(ArrayList<Mitarbeiter> mitarbeitern){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM mitarbeiter"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                Mitarbeiter m = new Mitarbeiter(rs.getString("name"), rs.getInt("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                                rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"), rs.getString("userName"),
                                                rs.getString("passwort"));
                mitarbeitern.add(m);
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        finally {
            if(conn != null){
                try{
                    conn.close();                    
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());                      
                }
            }
        }
          
    }    

    public static void allChefInArray(ArrayList<Chef> chefs){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM chef"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                Chef c2 = new Chef(rs.getString("name"), rs.getInt("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                   rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"), rs.getString("userName"),
                                   rs.getString("passwort"));
                chefs.add(c2);
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        finally {
            if(conn != null){
                try{
                    conn.close();                    
                }catch(SQLException ex){
                    System.out.println(ex.getMessage());                      
                }
            }
        }
          
    }    

    public static String selectTourKunden(String n){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT kunden FROM tour WHERE tourName = ?";  
        
          
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);
  
            ResultSet rs    = pstmt.executeQuery();
            return rs.getString("kunden");
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        finally {
            if(conn != null){
                try{
                    conn.close();                    
                }catch(SQLException e){
                    System.out.println(e.getMessage());                      
                }
            }
        }
        return null;
          
    }    
    
    
}
