/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author mbirc
 */
public abstract class Person {
    
    private String name;
    private String burgerID; // 11-stellige Zahl war zu groß für long, deswegen als String speichern.
    private String anschrift;
    private String email;
    private int telefonnummer;
    private Date geburtsdatum;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public static boolean isNumeric(String str) { 
        try {  
          Long.parseLong(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }

    
    public Person(String n, String ID, String anschr, String e, int telefon, Date geburt)
    {
        if(isNumeric(ID)){
            name = n;
            burgerID = ID;
            anschrift = anschr;
            email = e;
            telefonnummer = telefon;
            geburtsdatum = geburt;            
        }else{
            System.out.println("Fehler beim Erzeugen der Person!");
        }        
    }
    
    public String getBurgerID()
    {
        return burgerID;
    }

    public String getName()
    {
        return name;
    }
    
    public void updateInfo(String n, String anschr, String e, int tel)
    {
        name = n;
        anschrift = anschr;
        email = e;
        telefonnummer = tel;
    }
    
    
    @Override public String toString()
    {
        return String.format("Frau/Herr: " + name + "\n" +
                             "     burgerID:      " + burgerID + "\n" +
                             "     geburtsdatum:  " + geburtsdatum + "\n" +
                             "     anschrift:     " + anschrift + "\n" +
                             "     email:         " + email + "\n" +
                             "     telefonnummer: " + telefonnummer );
    }
  
    public void updateKontakt(String e, int tel)
    {
        email = e;
        telefonnummer = tel;
    }
    
    public void printKontakt()
    {
        System.out.println("Frau/Herr " + name + ":");
        System.out.println("     email:         " + email);
        System.out.println("     telefonnummer: " + telefonnummer);        
    }
}
