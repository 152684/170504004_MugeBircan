/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mbirc
 */
public class Arbeiter extends Person{
    
    protected int personalID; //8-stellig
    protected String passwort;
    protected String userName;
    
    private Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    InsertRecords insertData = new InsertRecords();
    
    private ArrayList<Chef> chefs = new ArrayList();
    private ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();
    private ArrayList<Kunde> kunden = new ArrayList();
    private ArrayList<ReiseLeiter> reiseleitern = new ArrayList();
    private ArrayList<Tour> tours = new ArrayList();
    private ArrayList<Hotel> hotels = new ArrayList();

   
    public Arbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt);
        personalID = persID;
        userName = user;
        passwort = pass;
    }
      
    public boolean setLogin(String user, String pass, int typ){
        userName = user;
        passwort = pass;
        if(typ == 1){
            UpdateRecords.updateChefUserNameUndPass(user, pass, burgerID); 
            return true;
        }else if(typ == 2){
            UpdateRecords.updateMitarbeiterUserNameUndPass(user, pass, burgerID);  
            return true;
        }
        return false;
    }

    public String getPasswort(){
        return passwort;
    }

    public String getUserName(){
        return userName;
    }

    public int getPersonalID(){
        return personalID;
    }
    
    public boolean setKunde(String n, long ID, String anschr, String e, int telefon, Date geburt) //typ von boolean zu int umwandeln um fehler beim hinzufuegen zu sehen
    {       
        try {
            Kunde k = SelectRecords.findKunde(ID);
            if(k == null){
                Kunde kNew = new Kunde(n, ID, anschr, e, telefon, geburt);
                InsertRecords.insertKunde(n, ID, anschr, e, telefon, geburt);
                return true;                
            }else{
                return false;
            }                        
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean updateKundenInfo(String n, long ID, String anschr, String e, int telefon)
    {       
        try {
            Kunde k = SelectRecords.findKunde(ID);
            if(k == null){
                return false;                
            }else{
                UpdateRecords.updateKunde(n, anschr, e, telefon, ID);
                return true;
            }                        
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean deleteKunde(long id) //nicht existierende Kunden werden auch true returned
    {
        try {
            Kunde r = SelectRecords.findKunde(id);
            if(r == null){
                return false;                
            }else{
                DeleteRecords.deleteKunde(id);
                return true;            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void kundeAlphPrint()
    {
        Iterator<Kunde> iter = kunden.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
    
    public void kundeNachNamePrint()
    {
        System.out.println("Geben Sie den Namen des Kunden ein: ");
        String name = sc.nextLine();
        Iterator<Kunde> iter = kunden.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getName() == name){
                iter.toString();
                break;
            }
        }
        
    }
/*           
    public int setTour( String n, Date d, String info, int maxT, String hN, float p, String rL)
    { // 1 erfolgreich ins Databease gespeichert, 2 existiert, 3 fehler

        Tour k = SelectRecords.findTour(n);
        if(k == null){
            InsertRecords.insertTour(n, d, info, maxT, hN, p, maxT, rL);
            return 1;                
        }else if(k!=null){
            return 2;
        }else{
            return 3;
        }                        

       
    }
*/    
    public int setTour2( String n, Date d, String info, int maxT, String hN, float p)
    { // 1 erfolgreich ins Databease gespeichert, 2 existiert, 3 fehler

        Tour k = SelectRecords.findTour(n);
        if(k == null){
            InsertRecords.insertTour2(n, d, info, maxT, hN, p, maxT);
            return 1;                
        }else if(k!=null){
            return 2;
        }else{
            return 3;
        }                        
      
    }


    public int updateTourInfos(String n, Date date, int maxT, String info, String hN, float p)
    {   // 0 maxTeil reduziert, 1 erfolgreich aktualisiert, 2 fehler, 3 existiert nicht

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
    
    public int setHotel(String n, String ansch, int telefon, String email, float preis)
    { // 1 erfolgreich ins Databease gespeichert, 2 existiert, 3 fehler

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
    
    public int deleteHotel(String n)
    { // 1 erfolgreich geloescht, 2 existiert nicht, 3 fehler
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
    
    public int updateHotelInfo(String n, String ansch, int telefon, String email, float preis)
    {   // 1 erfolgreich aktualisiert, 2 existiert nicht, 3 fehler

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
    
    public boolean setReiseL(String n, long ID, String anschr, String e, int telefon, Date geburt)
    {
        try {
            ReiseLeiter r = SelectRecords.findReiseL(ID);
            if(r == null){
                ReiseLeiter k = new ReiseLeiter(n, ID, anschr, e, telefon, geburt);
                InsertRecords.insertReiseLeiter(n, ID, anschr, e, telefon, geburt);
                return true;                
            }else{
                return false;
            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public boolean updateReiseLInfo(String n, String anschr, String e, int telefon, long ID)
    {
        try {
            ReiseLeiter k = SelectRecords.findReiseL(ID);
            if(k == null){
                return false;                
            }else{
                UpdateRecords.updateReiseL(n, anschr, e, telefon, ID);
                return true;
            }                        
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;               
    }
    
        
    public boolean deleteReiseL(long ID)
    {
        try {
            ReiseLeiter r = SelectRecords.findReiseL(ID);
            if(r == null){
                return false;                
            }else{
                DeleteRecords.deleteReiseL(ID);
                return true;            }
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }
    
}
