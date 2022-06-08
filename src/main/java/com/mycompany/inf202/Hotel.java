/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

/**
 *
 * @author mbirc
 */
public class Hotel {
    
    private String name; /**< Hotel Name */
    private String anschrift; /**< Hotal Anschrift */
    private int telefonnummer; /**< Hotel Telefonnummer*/
    private String email; /**< Hotel Email */
    private float preis; /**<Hotel Preis */
    
    /**
     * constructor for class Hotel
     * @param n -- Hotel Name
     * @param ansch -- Hotel Anschrift
     * @param tel -- Hotel Telefonnummer
     * @param e -- Hotel Email
     * @param p -- Hotel Preis 
     */
    public Hotel(String n, String ansch, int tel, String e, float p)
    {
        name = n;
        anschrift = ansch;
        telefonnummer = tel;
        email = e;
        preis = p;
    }
    
    /**
     * getMethod for Hotel Name
     * @return Hotel Name
     */
    public String getName(){
        return name;
    }
    
    /**
     * getMethod for Hotel Anschrift
     * @return Hotel Anschrift
     */
    public String getAnschrift(){
        return anschrift;
    }

    /**
     * getMethod for Hotel Telefonnummer
     * @return Hotel Telefonnummer
     */
    public int getTelefonnummer(){
        return telefonnummer;
    }

    /**
     * getMethod for Hotel Eamil
     * @return Hotel Eamil
     */
    public String getEmail(){
        return email;
    }
    
    /**
     * getMethod for Hotel Preis
     * @return Hotel Preis
     */
    public float getPreis(){
        return preis;
    }
}
