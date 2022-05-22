/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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

    public static void updateTourKunden(String n, String kunde){
        Connect c = new Connect();
        Connection conn = c.connect();

        Gson gson = new Gson();
        ArrayList<String> vonDatabaseArray = SelectRecords.selectTourKunden(n);
        
        boolean kundeEx = false;
                
        if(vonDatabaseArray != null){
            Iterator<String> iter = vonDatabaseArray.iterator();           
            while(iter.hasNext()){
                if(iter.next().equals(kunde)){
                    System.out.println("Dieser Kunde ist schon bei dieser Tour angemeldet.");
                    kundeEx = true;
                    break;
                }            
            }
        }else{
            vonDatabaseArray = new ArrayList();
        }    

        if(!kundeEx){
            vonDatabaseArray.add(kunde);
            //ArrayList in einem String
            String neueKunden = gson.toJson(vonDatabaseArray);                            
            String sql = "UPDATE tour SET kunden = ? WHERE tourName = ?";
              
            try{
                PreparedStatement pstmt = conn.prepareStatement(sql);
                 
                pstmt.setString(1, neueKunden);
                pstmt.setString(2, n);
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
        }                            
    }
       
    public static void deleteKundeVonTour(String n, ArrayList<String> kunde){
        Connect c = new Connect();
        Connection conn = c.connect();

        Gson gson = new Gson();

        String sql = "UPDATE tour SET kunden = ? WHERE tourName = ?";
              
        String neueKunden = gson.toJson(kunde);
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
                 
            pstmt.setString(1, neueKunden);
            pstmt.setString(2, n);
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
    }


}
