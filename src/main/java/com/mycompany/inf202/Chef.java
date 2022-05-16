/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.UpdateRecords;
import java.util.Date;

/**
 *
 * @author mbirc
 */
public class Chef extends Arbeiter{
   
    public Chef(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
    }
/*    
    public void setLogin(){
        String pass = this.setPasswort();
        String user = this.setUserName();
        UpdateRecords.updateChefUserNameUndPass(user, pass, personalID);
    }
*/
    public void printMitarbAlph()
    {
        
    }
    
    public void printMitarbNachID()
    {
        
    }
    
    public void setMitarb(String n, int ID, String anschr, String e, int telefon, Date geburt, int persID)
    {
        
    }
    
    public void updateMitarb(String n, String anschr, String e, int telefon)
    {
        
    }
    
    public void deleteMitarb(String name)
    {
        
    }
    
    public void setChef(String n, int ID, String anschr, String e, int telefon, Date geburt, int persID)
    {
        
    }
    
    public void updateChef(String n, String anschr, String e, int telefon)
    {
        
    }
    
    public void deleteChef(String name)
    {
        
    }
    
}
