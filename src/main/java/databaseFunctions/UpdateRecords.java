/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.inf202.Tour;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author mbirc
 */
public class UpdateRecords {
    public static void updateMitarbeiter(String n, String anschr, String e, int tel, long ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE mitarbeiter SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setLong(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Mitarbeiter kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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

    public static void updateMitarbeiterErfolg(long id, int anAb){
        System.out.println("in update");
        //anAb = 1 -- an
        //anAb = 2 -- ab
        Connect c = new Connect();
        Connection conn = c.connect();
        
        int anzahlAn = SelectRecords.mitarbErfolg(id);
        int anzahlAb = SelectRecords.mitarbMiserfolg(id);
        float rateAn = (float) (anzahlAn+1)/anzahlAb;
        float rateAb = (float) anzahlAn/(anzahlAb+1);
        
        if(anAb == 1){
            String sql = "UPDATE mitarbeiter SET registrierteKunden = ?, erfolgsRate = ? WHERE burgerID = ?";
            
            try{
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                pstmt.setInt(1, anzahlAn+1);  
                pstmt.setFloat(2, rateAn);  
                pstmt.setLong(3, id);  
                pstmt.executeUpdate(); 
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
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
        }else{
                        
            String sql = "UPDATE mitarbeiter SET abgemeldeteKunden = ?, erfolgsRate = ? WHERE burgerID = ?";
            
            try{
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                pstmt.setInt(1, anzahlAb+1); 
                pstmt.setFloat(2, rateAb);
                pstmt.setLong(3, id);  
                pstmt.executeUpdate(); 
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
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

    public static void updateChef(String n, String anschr, String e, int tel, long ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE chef SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setLong(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Chef kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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

    public static void updateMitarbeiterUserNameUndPass(String user, String pass, long ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE mitarbeiter SET userName = ?, passwort = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, user);  
            pstmt.setString(2, pass);  
            pstmt.setLong(3, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Die login Daten des Mitarbeiters kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
        
    }
    
    public static void updateChefUserNameUndPass(String user, String pass, long ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE chef SET userName = ?, passwort = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, user);  
            pstmt.setString(2, pass);  
            pstmt.setLong(3, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Die login Daten des Chefs kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
        
    }

    public static void updateKunde(String n, String anschr, String e, int tel, long ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE kunde SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setLong(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Kunde kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
    
    public static void updateReiseL(String n, String anschr, String e, int tel, long ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE reiseLeiter SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setLong(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Reiseleiter kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
    
    public static void updateHotel(String n, String anschr, String e, int tel, float p){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE hotel SET preis = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE name = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setFloat(1, p);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setString(5, n);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Das Hotel kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
  
    public static int updateTourInfo(String n, Date d, int maxT, String info, String hN, float p){
        //return 0 maxTeilnehmer reduziert
        //return 1 erfolg
        //return 2 fehler
        
        Tour t = SelectRecords.findTour(n);
        if(t.getMaxTeilnehmer() <= maxT){
            int neueFreieP = maxT-t.getMaxTeilnehmer()+t.getFreiePlaetze();
            Connect c = new Connect();
            Connection conn = c.connect();

            java.sql.Date sqlDate = new java.sql.Date(d.getTime());

            String sql = "UPDATE tour SET tourDatum = ?, tourInfo = ?, maxTeilnehmer = ?, hotelName = ?, preis = ?, freiePlaetze = ? WHERE tourName = ?";

            try{    
                PreparedStatement pstmt = conn.prepareStatement(sql);  

                pstmt.setDate(1, sqlDate);  
                pstmt.setString(2, info);  
                pstmt.setInt(3, maxT);  
                pstmt.setString(4, hN);
                pstmt.setFloat(5, p);
                pstmt.setInt(6, neueFreieP);
                pstmt.setString(7, n);
                pstmt.executeUpdate(); 
                return 1;
            } catch (SQLException ex) {  
                System.out.println("Die Tour kann nicht aktualisiert werden!");
                System.out.println(ex.getMessage());  
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
            
        }else{
            System.out.println("Die maximale Teilnehmerzahl kann nicht reduziert werden.");
            return 0;
        }
        return 3;
        
    }
    
    public static void tourFreiPlAkt(String tour, int anAb){
        //anAb 1 -- kunde anmelden
        //anAb 2 -- kunde abmelden
        Connect c = new Connect();
        Connection conn = c.connect();
        Tour t = SelectRecords.findTour(tour);
        
        if(anAb == 1){
            int neueFreieP = t.getFreiePlaetze()-1;

            String sql = "UPDATE tour SET freiePlaetze = ? WHERE tourName = ?";

            try{            
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, neueFreieP);
                pstmt.setString(2, tour);                
                pstmt.executeUpdate();

            } catch (SQLException ex) {  
                System.out.println("Die Kunden der Tour können nicht aktualisiert werden!");
                System.out.println(ex.getMessage());  
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
            
        }else if(anAb == 2){
            int neueFreieP = t.getFreiePlaetze()+1;

            String sql = "UPDATE tour SET freiePlaetze = ? WHERE tourName = ?";

            try{            
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, neueFreieP);
                pstmt.setString(2, tour);                
                pstmt.executeUpdate();

            } catch (SQLException ex) {  
                System.out.println("Die Kunden der Tour können nicht aktualisiert werden!");
                System.out.println(ex.getMessage());  
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
            
        }else{
            System.out.println("Fehler beim freiePlaetze anlegen");
        }
    }

    public static int kundeZurTourAnmelden(String tour, long kundeId){
        //returns 0 when kunde schon zur Tour angemeldet ist
        //returns 1 when kunde erfolgreich angemeldet wird
        //returns 2 fehler
        //returns 3 falls keine freiePlaetze vorhanden
        
        Tour currentTour = SelectRecords.findTour(tour);
        if(currentTour.getFreiePlaetze()!= 0){
            Connect c = new Connect();
            Connection conn = c.connect();

            Gson gson = new Gson();
            ArrayList<String> vonDatabaseArray = SelectRecords.selectTourKunden(tour);

            boolean kundeEx = false;

            if(vonDatabaseArray != null){
                Iterator<String> iter = vonDatabaseArray.iterator();
                while(iter.hasNext()){
                    Long l = Long.parseLong(iter.next());
                    if(l == kundeId){
                        System.out.println("Dieser Kunde ist schon bei dieser Tour angemeldet.");
                        kundeEx = true;
                        return 0;
                    }            
                }
            }else{
                vonDatabaseArray = new ArrayList();
            }    

            if(!kundeEx){
                String s = String.valueOf(kundeId);
                vonDatabaseArray.add(s);
                //ArrayList in einem String
                String neueKunden = gson.toJson(vonDatabaseArray);                            
                String sql = "UPDATE tour SET kunden = ? WHERE tourName = ?";

                ArrayList<String> toursKunde = SelectRecords.toursEinesKunden(kundeId);
                if(toursKunde == null){
                    toursKunde = new ArrayList();
                    toursKunde.add(tour);
                }else{
                    toursKunde.add(tour);                
                }
                String neueReisen = gson.toJson(toursKunde);

                String sql2 = "UPDATE kunde SET reisen = ? WHERE burgerID = ?";

                try{
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    PreparedStatement pstmt2 = conn.prepareStatement(sql2);

                    pstmt.setString(1, neueKunden);
                    pstmt.setString(2, tour);
                    pstmt.executeUpdate();

                    pstmt2.setString(1, neueReisen);
                    pstmt2.setLong(2, kundeId);
                    pstmt2.executeUpdate();
                    
                    currentTour.setFreiePlaetze(currentTour.getFreiePlaetze()-1); 
                    UpdateRecords.tourFreiPlAkt(tour, 1);
                    return 1;
                } catch (SQLException ex) {  
                    System.out.println("Die Kunden der Tour können nicht aktualisiert werden!");
                    System.out.println(ex.getMessage());  
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
            }
            return 2;
            
        }else{
            return 3;
        }

    }
       
    public static void deleteKundeVonTour(String tour, ArrayList<String> kunde, long kundenId, ArrayList<String> reisen){
        Connect c = new Connect();
        Connection conn = c.connect();

        Gson gson = new Gson();

        String sql = "UPDATE tour SET kunden = ? WHERE tourName = ?";
        String sql2 = "UPDATE kunde SET reisen = ? WHERE burgerID = ?";
              
        String neueKunden = gson.toJson(kunde);
        String neueReisen = gson.toJson(reisen);
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                 
            pstmt.setString(1, neueKunden);
            pstmt.setString(2, tour);
            pstmt.executeUpdate();

            pstmt2.setString(1, neueReisen);
            pstmt2.setLong(2, kundenId);
            pstmt2.executeUpdate();
            UpdateRecords.tourFreiPlAkt(tour, 2);
        } catch (SQLException ex) {  
            System.out.println("Die Kunden der Tour können nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
    }

    public static int reiseLZurTourAnmelden(String tour, long reiseLId){
        //returns 0 when reiseL schon zur Tour angemeldet ist
        //returns 1 when reiseL erfolgreich angemeldet wird
        //returns 2 fehler
    
        Tour currentTour = SelectRecords.findTour(tour);
        
        Connect c = new Connect();
        Connection conn = c.connect();

        Gson gson = new Gson();
        ArrayList<String> vonDatabaseArray = SelectRecords.selectTourReiseL(tour);

        boolean reiseLEx = false;

        if(vonDatabaseArray != null){
            Iterator<String> iter = vonDatabaseArray.iterator();
            while(iter.hasNext()){
                Long l = Long.parseLong(iter.next());
                if(l == reiseLId){
                    System.out.println("Dieser ReiseLeiter ist schon bei dieser Tour angemeldet.");
                    reiseLEx = true;
                    return 0;
                }            
            }
        }else{
            vonDatabaseArray = new ArrayList();
        }    

        if(!reiseLEx){
            String s = String.valueOf(reiseLId);
            vonDatabaseArray.add(s);
            //ArrayList in einem String
            String neueReiseL = gson.toJson(vonDatabaseArray);                            
            String sql = "UPDATE tour SET reiseL = ? WHERE tourName = ?";
            
            try{
                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1, neueReiseL);
                pstmt.setString(2, tour);
                pstmt.executeUpdate();

                return 1;
            } catch (SQLException ex) {  
                System.out.println("Die ReiseLeitern der Tour können nicht aktualisiert werden!");
                System.out.println(ex.getMessage());  
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
        }
        return 2;
            


    }
       
    public static void deleteReiseLVonTour(String tour, ArrayList<String> reiseL, long reiseLId){
        Connect c = new Connect();
        Connection conn = c.connect();

        Gson gson = new Gson();

        String sql = "UPDATE tour SET reiseL = ? WHERE tourName = ?";
              
        String neueReiseL = gson.toJson(reiseL);

        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
                 
            pstmt.setString(1, neueReiseL);
            pstmt.setString(2, tour);
            pstmt.executeUpdate();

        } catch (SQLException ex) {  
            System.out.println("Die ReiseL der Tour können nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
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
    }

    
    
}
