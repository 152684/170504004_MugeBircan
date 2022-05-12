/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.mycompany.inf202.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mbirc
 */
public class DeleteRecords {

    private static ArrayList<Chef> chefs = new ArrayList();
    private static ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();
    private static ArrayList<Kunde> kunden = new ArrayList();
    private static ArrayList<ReiseLeiter> reiseLs = new ArrayList();
    private static ArrayList<String> hotels = new ArrayList();
    private static ArrayList<String> tours = new ArrayList();
    
    public static void deleteMitarbeiter(int ID){
        SelectRecords.allMitarbeiterInArray(mitarbeitern);
        Iterator<Mitarbeiter> iterM = mitarbeitern.iterator();
        
        boolean mitEx = false;
        while(iterM.hasNext()){
            if(iterM.next().getBurgerID() == ID){
                mitEx = true;
                Connect c = new Connect();
                Connection conn = c.connect();

                String sql = "DELETE FROM mitarbeiter WHERE burgerID = ?";
                try{    
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, ID);  
                    System.out.println("Der Mitarbeiter mit der Buerger ID: " + ID + " wird nun geloescht.");
                    pstmt.executeUpdate(); 
                } catch (SQLException e) {  
                    System.out.println("Der Mitarbeiter kann nicht geloescht werden!");
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
        if(!mitEx){
            System.out.println("Es gibt keinen Mitearbeiter mit der BurgerID: " + ID);            
        }
    }

    public static void deleteChef(int ID){
        SelectRecords.allChefInArray(chefs);
        Iterator<Chef> iter = chefs.iterator();
        
        boolean exist = false;
        while(iter.hasNext()){
            if(iter.next().getBurgerID() == ID){
                exist = true;
                Connect c = new Connect();
                Connection conn = c.connect();

                String sql = "DELETE FROM chef WHERE burgerID = ?";
                try{    
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, ID);  
                    System.out.println("Der Chef mit der Buerger ID: " + ID + " wird nun geloescht.");
                    pstmt.executeUpdate(); 
                } catch (SQLException e) {  
                    System.out.println("Der Chef kann nicht geloescht werden!");
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
        if(!exist){
            System.out.println("Es gibt keinen Chef mit der BurgerID: " + ID);            
        }
    }

    public static void deleteKunde(int ID){
        SelectRecords.allKundenInArray(kunden);
        Iterator<Kunde> iter = kunden.iterator();
        
        boolean exist = false;
        while(iter.hasNext()){
            if(iter.next().getBurgerID() == ID){
                exist = true;
                Connect c = new Connect();
                Connection conn = c.connect();

                String sql = "DELETE FROM kunde WHERE burgerID = ?";
                try{    
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, ID);  
                    System.out.println("Der Kunde mit der Buerger ID: " + ID + " wird nun geloescht.");
                    pstmt.executeUpdate(); 
                } catch (SQLException e) {  
                    System.out.println("Der Kunde kann nicht geloescht werden!");
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
        if(!exist){
            System.out.println("Es gibt keine Kunde mit der BurgerID: " + ID);            
        }
    }
    
    public static void deleteReiseL(int ID){
        SelectRecords.allReiseLInArray(reiseLs);
        Iterator<ReiseLeiter> iter = reiseLs.iterator();
        
        boolean exist = false;
        while(iter.hasNext()){
            if(iter.next().getBurgerID() == ID){
                exist = true;
                Connect c = new Connect();
                Connection conn = c.connect();

                String sql = "DELETE FROM reiseLeiter WHERE burgerID = ?";
                try{    
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, ID);  
                    System.out.println("Der ReiseL mit der Buerger ID: " + ID + " wird nun geloescht.");
                    pstmt.executeUpdate(); 
                } catch (SQLException e) {  
                    System.out.println("Der reiseLeiter kann nicht geloescht werden!");
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
        if(!exist){
            System.out.println("Es gibt keinen reiseLeiter mit der BurgerID: " + ID);            
        }
    }

    public static void deleteHotel(String n){
        SelectRecords.hotelNamenInArray(hotels);
        Iterator<String> iter = hotels.iterator();
        
        boolean exist = false;
        while(iter.hasNext()){
            if(iter.next().equals(n)){
                exist = true;
                Connect c = new Connect();
                Connection conn = c.connect();

                String sql = "DELETE FROM hotel WHERE name = ?";
                try{    
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, n);  
                    System.out.println("Das Hotel mit den Namen: " + n + " wird nun geloescht.");
                    pstmt.executeUpdate(); 
                } catch (SQLException e) {  
                    System.out.println("Das Hotel kann nicht geloescht werden!");
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
        if(!exist){
            System.out.println("Es gibt kein Hotel mit den Namen: " + n);            
        }
    }

    public static void deleteTour(String n){
        SelectRecords.tourNamenInArray(tours);
        Iterator<String> iter = tours.iterator();
        
        boolean exist = false;
        while(iter.hasNext()){
            if(iter.next().equals(n)){
                exist = true;
                Connect c = new Connect();
                Connection conn = c.connect();

                String sql = "DELETE FROM tour WHERE tourName = ?";
                try{    
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, n);  
                    System.out.println("Die Tour mit den Namen: " + n + " wird nun geloescht.");
                    pstmt.executeUpdate(); 
                } catch (SQLException e) {  
                    System.out.println("Die Tour kann nicht geloescht werden!");
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
        if(!exist){
            System.out.println("Es gibt keine Tour mit den Namen: " + n);            
        }
    }
    
}
