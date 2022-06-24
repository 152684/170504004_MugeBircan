/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.inf202.*;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mbirc
 * 
 * Klasse, um Daten von der Database zu lesen
 */
public class SelectRecords {
    
    /**
     * Alle Mitarbietern aus der Database in ein ArrayList speichern
     * @param mitarbeitern -- Mitarbeiter ArrayList
     * @throws UngueltigeIDException falls die BurgerID nicht gueltig ist
     */
    public static void allMitarbeiterInArray(ArrayList<Mitarbeiter> mitarbeitern) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM mitarbeiter"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                Mitarbeiter m = new Mitarbeiter(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                                rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"), rs.getString("userName"),
                                                rs.getString("passwort"), rs.getFloat("erfolgsRate"));
                mitarbeitern.add(m);
            }  
        }catch(UngueltigeIDException e) {
            throw e;
        }catch (SQLException e) {  
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
     * BurgerIDs aller Mitarbietern aus der Database in ein ArrayList speichern
     * @param mitarbeitern -- Mitarbeiter BurgerIDs ArrayList
     * @return mitarbZahl -- Zahl der Mitarbeitern
     */
    public static int mitarbIDsInArray(ArrayList<Long> mitarbeitern){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM mitarbeiter ORDER BY burgerID ASC"; 
        
        int mitarbZahl = 0;
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                Long c2 = rs.getLong("burgerID");
                mitarbeitern.add(c2);
                mitarbZahl++;
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
        return mitarbZahl;
          
    }    

    /**
     * Mitarbeiter mit der gegebenen BurgerID finden
     * @param id -- BurgerID des Mitarbeiters
     * @return Mitarbeiter
     * @throws UngueltigeIDException falls BurgerID ungueltig ist
     */
    public static Mitarbeiter findMitarbeiter(long id) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM mitarbeiter WHERE burgerID = ?"; 
        
        Mitarbeiter m = null;
        
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, id);
  
            ResultSet rs    = pstmt.executeQuery();
            m = new Mitarbeiter(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                                rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"), rs.getString("userName"),
                                                rs.getString("passwort"));
            
        } catch(UngueltigeIDException e){
            System.out.println("in exceptioin");
            throw e;            
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
      
        return m;
    }
    
    /**
     * Chef mit der gegebenen BurgerID finden
     * @param id -- BurgerID des Chefs
     * @return Chef
     * @throws UngueltigeIDException falls BurgerID ungueltig ist
     */
    public static Chef findChef(long id) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "SELECT * FROM chef WHERE burgerID = ?"; 
        
        Chef chef = null;
        
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, id);
 
            ResultSet rs    = pstmt.executeQuery();
            chef = new Chef(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                   rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"), rs.getString("userName"),
                                   rs.getString("passwort"));
            
        }catch(UngueltigeIDException e) {
            throw e;
        }catch (SQLException e) {  
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
      
        return chef;
    }

    /**
     * Alle Chefs aus der Database in ein ArrayList speichern
     * @param chefs -- Chef ArrayList
     * @throws UngueltigeIDException falls die BurgerID nicht gueltig ist
     */
    public static void allChefInArray(ArrayList<Chef> chefs) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM chef"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                Chef c2 = new Chef(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                   rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getInt("personalID"), rs.getString("userName"),
                                   rs.getString("passwort"));
                chefs.add(c2);
            }  
        } catch(UngueltigeIDException e){
            throw e;
        }catch (SQLException e) {  
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
     * Alle Kunden aus der Database in ein ArrayList speichern
     * @param kunden -- Kunde ArrayList
     * @throws UngueltigeIDException falls die BurgerID nicht gueltig ist
     */
    public static void allKundenInArray(ArrayList<Kunde> kunden) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM kunde"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                Kunde k2 = new Kunde(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                   rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getString("reisen"));
                kunden.add(k2);
            }  
        } catch(UngueltigeIDException e){
            throw e;
        }catch (SQLException e) {  
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
     * Kunde mit der gegebenen BurgerID finden
     * @param id -- BurgerID
     * @return Kunde
     * @throws UngueltigeIDException falls BurgerID nicht gueltig ist
     */
    public static Kunde findKunde(long id) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "SELECT * FROM kunde WHERE burgerID = ?"; 
        
        Kunde k = null;
        
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, id);
 
            ResultSet rs    = pstmt.executeQuery();
            k = new Kunde(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                               rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"), rs.getString("reisen"));
            
        }catch(UngueltigeIDException e) {
            throw e;
        }catch (SQLException e) {  
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
      
        return k;
    }

    /**
     * Die Touren, die ein Kunde sich angemeldet hat
     * @param kundeId -- BurgerID des Kunden
     * @return toursEinesKunden -- ArrayList
     */
    public static ArrayList<String> toursEinesKunden(long kundeId){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT reisen FROM kunde WHERE burgerID = ?";  
        
        String vonDatabaseString = null;
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, kundeId);
  
            ResultSet rs    = pstmt.executeQuery();
            vonDatabaseString = rs.getString("reisen");
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
        
        Gson gson = new Gson();
        ArrayList<String> vonDatabaseArray = new ArrayList();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        if(vonDatabaseString != null){
            vonDatabaseArray = gson.fromJson(vonDatabaseString, type);    
            return vonDatabaseArray;
        }else{
            return null;
        }
          
    }    

    /**
     * Alle reiseLeitern aus der Database in ein ArrayList speichern
     * @param reiseLeitern -- ReiseLeiter ArrayList
     * @throws UngueltigeIDException falls die BurgerID nicht gueltig ist
     */
    public static void allReiseLInArray(ArrayList<ReiseLeiter> reiseLeitern) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM reiseLeiter"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                ReiseLeiter k2 = new ReiseLeiter(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                   rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"));
                reiseLeitern.add(k2);
            }  
        } catch(UngueltigeIDException e){
            throw e;
        }catch (SQLException e) {  
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
     * ReiseLeiter mit der gegebenen BurgerID finden
     * @param id -- BurgerID des ReiseLeiters
     * @return ReiseLeiter
     * @throws UngueltigeIDException falls BurgerID ungueltig ist 
     */
    public static ReiseLeiter findReiseL(long id) throws UngueltigeIDException{
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "SELECT * FROM reiseLeiter WHERE burgerID = ?"; 
        
        ReiseLeiter k = null;
        
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, id);
 
            ResultSet rs    = pstmt.executeQuery();
            k = new ReiseLeiter(rs.getString("name"), rs.getLong("burgerID"), rs.getString("anschrift"), rs.getString("email"), 
                                rs.getInt("telefonnummer"), rs.getDate("geburtsdatum"));
            
        }catch(UngueltigeIDException e) {
            throw e;
        }catch (SQLException e) {  
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
      
        return k;
    }

    /**
     * Namen aller Hotels aus der Database in ein ArrayList speichern
     * @param hotels -- ArrayList
     * @return hotelZahl -- Anzahl der Hotels
     */
    public static int hotelNamenInArray(ArrayList<String> hotels){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        int hotelZahl = 0;
        
        String sql = "SELECT * FROM hotel ORDER BY name ASC"; 
        
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                String c2 = rs.getString("name");
                hotels.add(c2);
                hotelZahl++;
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
        return hotelZahl;  
    }    

    /**
     * Hotel mit dem gegebenen Namen finden
     * @param name -- Name des Hotels
     * @return Hotel
     */
    public static Hotel findHotel(String name){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "SELECT * FROM hotel WHERE name = ?"; 
        
        Hotel k = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);
 
            ResultSet rs    = pstmt.executeQuery();
            k = new Hotel(rs.getString("name"), rs.getString("anschrift"), rs.getInt("telefonnummer"), rs.getString("email"), rs.getFloat("preis"));            
        }catch (SQLException e) {  
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
      
        return k;
    }

    /**
     * Namen aller Tours aus der DAtabase in ein ArrayList speichern
     * @param tours -- ArrayList
     * @return tourZahl -- Anzahl der Touren
     */
    public static int tourNamenInArray(ArrayList<String> tours){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT * FROM tour ORDER BY tourName ASC"; 
        
        int tourZahl = 0;
          
        try {  
            Statement stmt  = conn.createStatement();  
            ResultSet rs    = stmt.executeQuery(sql);  
              
            // loop through the result set  
            while (rs.next()) { 
                String c2 = rs.getString("tourName");
                tours.add(c2);
                tourZahl++;
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
        return tourZahl;
          
    }    
 
    /**
     * Tour mit dem gegebenen Namen finden
     * @param name -- Tourname
     * @return Tour
     */
    public static Tour findTour(String name){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "SELECT * FROM tour WHERE tourName = ?"; 
        
        Tour k = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);
 
            ResultSet rs    = pstmt.executeQuery();
            k = new Tour(rs.getString("tourName"), rs.getDate("tourDatum"), rs.getString("tourInfo"), rs.getInt("maxTeilnehmer"),
                         rs.getString("hotelName"), rs.getFloat("preis"), rs.getInt("freiePlaetze"), rs.getString("reiseL"), rs.getString("kunden"));            
        }catch (SQLException e) {  
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
      
        return k;
    }

    /**
     * Kunden, die bei einem Tour angemeldet sind, in ein ArrayList speichern
     * @param tour -- Tourname
     * @return tourKunden -- ArrayList
     */
    public static ArrayList<String> selectTourKunden(String tour){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT kunden FROM tour WHERE tourName = ?";  
        
        String vonDatabaseString = null;
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, tour);
  
            ResultSet rs    = pstmt.executeQuery();
            vonDatabaseString = rs.getString("kunden");
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
        
        Gson gson = new Gson();
        ArrayList<String> vonDatabaseArray = new ArrayList();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        if(vonDatabaseString != null){
            vonDatabaseArray = gson.fromJson(vonDatabaseString, type);    
            return vonDatabaseArray;
        }else{
            return null;
        }
          
    }    
     
    /**
     * ReiseLeiter, die bei einem Tour angemeldet sind, in ein ArrayList speichern
     * @param tour -- Tourname
     * @return tourReiseLeiter -- ArrayList
     */
    public static ArrayList<String> selectTourReiseL(String tour){
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT reiseL FROM tour WHERE tourName = ?";  
        
        String vonDatabaseString = null;
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, tour);
  
            ResultSet rs    = pstmt.executeQuery();
            vonDatabaseString = rs.getString("reiseL");
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
        
        Gson gson = new Gson();
        ArrayList<String> vonDatabaseArray = new ArrayList();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        if(vonDatabaseString != null){
            vonDatabaseArray = gson.fromJson(vonDatabaseString, type);    
            return vonDatabaseArray;
        }else{
            return null;
        }
          
    }    

    /**
     * Aktualisieren der Anzahl der registrierten Kunden
     * @param mitId -- Mitarbeiter BurgerID
     * @return Anzahl der registrierten Kunden
     */
    public static int mitarbErfolg(long mitId){ 
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT registrierteKunden FROM mitarbeiter WHERE burgerID = ?";  
        
        int anzahl = 0;
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, mitId);
  
            ResultSet rs    = pstmt.executeQuery();
            anzahl = rs.getInt("registrierteKunden");
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
        return anzahl;
    }    

    /**
     * Aktualisieren der Anzahl der abgemeldeten Kunden
     * @param mitId -- Mitarbeiter BurgerID
     * @return Anzahl der abgemeldeten Kunden
     */
    public static int mitarbMiserfolg(long mitId){ 
        Connect c = new Connect();
        Connection conn = c.connect();
    
        String sql = "SELECT abgemeldeteKunden FROM mitarbeiter WHERE burgerID = ?";  
        
        int anzahl = 0;
        
        try {              
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setLong(1, mitId);
  
            ResultSet rs    = pstmt.executeQuery();
            anzahl = rs.getInt("abgemeldeteKunden");
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
        return anzahl;
    }    
    
}
