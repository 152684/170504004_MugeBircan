/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author mbirc
 */
public class InsertRecords {
    
    public static void insertMitarbeiter(String n, long ID, String anschr, String email, int telefon, Date geburt, int persID, String user, String pass){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        
        String sql = "INSERT INTO mitarbeiter(name, burgerID, anschrift, email, telefonnummer, geburtsdatum, personalID, userName, passwort) VALUES(?,?,?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, n);  
            pstmt.setLong(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, sqlDate);
            pstmt.setInt(7, persID);
            pstmt.setString(8, user);  
            pstmt.setString(9, pass);  
            pstmt.executeUpdate(); 
        } catch (SQLException e) {  
            System.out.println("Der Arbeiter kann nicht hinzugefuegt werden!");
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
    
    public static void insertChef(String n, long ID, String anschr, String email, int telefon, Date geburt, int persID, String user, String pass){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        
        String sql = "INSERT INTO chef(name, burgerID, anschrift, email, telefonnummer, geburtsdatum, personalID, userName, passwort) VALUES(?,?,?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setLong(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, sqlDate);
            pstmt.setInt(7, persID);
            pstmt.setString(8, user);  
            pstmt.setString(9, pass);  
            pstmt.executeUpdate(); 
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
   
    public static void insertKunde(String n, long ID, String anschr, String email, int telefon, Date geburt){
        Connect c = new Connect();
        Connection conn = c.connect();
 
      
        java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());        
        
        String sql = "INSERT INTO kunde(name, burgerID, anschrift, email, telefonnummer, geburtsdatum) VALUES(?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setLong(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, sqlDate);
            pstmt.executeUpdate(); 
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
    
    public static void insertReiseLeiter(String n, long ID, String anschr, String email, int telefon, Date geburt){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        
        String sql = "INSERT INTO reiseLeiter(name, burgerID, anschrift, email, telefonnummer, geburtsdatum) VALUES(?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setLong(2, ID);  
            pstmt.setString(3, anschr);  
            pstmt.setString(4, email);  
            pstmt.setInt(5, telefon);  
            pstmt.setDate(6, sqlDate);
            pstmt.executeUpdate(); 
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
    
    public static void insertHotel(String n, String anschr, int telefon, String email, float preis){
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

    public static void insertTour(String n, Date d, String info, int maxT, String hN, float p, int freiP){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        
        String sql = "INSERT INTO tour(tourName, tourDatum, tourInfo, maxTeilnehmer, hotelName, preis, freiePlaetze, reiseL, kunden) VALUES(?,?,?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, n);  
            pstmt.setDate(2, sqlDate);  
            pstmt.setString(3, info);  
            pstmt.setInt(4, maxT);  
            pstmt.setString(5, hN);
            pstmt.setFloat(6, p);
            pstmt.setFloat(7, freiP);
            pstmt.executeUpdate(); 
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

}
