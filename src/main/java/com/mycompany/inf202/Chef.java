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
     * ein neuer Mitarbeiter wird ins Database gespeichert.
     * @param n -- Mitarbeiter Name
     * @param ID -- Mitarbeiter BurgerID
     * @param anschr -- Mitarbeiter Anschrift
     * @param e -- Mitarbeiter Email
     * @param telefon -- Mitarbeiter Telefonnummer
     * @param geburt -- Mitarbeiter Geburtsdatum
     * @param persID -- Mitarbeiter personalID
     * @param user -- Mitarbeiter userName
     * @param pass -- Mitarbeiter Passwort
     * @return TRUE falls Mitarbeiter erfolreich ins Database gespeichert wird, FALSE andernfalls
     */
    public boolean setMitarb(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass)
    {

        Mitarbeiter r = SelectRecords.findMitarbeiter(ID);
        if(r == null){
            Mitarbeiter k = new Mitarbeiter(n, ID, anschr, e, telefon, geburt, persID, user, pass);
            InsertRecords.insertMitarbeiter(n, ID, anschr, e, telefon, geburt, persID, user, pass);
            return true;                
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
     * neuer Chef wird ins Database gespeichert.
     * 
     * @param n -- Mitarbeiter Name
     * @param ID -- Mitarbeiter BurgerID
     * @param anschr -- Mitarbeiter Anschrift
     * @param e -- Mitarbeiter Email
     * @param telefon -- Mitarbeiter Telefonnummer
     * @param geburt -- Mitarbeiter Geburtsdatum
     * @param persID -- Mitarbeiter personalID
     * @param user -- Mitarbeiter userName
     * @param pass -- Mitarbeiter Passwort
     * @return TRUE falls erfolgreich gespeichert wird, FALSE andernfalls
     */
    public boolean setChef(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass)
    {
        Chef r = SelectRecords.findChef(ID);
        if(r == null){
            Chef k = new Chef(n, ID, anschr, e, telefon, geburt, persID, user, pass);
            InsertRecords.insertChef(n, ID, anschr, e, telefon, geburt, persID, user, pass);
            return true;                
        }else{
            return false;
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
