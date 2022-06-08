/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author mbirc
 * 
 * Class Kunde extends from Class Person
 */
public class Kunde extends Person{
    
    private String reisen; /**< String form aller Touren, die ein Kunde sich angemeldet hat*/
    
    /**
     * constructor for Kunde
     * @param n -- Kunde Name
     * @param ID -- Kunde BurgerID
     * @param anschr -- Kunde Anschrift
     * @param e -- Kunde Email
     * @param telefon -- Kunde Telefonnummer
     * @param geburt -- Kunde Geburtsdatum
     * @throws UngueltigeIDException 
     */
    public Kunde(String n, long ID, String anschr, String e, int telefon, Date geburt) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt);
    }

    /**
     * constructor 2 for Kunde
     * @param n -- Kunde Name
     * @param ID -- Kunde BurgerID
     * @param anschr -- Kunde Anschrift
     * @param e -- Kunde Email
     * @param telefon -- Kunde Telefonnummer
     * @param geburt -- Kunde Geburtsdatum
     * @param reise -- Kunde Reisen
     * @throws UngueltigeIDException 
     */
    public Kunde(String n, long ID, String anschr, String e, int telefon, Date geburt, String reise) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt);
        reisen = reise;
    }

    /**
     * getMethod for Reisen einer Kunde
     * @return reisen
     */
    public String getReisen() {
        return reisen;
    }

}
