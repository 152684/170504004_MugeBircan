/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import java.util.Date;

/**
 *
 * @author mbirc
 * 
 * Mitarbeiter class extends from Arbeiter
 * 
 */
public class Mitarbeiter extends Arbeiter{
    
    private int registrierteKunden; /**< registrierteKunden ist die Anzahl der Kunden, die von dem Mitarbeiter registriert worden sind*/
    private int abgemeldeteKunden; /**< abgemeldeteKunden ist die Anzahl der Kunden, die von dem Mitarbeiter abgemeldet worden sind*/
    private float erfolgsRate; /**< erfolgsRate gibt an, wie erfolgreich der Mitarbeiter ist (erfolgsRate = registrierteKunden/abgemeldeteKunden) */

    /**
     * 
     * @return erfolgsRate
     */
    public float getErfolgsRate() {
        return erfolgsRate;
    }

    /**
     * set Method fuer erfolgsRate
     * 
     * @param erfolgsRate 
     */
    public void setErfolgsRate(float erfolgsRate) {
        this.erfolgsRate = erfolgsRate;
    }

    /**
     * get Method fuer registrierteKunden
     * 
     * @return registrierteKunden
     */
    public int getRegistrierteKunden() {
        return registrierteKunden;
    }

    /**
     * set Method fuer registrierteKunden
     * 
     * @param registrierteKunden 
     */
    public void setRegistrierteKunden(int registrierteKunden) {
        this.registrierteKunden = registrierteKunden;
    }

    /**
     * get Method fuer abgemeldeteKunden
     * @return abgemeldeteKunden
     */
    public int getAbgemeldeteKunden() {
        return abgemeldeteKunden;
    }

    /**
     * set Method fuer abgemeldeteKunden
     * @param abgemeldeteKunden 
     */
    public void setAbgemeldeteKunden(int abgemeldeteKunden) {
        this.abgemeldeteKunden = abgemeldeteKunden;
    }
    
    /**
     * constructor fuer Mitarbeiter
     * @param n -- Mitarbeiter Name
     * @param ID -- Mitarbeiter BurgerID
     * @param anschr -- Mitarbeiter Anschrift
     * @param e -- Mitarbeiter email
     * @param telefon -- Mitarbeiter Telefonnummer
     * @param geburt -- Mitarbeiter Geburtsdatum
     * @param persID -- Mitarbeiter personalID
     * @param user -- Mitarbeiter Username
     * @param pass -- Mitarbeiter Passwort
     * @throws UngueltigeIDException -- wenn BurgerID des Mitarbeiters ungueltig ist 
     */
    public Mitarbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
    }

    /**
     * constructor fuer Mitarbeiter
     * @param n -- Mitarbeiter Name
     * @param ID -- Mitarbeiter BurgerID
     * @param anschr -- Mitarbeiter Anschrift
     * @param e -- Mitarbeiter email
     * @param telefon -- Mitarbeiter Telefonnummer
     * @param geburt -- Mitarbeiter Geburtsdatum
     * @param persID -- Mitarbeiter personalID
     * @param user -- Mitarbeiter Username
     * @param pass -- Mitarbeiter Passwort
     * @param erfolgsRate -- Mitarbeiter erfolgsRate
     * @throws UngueltigeIDException -- wenn BurgerID des Mitarbeiters ungueltig ist 
     */
    public Mitarbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass, float erfolgsRate) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
        this.erfolgsRate = erfolgsRate;
    }
    
}
