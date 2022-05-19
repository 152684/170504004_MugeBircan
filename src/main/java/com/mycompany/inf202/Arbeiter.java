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
    
    public void updateKundenInfo(String n, long ID, String anschr, String e, int telefon)
    {
        UpdateRecords.updateKunde(n, anschr, e, telefon, ID);

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
       
    public void kundeNachIDprint()
    {
    /*
        System.out.println("Geben Sie die BuergerID des Kunden ein: ");
        int id = sc.nextInt();
        sc.nextLine();
        Iterator<Kunde> iter = kunden.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getBurgerID() == id){
                iter.toString();
                break;
            }
        }
    */    
    }
    
    public int setTour( String n, Date d, String info, int maxT, String hN, float p, String rL)
    { // 1 erfolgreich ins Databease gespeichert, 2 existiert, 3 fehler
        try {// throw unneccesary??
            Tour k = SelectRecords.findTour(n);
            if(k == null){
                Tour kNew = new Tour(n, d, info, maxT, hN, p, rL);
                InsertRecords.insertTour(n, d, info, maxT, hN, p, maxT, rL);
                return 1;                
            }else{
                return 2;
            }                        
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 3;
       
    }
    
    public int updateTourInfos(String n, Date date, int maxT, String info, String hN, float p, String reiseL)
    {   // 1 erfolgreich aktualisiert, 2 existiert nicht, 3 fehler
        try {// throw unneccesary??
            Tour k = SelectRecords.findTour(n);
            if(k != null){
                UpdateRecords.updateTourInfo(n, date, maxT, info, hN, p, hN);
                return 1;                
            }else{
                return 2;
            }                        
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 3;
    }
    
    public int deleteTour(String n)
    { // 1 erfolgreich geloescht, 2 existiert nicht, 3 fehler
        try {// throw unneccesary??
            Tour k = SelectRecords.findTour(n);
            if(k != null){
                DeleteRecords.deleteTour(n);
                return 1;                
            }else{
                return 2;
            }                        
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 3;
        
    }

    public void tourAlphPrint()
    {
        Iterator<Tour> iter = tours.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        
    }
/*
    public void tourPreisPrint()
    {
        System.out.println("Geben Sie den Namen des Tours ein: ");
        String name = sc.nextLine();
        Iterator<Tour> iter = tours.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getName() == name){
//                System.out.println("Der Preis ist: " + iter.getPreis());
                break;
            }
        }
        
    }

    public void tourNachNamePrint()
    {
        System.out.println("Geben Sie den Namen des Tours ein: ");
        String name = sc.nextLine();
        Iterator<Tour> iter = tours.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getName() == name){
                iter.toString();
                break;
            }
        }
        
    }
*/
    public void printTourKunden(String tour)
    {
        
    }

    public void tourSetHotel(String tour, String hotel)
    {
        
    }
    
    public void tourSetKunde(String tour, String kunde)
    {
        
    }
    
    public void tourDeleteKunde(String tour, String kunde)
    {
        
    }
    
    public void setHotel(String n, String ansch, int telefon, float preis)
    {
        
    }
    
    public void hotelAlphPrint()
    {
        Iterator<Hotel> iter = hotels.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        
    }
    
    public void hotelNachNamePrint()
    {
        System.out.println("Geben Sie den Namen des Hotels ein: ");
        String name = sc.nextLine();
        Iterator<Hotel> iter = hotels.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getName() == name){
                iter.toString();
                break;
            }
        }
        
    }
    
    public void deleteHotel(String n)
    {
        
    }
    
    public void updateHotelInfo(String n, String ansch, int telefon, float preis)
    {
        
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
    
    public void updateReiseLInfo(String n, String anschr, String e, int telefon, long ID)
    {
        UpdateRecords.updateReiseL(n, anschr, e, telefon, ID);        
    }
    
    public void reiseLAlphPrint()
    {
        Iterator<ReiseLeiter> iter = reiseleitern.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
            
    }
    
    public void printReiseL()
    {
        System.out.println("Geben Sie den Namen des Kunden ein: ");
        String name = sc.nextLine();
        Iterator<ReiseLeiter> iter = reiseleitern.iterator();
        
        while(iter.hasNext()){
            if(iter.next().getName() == name){
                iter.toString();
                break;
            }
        }
        
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
