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
    
    public static void deleteMitarbeiter(long ID) throws UngueltigeIDException{
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
                    pstmt.setLong(1, ID);  
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

    public static void deleteChef(long ID) throws UngueltigeIDException{
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
                    pstmt.setLong(1, ID);  
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

    public static void deleteKunde(long ID) throws UngueltigeIDException{
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
                    pstmt.setLong(1, ID);  
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
    
    public static void deleteReiseL(long ID) throws UngueltigeIDException{
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
                    pstmt.setLong(1, ID);  
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
                ArrayList<String> kundenDesTours = SelectRecords.selectTourKunden(n);
                Iterator<String> iterK = kundenDesTours.iterator();

                while(iterK.hasNext()){
                    long id = Long.parseLong(iterK.next());
                    ArrayList<String> reisen = SelectRecords.toursEinesKunden(id);
                    Iterator<String> iterR = reisen.iterator();
                    int stelleR = -1;

                    while(iterR.hasNext()){
                        stelleR ++;
                        if(iterR.next().equals(n)){                    
                            break;
                        }
                    }
                    System.out.println("stelle: " + stelleR);
                    if(reisen.size() == 1){
                        reisen.removeAll(reisen);
                    }else{            
                        reisen.remove(stelleR);
                    }
                    UpdateRecords.deleteKundeVonTour(n, kundenDesTours, id, reisen);            
                }        

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
    
    public static int deleteKundeVonTour(String tour, long kundenId){
        //returns 0 when kunde nicht zur Tour angemeldet ist
        //returns 1 when kunde erfolgreich abgemeldet wird
        //return 2 id unguiltig
        
        if(!(kundenId>10000000000L && kundenId<99999999999L )){
            return 2; 
        }
        ArrayList<String> kunden = SelectRecords.selectTourKunden(tour);
        Iterator<String> iter = kunden.iterator();
        ArrayList<String> reisen = SelectRecords.toursEinesKunden(kundenId);
        Iterator<String> iterR = reisen.iterator();
        
        boolean kundeEx = false;
        int stelle = -1;
        int stelleR = -1;
        if(kunden == null || kunden.isEmpty()){
            System.out.println("Es gibt keine Kunden bei diesem Tour");
            return 0;
        }else{
            while(iter.hasNext()){
                long l = Long.parseLong(iter.next());
                stelle ++;
                if(l == kundenId){                    
                    kundeEx = true;
                    break;
                }
            }
            while(iterR.hasNext()){
                stelleR ++;
                if(iterR.next().equals(tour)){                    
                    break;
                }
            }
                        
            if(kundeEx){
                if(kunden.size() == 1){
                    if(reisen.size() == 1){
                        reisen.removeAll(reisen);
                    }else{
                        reisen.remove(stelleR);
                    }
                    kunden.removeAll(kunden);
                    UpdateRecords.deleteKundeVonTour(tour, kunden, kundenId, reisen);
                    System.out.println("Der letzte Kunde (kundenID: " + kundenId + ") ist von dem Tour abgemeldet.");
                }else{
                    if(reisen.size() == 1){
                        reisen.removeAll(reisen);
                    }else{
                        reisen.remove(stelleR);
                    }
                    kunden.remove(stelle);
                    UpdateRecords.deleteKundeVonTour(tour, kunden, kundenId, reisen);
                    System.out.println("Der Kunde (kundenID: " + kundenId + ") wird von dem Tour abgemeldet.");
                }
                return 1;
            }else{
                System.out.println("Der Kunde (kundenID: " + kundenId + ") ist nicht bei diesem Tour angemeldet");
                return 0;
            }
        }
    }    

    public static int deleteReiseLVonTour(String tour, long reiseLId){
        //returns 0 when reiseLeiter nicht zur Tour angemeldet ist
        //returns 1 when reiseLeiter erfolgreich abgemeldet wird
        //returns 2 fehler
        //return 3 id unguiltig
        //return 4 der letzte reiseL
        
        if(!(reiseLId>10000000000L && reiseLId<99999999999L )){
            return 3; 
        }
        ArrayList<String> reiseL = SelectRecords.selectTourReiseL(tour);
        Iterator<String> iter = reiseL.iterator();
        
        boolean reiseLEx = false;
        int stelle = 0;
        if(reiseL == null || reiseL.isEmpty()){
            System.out.println("Es gibt keinen ReiseLeiter bei diesem Tour");
        }else{
            while(iter.hasNext()){
                long l = Long.parseLong(iter.next());
                if(l == reiseLId){
                    stelle ++;
                    reiseLEx = true;
                    break;
                }
            }
                        
            if(reiseLEx){
                if(reiseL.size() == 1){
                    System.out.println("Der letzte ReiseLeiter (reiseLId: " + reiseLId + ") ist von dem Tour abgemeldet.");
                    return 4;
                }else{
                    reiseL.remove(stelle);
                    UpdateRecords.deleteReiseLVonTour(tour, reiseL, reiseLId);
                    System.out.println("Der ReiseLeiter (reiseLId: " + reiseLId + ") wird von dem Tour abgemeldet.");
                }
                return 1;
            }else{
                System.out.println("Der ReiseLeiter (reiseLId: " + reiseLId + ") ist nicht bei diesem Tour angemeldet");
                return 0;
            }
        }
        return 2;
    }    


}
