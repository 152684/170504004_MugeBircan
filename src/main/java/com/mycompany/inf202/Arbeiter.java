/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

/**
 *
 * @author mbirc
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class Arbeiter extends Person{
    
    //protected int personalID;
    private String passwort;
    
    private Scanner sc = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    //private ArrayList<Chef> chefs = new ArrayList();
    private ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();
    private ArrayList<Kunde> kunden = new ArrayList();
    private ArrayList<ReiseLeiter> reiseleitern = new ArrayList();
    private ArrayList<Tour> tours = new ArrayList();
    private ArrayList<Hotel> hotels = new ArrayList();

    
    public Arbeiter(String n, int ID, String anschr, String e, int telefon, Date geburt/*, int persID*/) {
        super(n, ID, anschr, e, telefon, geburt);
        //personalID = persID;
    }
    
    public void setKunde()
    {
        String n2;
        int ID2;
        String anschr2;
        String e2;
        int telefon2;
        Date geburt2 = null;
                
        System.out.println("Geben Sie den Namen ein: ");
        n2 = sc.nextLine();
        //sc.nextLine();
        System.out.println("Geben Sie die BugerID ein: ");
        ID2 = sc.nextInt();
        sc.nextLine();
        System.out.println("Geben Sie den Anschrift ein: ");
        anschr2 = sc.nextLine();
        //sc.nextLine();
        System.out.println("Geben Sie die Email ein: ");
        e2 = sc.nextLine();
        //sc.nextLine();
        System.out.println("Geben Sie die Telefonnummer ein: ");
        telefon2 = sc.nextInt(); 
        sc.nextLine();
        System.out.println("Geben Sie den Geburtsdatum ein: ");
        String d = sc.nextLine();
        //sc.nextLine();
        try{
            geburt2 = dateFormat.parse(d);        
        }catch(ParseException e){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }

        Iterator<Kunde> iter = kunden.iterator();
        boolean ex = false;
        while(iter.hasNext()){
            if(iter.next().getBurgerID() == ID2){
                ex = true;
                System.out.println("Der Kunde mit der BurgerID " + ID2 +  " existiert!");
                break;
            }
        }
        
        if(ex == false){
            Kunde k = new Kunde(n2, ID2, anschr2, e2, telefon2, geburt2);
            kunden.add(k);
        }
        
    }
    
    public void updateKundenIfno()
    {

        String n2;
        int id;
        String anschr2;
        String e2;
        int telefon2;
                
        System.out.println("Geben Sie die BurgerID der Kunde ein: ");
        id = sc.nextInt();

        Iterator<Kunde> iter = kunden.iterator();        
        boolean ex = false;
        int stelle = -1;
        while(iter.hasNext()){
            stelle++;
            if(iter.next().getBurgerID() == id){
                ex = true;
                break;
            }
        }
        
        if(ex){
            System.out.println("Geben Sie den neuen Namen ein: ");
            n2 = sc.nextLine();
            System.out.println("Geben Sie den neuen Anschrift ein: ");
            anschr2 = sc.nextLine();
            System.out.println("Geben Sie die neue Email ein: ");
            e2 = sc.nextLine();
            System.out.println("Geben Sie die neue Telefonnummer ein: ");
            telefon2 = sc.nextInt(); 

            Iterator<Kunde> iter2 = kunden.iterator();
            while(stelle != 0){
                iter2.next();
                stelle--;                
            }
            iter2.next().updateInfo(n2, anschr2, e2, telefon2);            
        }else{
            System.out.println("Der Kunde ex. nicht!");
        }
     
    }
    
    public void deleteKunde()
    {
        int id;
                
        System.out.println("Geben Sie die BurgerID der Kunde ein: ");
        id = sc.nextInt();
        sc.nextLine();

        Iterator<Kunde> iter = kunden.iterator();        
        boolean ex = false;
        int stelle = -1;
        while(iter.hasNext()){
            stelle++;
            if(iter.next().getBurgerID() == id){
                ex = true;
                break;
            }
        }
 
        if(ex){
            System.out.println("Der Kunde mit der BurgerID " + id + " wird nun geloscht.");
            kunden.remove(stelle);
        }else{
            System.out.println("Der Kunde mit der eingegebenen BurgerID ex. nicht!");
        }
    }
    
    public void kundeAlphPrint()
    {
        Iterator<Kunde> iter = kunden.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().toString());
        }
    }
    
    public void printKunde(String n)
    {
        
    }
    
    public void printKunde(int id)
    {
        
    }
    
    public void kundeNachIDprint()
    {
        
    }
    
    public void setTour()
    {
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
        
    }

    public void tourPreisPrint()
    {
        
    }

    public void printTour(String tour)
    {
        
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
        
    }
    
    public void printHotel(String n)
    {
        
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
        
    }
    
    public void printReiseL(String n)
    {
        
    }
    
    public void deleteReiseL(String n)
    {
        
    }
    
}
