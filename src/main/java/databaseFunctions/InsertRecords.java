/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

/**
 *
 * @author mbirc
 */
import com.mycompany.inf202.*;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertRecords {
    
    public void insertArbeiter(String n, int ID, String anschr, String email, int telefon, Date geburt){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        //"muge", 17050402, "maltepe", "email", 55537203, d
        //String n, int ID, String anschr, String e, int telefon, Date geburt
        
        String sql = "INSERT INTO arbeiter(name, burgerID, anschrift, email, telefonnumer, geburtsdatum) VALUES(?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setInt(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            //pstmt.setDouble(6, java.sql.Date.valueOf(geburt));  
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
