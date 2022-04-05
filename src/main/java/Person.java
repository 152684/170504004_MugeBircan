/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mbirc
 */


import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    
    private String name;
    private int burgerID;
    private String anschrift;
    private String email;
    private int telefonnummer;
    private Date geburtsdatum;
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    
    public Person(String n, int ID, String anschr, String e, int telefon, Date geburt)
    {
        name = n;
        burgerID = ID;
        anschrift = anschr;
        email = e;
        telefonnummer = telefon;
        geburtsdatum = geburt;
        
    }

    public void updateInfo(String n, String anschr, String e, int tel)
    {
        name = n;
        anschrift = anschr;
        email = e;
        telefonnummer = tel;
    }
    
    public void printInfo()
    {
        System.out.println("Frau/Herr " + name + ":");
        System.out.println("     burgerID:      " + burgerID);
        System.out.println("     geburtsdatum:  " + geburtsdatum);
        System.out.println("     anschrift:     " + anschrift);
        System.out.println("     email:         " + email);
        System.out.println("     telefonnummer: " + telefonnummer);
        
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
