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
        
        String sql = "INSERT INTO arbeiter(name, burgerID, anschrift, email, telefonnummer, geburtsdatum, personalID) VALUES(?,?,?,?,?,?,?)";
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
            System.out.println("Der Arbeiter kann nicht hinzugefuegt werden!");
            System.out.println(e.getMessage());  
        }        

    }
    
    public void insertChef(String n, int ID, String anschr, String email, int telefon, Date geburt, int persID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "INSERT INTO chef(name, burgerID, anschrift, email, telefonnummer, geburtsdatum, personalID) VALUES(?,?,?,?,?,?,?)";
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
    
    public void insertKunde(String n, int ID, String anschr, String email, int telefon, Date geburt){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "INSERT INTO kunde(name, burgerID, anschrift, email, telefonnummer, geburtsdatum) VALUES(?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setInt(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, geburt);
            pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }        
        
    }
    
    public void insertReiseLeiter(String n, int ID, String anschr, String email, int telefon, Date geburt){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "INSERT INTO reiseLeiter(name, burgerID, anschrift, email, telefonnummer, geburtsdatum) VALUES(?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setInt(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, geburt);
            pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }        
        
    }
    
    public void insertHotel(String n, String anschr, int telefon, String email, float preis){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "INSERT INTO hotel(name, anschrift, telefonnummer, email, preis) VALUES(?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setInt(3, telefon);  
            pstmt.setString(4, email);  
            pstmt.setFloat(5, preis);  
            pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }        
        
    }

    public void insertTour(String n, Date d, String info, int maxT, String hN, float p, int freiP, String rL){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "INSERT INTO tour(tourName, tourDatum, tourInfo, maxTeilnehmer, hotelName, preis, freiePlaetze, reiseL, kunden) VALUES(?,?,?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setDate(2, d);  
            pstmt.setString(3, info);  
            pstmt.setInt(4, maxT);  
            pstmt.setString(5, hN);
            pstmt.setFloat(6, p);
            pstmt.setFloat(7, freiP);
            pstmt.setString(8, rL);
            pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }        
        
    }
    
}
