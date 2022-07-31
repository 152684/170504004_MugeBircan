/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.mycompany.inf202.*;
import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author mbirc
 * 
 * Klasse, um Daten in die Database zu speichern
 */
public class InsertRecords {
    
    
    /**
     * insert Mitarbeiter ins Database
     * @param m -- Mitarbetier
     * @return true falls richtig, false andernfalls
     */
    public static boolean insertMitarbeiterNeu(Mitarbeiter m){
        Connect c = new Connect();
        Connection conn = c.connect();
 
        boolean returnVal = false;
        //java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        
        String sql = "INSERT INTO mitarbeiter(name, burgerID, anschrift, email, telefonnummer, geburtsdatum, personalID, userName, passwort, neuRegister) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, m.getName());  
            pstmt.setLong(2, m.getBurgerID());  
            pstmt.setString(3, m.getAnschrift());  
            pstmt.setString(4, m.getEmail());  
            pstmt.setInt(5, m.getTelefonnummer());  
            pstmt.setDate(6, m.getGeburtsdatum());
            pstmt.setInt(7, m.getPersonalID());
            pstmt.setString(8, m.getUserName());  
            pstmt.setString(9, m.getPasswort());  
            pstmt.setBoolean(10, m.getNeuRegister());
            pstmt.executeUpdate();
            returnVal = true;
        } catch (SQLException e) {  
            System.out.println("Der Arbeiter kann nicht hinzugefuegt werden!");
            System.out.println(e.getMessage());  
            System.out.println(e.getCause());
            System.out.println(e.toString());
            System.out.println(e.getErrorCode());            
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
        return returnVal;
    }
    
    /**
     * insert Chef ins Database
     * @param chef -- Chef
     * @return true falls erfolgreich, false andernfalls
     */
    public static boolean insertChefNeu(Chef chef){
        Connect c = new Connect();
        Connection conn = c.connect();
 
        boolean returnVal = false;
        //java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        
        String sql = "INSERT INTO chef(name, burgerID, anschrift, email, telefonnummer, geburtsdatum, personalID, userName, passwort, neuRegister) VALUES(?,?,?,?,?,?,?,?,?,?)";
        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, chef.getName());  
            pstmt.setLong(2, chef.getBurgerID());  
            pstmt.setString(3, chef.getAnschrift());  
            pstmt.setString(4, chef.getEmail());  
            pstmt.setInt(5, chef.getTelefonnummer());  
            pstmt.setDate(6, chef.getGeburtsdatum());
            pstmt.setInt(7, chef.getPersonalID());
            pstmt.setString(8, chef.getUserName());  
            pstmt.setString(9, chef.getPasswort());  
            pstmt.setBoolean(10, chef.getNeuRegister());
            pstmt.executeUpdate();
            returnVal = true;
        } catch (SQLException e) {  
            System.out.println("Der Arbeiter kann nicht hinzugefuegt werden!");
            System.out.println(e.getMessage());  
            System.out.println(e.getCause());
            System.out.println(e.toString());
            System.out.println(e.getErrorCode());            
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
        return returnVal;
    }
       
    /**
     * 
     * neue Kunde in die Database speichern
     * @param n -- Name
     * @param ID -- BurgerID
     * @param anschr -- Anschrift
     * @param email -- Email
     * @param telefon -- Telefonnummer
     * @param geburt -- Geburtsdatum
     */
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
    
    /**
     * 
     * neuer ReiseLeiter in die Database speichern
     * @param n -- Name
     * @param ID -- BurgerID
     * @param anschr -- Anschrift
     * @param email -- Email
     * @param telefon -- Telefonnummer
     * @param geburt -- Geburtsdatum
     */
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
    
    /**
     * neues Hotel in die Database speichern
     * @param n -- Name
     * @param anschr -- Anschrift
     * @param telefon -- Telefonnummer
     * @param email -- Email
     * @param preis -- Preis
     */
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

    /**
     * 
     * neue Tour in die Database speichern
     * @param n -- Name
     * @param d -- Datum
     * @param info -- Informationen
     * @param maxT -- masximale TeilneherZahl
     * @param hN -- Hotel Name
     * @param p -- Preis
     * @param freiP -- freie Plaetze
     */
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
