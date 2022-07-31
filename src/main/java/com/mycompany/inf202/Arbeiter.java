/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.*;
import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;
import java.util.Scanner;

/**
 * 
 * @author mbirc
 * 
 * Arbeiter class extends from Person and has subclasses:
 * Chef
 * Mitarbeiter 
 */
public class Arbeiter extends Person{
    
    protected int personalID; /**< personalID is the ID that every employee (Chef, Mitarbeiter) has*/
    protected String passwort; /**< an employee uses his/her passwort to log in the system*/ 
    protected String userName; /**< an employee uses his/her username to log in the system*/
    protected boolean neuRegister; /**< true falls der Arbeiter neu registriert is, false andernfalls*/
    
    private Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    InsertRecords insertData = new InsertRecords();
    

    /**
     * constructor class for Arbieter
     * @param n -- Arbeiter Name
     * @param ID -- Arbieter BürgerID
     * @param anschr -- Arbeiter Anschrift
     * @param e -- Arbeiter email
     * @param telefon -- Arbeiter Telefonnummer
     * @param geburt -- Arbeiter Geburtsdatum
     * @param persID -- Arbieter PersonalID
     * @param user -- Arbieter UserName
     * @param pass -- Arbeiter Passwort
     */
    public Arbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) 
    {
        super(n, ID, anschr, e, telefon, geburt);
        personalID = persID;
        userName = user;
        passwort = pass;
        neuRegister = true;
    }
     
    /**
     * Konstruktor fuer Arbeiter
     * @param n
     * @param ID
     * @param anschr
     * @param e
     * @param telefon
     * @param geburt
     * @param persID
     * @param user
     * @param pass
     * @param neuReg 
     */
    public Arbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass, boolean neuReg) 
    {
        super(n, ID, anschr, e, telefon, geburt);
        personalID = persID;
        userName = user;
        passwort = pass;
        neuRegister = neuReg;
    }

    /**
     * Diese Methode aktualisiert Login-Daten eines Arbieters
     * 
     * @param user -- userName
     * @param pass -- passwort
     * @param typ -- enscheidet ob die Benutzer ein Chef oder ein Mitarbeiter ist. Int Wert 1 wird fuer Chef und Int Wert 2 wird fuer Mitarbeiter benutzt.
     * @return TRUE wenn Aktualisierung erfolgreich ist, FALSE wenn Aktualisierung nicht erflogreich ist.
     */
    public boolean setLogin(String user, String pass, int typ){
        userName = user;
        passwort = pass;
        boolean erfolg = false;
        if(typ == 1){
            erfolg = UpdateRecords.updateChefUserNameUndPass(user, pass, burgerID); 
        }else if(typ == 2){
            erfolg = UpdateRecords.updateMitarbeiterUserNameUndPass(user, pass, burgerID);  
        }
        return erfolg;
    }

    /**
     * get Methode fuer Passwort
     * @return passwort
     */
    public String getPasswort(){
        return passwort;
    }

    /**
     * get Methode fuer userName
     * @return userName
     */
    public String getUserName(){
        return userName;
    }

    /**
     * getMethode fuer personalID
     * @return personalID
     */
    public int getPersonalID(){
        return personalID;
    }
    
    /**
     * getMethose fuer neuRegister
     * @return neuRegister
     */
    public boolean getNeuRegister(){
        return neuRegister;
    }
    
    /**
     * setKunde Methode um eine neue Kunde im System zu registrieren
     * 
     * @param n -- Kunde Name
     * @param ID -- Kunde BurgerID
     * @param anschr -- Kunde Anschrift
     * @param e -- Kunde email
     * @param telefon -- Kunde Telefonnummer
     * @param geburt -- Kunde Geburtsdatum
     * @return TRUE wenn Kunde erfolgreich ins System registriert wird, FALSE andernfalls
     */
    public boolean setKunde(String n, long ID, String anschr, String e, int telefon, Date geburt) 
    {       

        Kunde k = SelectRecords.findKunde(ID);
        if(k == null){
            Kunde kNew = new Kunde(n, ID, anschr, e, telefon, geburt);
            InsertRecords.insertKunde(n, ID, anschr, e, telefon, geburt);
            return true;                
        }else{
            return false;
        }                        
        
    }
    
    /**
     * Kundeninformationen Name, Anschrift, Email, Telefonnummer bei dem Kunde mit dem gegebenen BurgerID werden aktualisiert.
     * @param n -- Kunde Name
     * @param ID -- Kunde BurgerID
     * @param anschr -- Kunde Anschrift
     * @param e -- Kunde email
     * @param telefon -- Kunde Telefonnummer
     * @return TRUE wenn Kunde erfolgreich aktualisiert wird, FALSE andernfalls
     */
    public boolean updateKundenInfo(String n, long ID, String anschr, String e, int telefon)
    {       

        Kunde k = SelectRecords.findKunde(ID);
        if(k == null){
            return false;                
        }else{
            UpdateRecords.updateKunde(n, anschr, e, telefon, ID);
            return true;
        }                        
    }
    
    /**
     * Kunde wird vom System geloescht.
     * @param id -- Kunde BurgerID
     * @return TRUE falls Kunde erfolgreich vom System geloescht wird, FALSE andernfalls
     */
    public boolean deleteKunde(long id) 
    {

        Kunde r = SelectRecords.findKunde(id);
        if(r == null){
            return false;                
        }else{
            boolean erfolg = DeleteRecords.deleteKunde(id);
            return erfolg;            }
    }
    
    /**
     * ein neuer Tour wird in das System gespeichert.
     * @param n -- Tour Name
     * @param d -- Tour Datum
     * @param info -- Tour Info (welche Orte werden besucht usw.)
     * @param maxT -- maximale Teilnehmerzahl
     * @param hN -- Hotel Name
     * @param p -- Preis
     * @retval 1 -- falls der Tour erfolgreich in die Database gespeichert wird
     * @retval 2 -- falls der Tour schon existiert
     * @retval 3 -- falls es ein Fehler gibt
     */
    public int setTour( String n, Date d, String info, int maxT, String hN, float p)
    {
        Tour k = SelectRecords.findTour(n);
        if(k == null){
            InsertRecords.insertTour(n, d, info, maxT, hN, p, maxT);
            return 1;                
        }else if(k!=null){
            return 2;
        }else{
            return 3;
        }                        
      
    }


    /**
     * Tourinformationen Datum, maximale Teilnehmerzahl, Tourinfo, Hotelname, Preis bei dem Tour mit dem gegebenen Name werden aktualisiert.
     * @param n -- Tour Name
     * @param date -- Tour Datum
     * @param maxT -- maximale Teilnehmerzahl
     * @param info -- Tour Info (welche Orte werden besucht usw.)
     * @param hN -- Hotel Name
     * @param p -- Preis
     * @retval 0 -- falls maximale Teilnehmer reduziert wird (das wird von dem System nicht erlaubt)
     * @retval 1 -- falls der Tour erfolgreich aktualisiert wird
     * @retval 2 -- falls es ein Fehler gibt
     * @retval 3 -- falls der Tour nicht existiert
     */
    public int updateTourInfos(String n, Date date, int maxT, String info, String hN, float p)
    {   

        Tour k = SelectRecords.findTour(n);
        int erfolg = 3;
        if(k != null){
            erfolg = UpdateRecords.updateTourInfo(n, date, maxT, info, hN, p);
            switch (erfolg) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                default:
                    return 2;
            }                
        }else if(k == null){
            return 2;
        }else{
            return 3;
        }                        
    }
    
    /**
     * deletes Tour von Database wobei der TourName gegeben ist
     * @param n -- Tour Name
     * @retval 1 -- falls Tour erfolgreich geloescht wird
     * @retval 2 -- falls der Tour nict existiert
     * @retval 3 -- falls einen Fehler gibt
     */
    public int deleteTour(String n)
    { // 1 erfolgreich geloescht, 2 existiert nicht, 3 fehler
        Tour k = SelectRecords.findTour(n);
        if(k != null){
            DeleteRecords.deleteTour(n);
            return 1;                
        }else if(k == null){
            return 2;
        }else{
            return 3;
        }                        
        
    }
    
    /**
     * ein neues Hotel wird im Database gespeichert
     * @param n -- Hotel Name
     * @param ansch -- Hotel Anschrift
     * @param telefon -- Hotel Telefonnummer
     * @param email -- Hotel Email
     * @param preis -- Hotel Preis
     * @retval 1 -- falls das Hotel erfolgreich ins Database gespeichert wird
     * @retval 2 -- falls das Hotel schon existiert
     * @retval 3 -- falls einen Fehler gibt
     */
    public int setHotel(String n, String ansch, int telefon, String email, float preis)
    { 
        Hotel k = SelectRecords.findHotel(n);
        if(k == null){
            InsertRecords.insertHotel(n, ansch, telefon, email, preis);
            return 1;                
        }else if(k!=null){
            return 2;
        }else{
            return 3;
        }                        
    }
    
    /**
     * Hotel wird vom Database geloescht wobei der HotelName gegeben ist
     * @param n -- Hotle Name
     * @retval 1 -- falls das Hotle erfolgreich geloesht wird
     * @retval 2 -- falls das Hotel nicht existiert
     * @retval 3 falls einen Fehler gibt
     */
    public int deleteHotel(String n)
    { 
        Hotel k = SelectRecords.findHotel(n);
        if(k != null){
            DeleteRecords.deleteHotel(n);
            return 1;                
        }else if(k == null){
            return 2;
        }else{
            return 3;
        }                        
    }
    
    /**
     * Hotelinformationen Anschrift, Telefonnummer, Email und Preis werden aktualisiert wobei der HotelName gegeben ist
     * @param n -- Hotel Name
     * @param ansch -- Hotel Anschrift
     * @param telefon -- Hotel Telefonnummer
     * @param email -- Hotel Email
     * @param preis -- Hotel Preis
     * @retval 1 -- falls das Hotel erfolgreich aktualisiert wird
     * @retval 2 -- falls das Hotel nicht existiert
     * @retval 3 -- falls einen Fehler gibt
     */
    public int updateHotelInfo(String n, String ansch, int telefon, String email, float preis)
    {   
        Hotel k = SelectRecords.findHotel(n);
        if(k != null){
            UpdateRecords.updateHotel(n, ansch, email, telefon, preis);
            return 1;                
        }else if(k == null){
            return 2;
        }else{
            return 3;
        }                        
    }
    
    /**
     * ein neuer ReiseLeiter wird ins Database geschpeichert
     * 
     * @param n -- ReiseLeiter Name
     * @param ID -- ReiseLeiter BurgerID
     * @param anschr -- ReiseLeiter Anschrift
     * @param e -- ReiseLeiter Email
     * @param telefon -- ReiseLeiter Telefonnummer
     * @param geburt -- ReiseLeiter Geburtsdatum
     * @return TRUE falls ReiseLeiter erfolgreich ins Database gespeichert wird, FALSE andernfalls 
     */
    public boolean setReiseL(String n, long ID, String anschr, String e, int telefon, Date geburt)
    {

        ReiseLeiter r = SelectRecords.findReiseL(ID);
        if(r == null){
            ReiseLeiter k = new ReiseLeiter(n, ID, anschr, e, telefon, geburt);
            InsertRecords.insertReiseLeiter(n, ID, anschr, e, telefon, geburt);
            return true;                
        }else{
            return false;
        }
    }
    
    /**
     * ReiseLeiterinfos Name, Anschrift, Email, Telefonnummer werden aktualisiert wobei der BurgerID gegeben ist
     * 
     * @param n -- ReiseLeiter Name
     * @param ID -- ReiseLeiter BurgerID
     * @param anschr -- ReiseLeiter Anschrift
     * @param e -- ReiseLeiter Email
     * @param telefon -- ReiseLeiter Telefonnummer
     * @return TRUE falls ReiseLeiter erfolgreich ins Database gespeichert wird, FALSE andernfalls 
     */
    public boolean updateReiseLInfo(String n, String anschr, String e, int telefon, long ID)
    {
        ReiseLeiter k = SelectRecords.findReiseL(ID);
        if(k == null){
            return false;                
        }else{
            UpdateRecords.updateReiseL(n, anschr, e, telefon, ID);
            return true;
        }                        
        
    }
    
    /**
     * ReiseLeter mit dem gegebenen BurgerID wird geloescht
     * @param ID -- ReiseLeiter BurgerID
     * @return TRUE falls ReiseLeiter erfolgreich geloescht wird, FALSE andernfalls 
     */    
    public boolean deleteReiseL(long ID)
    {

        ReiseLeiter r = SelectRecords.findReiseL(ID);
        if(r == null){
            return false;                
        }else{
            DeleteRecords.deleteReiseL(ID);
            return true;            }
    }
    
}
