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
    
    
    public boolean setKunde(String n, long ID, String anschr, String e, int telefon, Date geburt) // existierende kunden werden nicht anerkannt (nicht nochmal
                                                                                                  //hinzugefugt aber wird benachrichtight, dass sie hinzugefugt werden
    {
        try {
            Kunde k = new Kunde(n, ID, anschr, e, telefon, geburt);
            InsertRecords.insertKunde(n, ID, anschr, e, telefon, geburt);
            return true;
        } catch (UngueltigeIDException ex) {
            Logger.getLogger(Arbeiter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void updateKundenInfo()
    {

    }
    
    public boolean deleteKunde(long id) //nicht existierende Kunden werden auch true returned
    {
        try {
            DeleteRecords.deleteKunde(id);
            return true;
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
    
    public void setTour()
    {
/*
        String n2;
        Date datum = null;
        String inf;
        String rL;
        int maxT, freiP;
        float preis;
        String hotel;
        
        System.out.println("Geben Sie den Namen ein: ");
        n2 = sc.nextLine();
        System.out.println("Geben Sie den datum ein: ");
        String d = sc.nextLine();
        try{
            datum = dateFormat.parse(d);        
        }catch(ParseException e){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }
        System.out.println("Geben Sie die Informationen ein: ");
        inf = sc.nextLine();
        System.out.println("Geben Sie die maximale Teilnehmerzahl ein: ");
        maxT = sc.nextInt();
        freiP = maxT;
        System.out.println("Geben Sie den Preis ein: ");
        preis = sc.nextFloat();
        System.out.println("Geben Sie den Hotelnamen ein: ");
        hotel = sc.nextLine();
        System.out.println("Geben Sie den verantwortlichen Reiseleiter ein: ");
        rL = sc.nextLine();
        Iterator<ReiseLeiter> iter = reiseleitern.iterator();
        Iterator<ReiseLeiter> iterR = reiseleitern.iterator();
        boolean ex = false;
        int stelle = -1;
        while(iter.hasNext()){
            stelle++;
            if(iter.next().getName() == null ? rL == null : iter.next().getName().equals(rL)){
                ex = true;
                break;
            }
        }
        if(ex){
            while(stelle != 0){
                stelle--;
                iterR.next();
            }
        }else{
            System.out.println("Es gibt keinen Reiseleiter mit den Namen " + rL);
        }

        Iterator<Tour> iterT = tours.iterator();
        boolean exT = false;
        while(iterT.hasNext()){
            if(iterT.next().getName() == n2){
                exT = true;
                System.out.println("Die Tour mit der Name " + n2 +  " existiert schon!");
                break;
            }
        }
        
        if((exT == false) && ex){
            Tour t = new Tour(n2, datum, inf, maxT, hotel, preis, freiP, iterR.next());
            tours.add(t);
        }else if(!exT && !ex){
            Tour t = new Tour(n2, datum, maxT, hotel, preis, freiP);
            tours.add(t);
        }
*/        
    }
    
    public void updateTourReiseL(String tourName, String reiseL)
    {
        
    }
    
    public void updateTourDate(String tourName, Date d)
    {
        
    }
    
    public void updateTourInfo(String tourName, String info)
    {
        
    }

    public void updateTourMaxTeilnehmer(String tourName, int m)
    {
        
    }
    
    public void updateTourPreis(String tourName, float preis)
    {
        
    }

    public void deleteTour(String tourName)
    {
        
    }

    public void tourAlphPrint()
    {
        Iterator<Tour> iter = tours.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
        
    }

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
    
    public void setReiseL(String n, int ID, String anschr, String e, int telefon, Date geburt)
    {
        
    }
    
    public void updateReiseLInfo(String n, String anschr, String e, int telefon)
    {
        
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
    
    public void deleteReiseL(String n)
    {
        
    }
    
}
