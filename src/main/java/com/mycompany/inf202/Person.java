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
 * Person class extends from Person and has subclasses:
 * Arbeiter
 * Chef
 * Mitarbeiter
 * Kunde
 * ReiseLeiter 
 */
public abstract class Person {
    
    protected String name; /**< voller Name*/
    protected long burgerID; /**<Buerger ID*/
    protected String anschrift; /**< Anschrift*/
    protected String email; /**< Email*/
    protected int telefonnummer; /**< Telefonnummer*/
    protected Date geburtsdatum; /**< Geburtsdatum*/
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); /**< Gibt an, wie der Datum eingegeben werden soll.*/

    /**
     * Ueberprueft, ob die gegebene BurgerID gueltig ist
     * @param a -- gegebene BurgerID
     * @return TRUE falls ID gueltig, FALSE falls ID nicht gueltig
     */
    public static boolean idGueltig(long a) { 
        return (10000000000L <= a) && (a <= 99999999999L);
    }

    /**
     * constructor fuer Klasse Person
     * @param n -- Name
     * @param ID -- BurgerID
     * @param anschr -- Anschrift
     * @param e -- Email
     * @param telefon -- Telefonnumer
     * @param geburt -- Geburtsdatum
     * @throws UngueltigeIDException falls die gegebene ID nicht gueltig ist 
     */
    public Person(String n, long ID, String anschr, String e, int telefon, Date geburt) throws UngueltigeIDException
    {
        if(idGueltig(ID)){
            name = n;
            burgerID = ID;
            anschrift = anschr;
            email = e;
            telefonnummer = telefon;
            geburtsdatum = geburt;            
        }else{
            System.out.println("Fehler beim Erzeugen der Person!");
            throw new UngueltigeIDException();
        }        
    }
    
    /**
     * get Method fuer burgerID
     * @return burgerID
     */
    public long getBurgerID()
    {
        return burgerID;
    }

    /**
     * get Method fuer anschrift
     * @return anschrift
     */
    public String getAnschrift()
    {
        return anschrift;
    }

    /**
     * get Method fuer email
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * get Method fuer telefonnummer
     * @return telefonnummer
     */
    public int getTelefonnummer()
    {
        return telefonnummer;
    }

    /**
     * get Method fuer geburtsdatum
     * @return geburtsdatum
     */
    public Date getGeburtsdatum()
    {
        return geburtsdatum;
    }

    /**
     * get Method fuer name
     * @return name
     */
    public String getName()
    {
        return name;
    }
    
    /*
    public void updateInfo(String n, String anschr, String e, int tel)
    {
        name = n;
        anschrift = anschr;
        email = e;
        telefonnummer = tel;
    }
    
    public void updateKontakt(String e, int tel)
    {
        email = e;
        telefonnummer = tel;
    }
    */
}
