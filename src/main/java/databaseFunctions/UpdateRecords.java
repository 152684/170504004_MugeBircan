/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseFunctions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author mbirc
 */
public class UpdateRecords {
    public void updateMitarbeiter(String n, String anschr, String e, int tel, int ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE mitarbeiter SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setInt(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Mitarbeiter kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }                
    }

    public void updateChef(String n, String anschr, String e, int tel, int ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE chef SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setInt(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Chef kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }        
        
    }

    public void updateMitarbeiterUserNameUndPass(String user, String pass, int ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE mitarbeiter SET userName = ?, passwort = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, user);  
            pstmt.setString(2, pass);  
            pstmt.setInt(3, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Die login Daten des Mitarbeiters kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }        
        
    }
    
    public void updateChefUserNameUndPass(String user, String pass, int ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE chef SET userName = ?, passwort = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, user);  
            pstmt.setString(2, pass);  
            pstmt.setInt(3, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Die login Daten des Chefs kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }        
        
    }

    public void updateKunde(String n, String anschr, String e, int tel, int ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE kunde SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setInt(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Kunde kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }        
        
    }
    
    public void updateReiseL(String n, String anschr, String e, int tel, int ID){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE reiseLeiter SET name = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE burgerID = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setString(1, n);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setInt(5, ID);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Der Reiseleiter kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }        
        
    }
    
    public void updateHotel(String n, String anschr, String e, int tel, float p){
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
        
    }

// tour bilgilerine bakip degisikliklere karar verildikten sonra yapilacak    
/*    
    public void updateTourInfo(String n, Date d, String info, String hN, float p, String rL){
        Connect c = new Connect();
        Connection conn = c.connect();
        
        String sql = "UPDATE tour SET preis = ?, anschrift = ?, email = ?, telefonnummer = ? WHERE name = ?";

        try{    
            PreparedStatement pstmt = conn.prepareStatement(sql);  

            pstmt.setFloat(1, preis);  
            pstmt.setString(2, anschr);  
            pstmt.setString(3, e);  
            pstmt.setInt(4, tel);
            pstmt.setString(5, n);
            pstmt.executeUpdate(); 
        } catch (SQLException ex) {  
            System.out.println("Das Hotel kann nicht aktualisiert werden!");
            System.out.println(ex.getMessage());  
        }        
        
    }
*/    
}
