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
    
    private String name;
    private String anschrift;
    private int telefonnummer;
    private String email;
    private float preis;
    
    public Hotel(String n, String ansch, int tel, String e, float p)
    {
        name = n;
        anschrift = ansch;
        telefonnummer = tel;
        email = e;
        preis = p;
    }
    
    public void updateInfo(String ansch, int tel, String e, float p)
    {
        anschrift = ansch;
        telefonnummer = tel;
        email = e;
        preis = p;        
    }
    
    public String getName(){
        return name;
    }
    
    public String getAnschrift(){
        return anschrift;
    }

    public int getTel(){
        return telefonnummer;
    }

    public String getEmail(){
        return email;
    }
    
    public float getPreis(){
        return preis;
    }
    @Override public String toString(){
        return String.format("Hotel: " + name + "\n" +
                             "      Anschrift:     " + anschrift +
                             "      Telefonnummer: " + telefonnummer +
                             "      Email:         " + email +
                             "      Preis:         " + preis);
    }
}
