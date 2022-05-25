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
  
    public static void updateTourInfo(String n, Date d, int maxT, String info, String hN, float p, String rL){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        java.sql.Date sqlDate = new java.sql.Date(d.getTime());
        
        String sql = "UPDATE tour SET tourDatum = ?, tourInfo = ?, maxTeilnehmer = ?, hotelName = ?, preis = ?, reiseL = ? WHERE tourName = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setDate(1, sqlDate);  
            pstmt.setString(2, info);  
            pstmt.setInt(3, maxT);  
            pstmt.setString(4, hN);
            pstmt.setFloat(5, p);
            pstmt.setString(6, rL);
            pstmt.setString(7, n);
            pstmt.executeUpdate(); 
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
                    //updateTour info mit freiePlätze
                    //preis beachten
                    UpdateRecords.updateTourInfo(currentTour.getTourName(), currentTour.getTourDatum(), currentTour.getMaxTeilnehmer(), currentTour.getTourInfo(), currentTour.getHotelName(), currentTour.getPreis(), currentTour.getR());
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


}
