/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.DeleteRecords;
import databaseFunctions.InsertRecords;
import databaseFunctions.SelectRecords;
import databaseFunctions.UpdateRecords;
import java.sql.Date;

/**
 *
 * @author mbirc
 * 
 * Chef class extends from Arbeiter
 */
public class Chef extends Arbeiter{
   
    /**
     * Constructor for class Chef
     * @param n -- Chef Name
     * @param ID -- Chef BurgerID
     * @param anschr -- Chef Anschrift
     * @param e -- Chef Email
     * @param telefon -- Chef Telefonnummer
     * @param geburt -- Chef Geburtsdatum
     * @param persID -- Chef personalID
     * @param user -- Chef userName
     * @param pass -- Chef Passwort
     */
    public Chef(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) 
    {
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
    }
    
    /**
     * Konstruktor fuer Chef
     * @param n
     * @param ID
     * @param anschr
     * @param e
     * @param telefon
     * @param geburt
     * @param persID
     * @param user
     * @param pass
     * @param neuRegister 
     */
    public Chef(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass, boolean neuRegister) 
    {
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass, neuRegister);
        
    }

    /**
     * Mitarbetier Hinzufuegen 
     * @param m -- Mitarbeiter
     * @return -- true falls erfolgreich, false andernfalls
     */
    public boolean setMitarbNeu(Mitarbeiter m){
        Mitarbeiter r = SelectRecords.findMitarbeiter(m.getBurgerID());
        if(r == null){
            boolean erfolg = InsertRecords.insertMitarbeiterNeu(m);
            return erfolg;                
        }else{
            return false;
        }        
    }
    
    /**
     * Mitarbetier Hinzufuegen 
     * @param m -- Mitarbeiter
     * @return -- true falls erfolgreich, false andernfalls
     */
    public boolean setChefNeu(Chef c){
        Chef r = SelectRecords.findChef(c.getBurgerID());
        if(r == null){
            boolean erfolg = InsertRecords.insertChefNeu(c);
            return erfolg;                
        }else{
            return false;
        }        
    }
    
    /**
     * Mitarbeiterinfos Name, Anschrift, Email und Telefonnummer werden aktualisiert wobei der BurgerID gegeben ist 
     * @param n -- Mitarbeiter Name
     * @param anschr -- Mitarbeiter Anschrift
     * @param e -- Mitarbeiter Email
     * @param telefon -- Mitarbeiter Telefonnummer
     * @param ID  -- Mitarbeiter BurgerID
     */
    public void updateMitarb(String n, String anschr, String e, int telefon, long ID)
    {
        UpdateRecords.updateMitarbeiter(n, anschr, e, telefon, ID);                
    }
    
    /**
     * Mitarbeiter mit dem gegebenen BurgerID wird geloescht
     * @param ID -- Mitarbeiter BurgerID
     * @return TRUE falls erfolgreich geloescht wird, FALSE andernfalls
     */
    public boolean deleteMitarb(long ID)
    {

        Mitarbeiter r = SelectRecords.findMitarbeiter(ID);
        if(r == null){
            return false;                
        }else{
            boolean erfolg = DeleteRecords.deleteMitarbeiter(ID);
            return erfolg;            
        }
    }
        
    /**
     * Chefinfos Name, Anschrift, Email und Telefonnummer werden aktualisiert wobei der BurgerID gegeben ist 
     * @param n -- Mitarbeiter Name
     * @param anschr -- Mitarbeiter Anschrift
     * @param e -- Mitarbeiter Email
     * @param telefon -- Mitarbeiter Telefonnummer
     * @param ID  -- Mitarbeiter BurgerID
     */
    public void updateChef(String n, String anschr, String e, int telefon, long ID)
    {
        UpdateRecords.updateChef(n, anschr, e, telefon, ID);        
        
    }
    
    /**
     * Chef mit dem gegebenen BurgerID wird geloescht
     * @param ID -- Chef BurgerID
     * @return TRUE falls erfolgreich geloescht wird, FALSE andernfalls
     */
    public boolean deleteChef(long ID)
    {

        Chef r = SelectRecords.findChef(ID);
        if(r == null){
            return false;                
        }else{
            boolean erfolg = DeleteRecords.deleteChef(ID);
            return erfolg;            
        }
    }
    
}
