/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.DeleteRecords;
import databaseFunctions.InsertRecords;
import databaseFunctions.SelectRecords;
import databaseFunctions.UpdateRecords;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbirc
 */
public class Chef extends Arbeiter{
   
    public Chef(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
    }

    public void printMitarbAlph()
    {
        
    }
    
    public void printMitarbNachID()
    {
        
    }
    
    public boolean setMitarb(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass)
    {
        try {
            Mitarbeiter r = SelectRecords.findMitarbeiter(ID);
            if(r == null){
                Mitarbeiter k = new Mitarbeiter(n, ID, anschr, e, telefon, geburt, persID, user, pass);
                InsertRecords.insertMitarbeiter(n, ID, anschr, e, telefon, geburt, persID, user, pass);
                return true;                
            }else{
                return false;
            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public void updateMitarb(String n, String anschr, String e, int telefon, long ID)
    {
        UpdateRecords.updateMitarbeiter(n, anschr, e, telefon, ID);                
    }
    
    public boolean deleteMitarb(long ID)
    {
        try {
            Mitarbeiter r = SelectRecords.findMitarbeiter(ID);
            if(r == null){
                return false;                
            }else{
                DeleteRecords.deleteMitarbeiter(ID);
                return true;            
            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean setChef(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass)
    {
        try {
            Chef r = SelectRecords.findChef(ID);
            if(r == null){
                Chef k = new Chef(n, ID, anschr, e, telefon, geburt, persID, user, pass);
                InsertRecords.insertChef(n, ID, anschr, e, telefon, geburt, persID, user, pass);
                return true;                
            }else{
                return false;
            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public void updateChef(String n, String anschr, String e, int telefon, long ID)
    {
        UpdateRecords.updateChef(n, anschr, e, telefon, ID);        
        
    }
    
    public boolean deleteChef(long ID)
    {
        try {
            Chef r = SelectRecords.findChef(ID);
            if(r == null){
                return false;                
            }else{
                DeleteRecords.deleteChef(ID);
                return true;            
            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
}
