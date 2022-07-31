/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import java.text.SimpleDateFormat;
//import java.util.Date;
import java.sql.Date;

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
     * constructor fuer Klasse Person
     * @param n -- Name
     * @param ID -- BurgerID
     * @param anschr -- Anschrift
     * @param e -- Email
     * @param telefon -- Telefonnumer
     * @param geburt -- Geburtsdatum
     */
    public Person(String n, long ID, String anschr, String e, int telefon, Date geburt) 
    {
        name = n;
        burgerID = ID;
        anschrift = anschr;
        email = e;
        telefonnummer = telefon;
        geburtsdatum = geburt;            
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
    
}
