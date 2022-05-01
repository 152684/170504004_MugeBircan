/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

/**
 *
 * @author mbirc
 */
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.sql.Date;

public class InsertRecords {
    
    public void insertArbeiter(String n, int ID, String anschr, String email, int telefon, Date geburt, int persID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        //java.util.Date utilDate = new java.util.Date();
        //java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        //java.sql.Timestamp sqlTS = new java.sql.Timestamp(geburt.getTime());
        
        String sql = "INSERT INTO arbeiter(name, burgerID, anschrift, email, telefonnumer, geburtsdatum, personalID) VALUES(?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setInt(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, geburt);
            pstmt.setInt(7, persID);
            pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        

    }
    
    public void insertChef(){
        
    }
    
    public void insertKunde(){
        
    }
    
    public void insertReiseLeiter(){
        
    }
}
