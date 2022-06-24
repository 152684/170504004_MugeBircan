/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import userInterface.ToursTableController;
//import javafx.beans.property.StringProperty;
/**
 *
 * @author mbirc
 * 
 * Klasse Tour
 */
public class Tour {
    
    private String tourName; /**< Tour Name*/
    private Date tourDatum; /**< Tour Datum*/
    private String tourInfo; /**< Tour Info*/
    private int maxTeilnehmer = 0; /**< Tour maxiamle Teilnehmerzahl*/
    private String hotelName; /**< Name des Hotels, der waehrend des Tours uebernachtet wird*/
    private float preis = 0; /**< Tour Preis*/
    private String kunden; /**< KundenListe, die bei der Tour angemeldet sind*/
    private int freiePlaetze = 0; /**< Anzahl der freien Plaetze bei der Tour*/
    private String reiseL; /**< ReiseLeiter Name, der bei der Tour dabei wird*/

    /**
     * Konstructor fuer Tour
     * @param n -- Name
     * @param d -- Datum
     * @param info -- Info
     * @param maxT -- maximale Teilnehmerzahl
     * @param hN -- Hotel Nam<e
     * @param p -- Preis
     */
    public Tour(String n, Date d, String info, int maxT, String hN, float p)
    {
        tourName = n;
        tourDatum = d;
        tourInfo = info;
        maxTeilnehmer = maxT;
        hotelName = hN;
        preis = p;
        freiePlaetze = maxT;       
    }

    /**
     * Konstructor fuer Tour
     * @param n -- Name
     * @param d -- Datum
     * @param info -- Info
     * @param maxT -- maximale Teilnehmerzahl
     * @param hN -- Hotel Nam<e
     * @param p -- Preis
     * @param freieP -- freie Plaetze
     * @param rL -- reiseLEiter
     * @param kunde -- kunden
     */
    public Tour(String n, Date d, String info, int maxT, String hN, float p, int freieP, String rL, String kunde)
    {
        tourName = n;
        tourDatum = d;
        tourInfo = info;
        maxTeilnehmer = maxT;
        hotelName = hN;
        preis = p;
        freiePlaetze = freieP;
        reiseL = rL;        
        kunden = kunde;
    }
 
    /**
     * Konstructor fuer Tour
     * @param n -- Name
     * @param d -- Datum
     * @param info -- Info
     * @param maxT -- maximale Teilnehmerzahl
     * @param hN -- Hotel Nam<e
     * @param p -- Preis
     * @param freieP -- freie Plaetze
     */
    public Tour(String n, Date d, String info, int maxT, String hN, float p, int freieP)
    {
        tourName = n;
        tourDatum = d;
        tourInfo = info;
        maxTeilnehmer = maxT;
        hotelName = hN;
        preis = p;
        freiePlaetze = freieP;        
    }

    /**
     * get Methode fuer tourName
     * @return tourName
     */
    public String getTourName() {
        return tourName;
    }
    
    /**
     * setMethode fuer tourName
     * @param tourName 
     */
    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    /**
     * get Methode fuer tourDatum
     * @return tourDatum
     */
    public Date getTourDatum() {
        return tourDatum;
    }

    /**
     * setMethode fuer tourDatum
     * @param tourDatum 
     */
    public void setTourDatum(Date tourDatum) {
        this.tourDatum = tourDatum;
    }

    /**
     * get Methode fuer tourInfo
     * @return tourInfo
     */
    public String getTourInfo() {
        return tourInfo;
    }

    /**
     * setMethode fuer tourInfo
     * @param tourInfo 
     */
    public void setTourInfo(String tourInfo) {
        this.tourInfo = tourInfo;
    }

    /**
     * get Methode fuer hotelName
     * @return hotelName
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * setMethode fuer hotelName
     * @param hotelName 
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * get Methode fuer kunden
     * @return kunden
     */
    public String getKunden() {
        return kunden;
    }

    /**
     * setMethode fuer kunden
     * @param kunden 
     */
    public void setKunden(String kunden) {
        this.kunden = kunden;
    }

    /**
     * get Methode fuer freiePlaetze
     * @return freiePlaetze
     */
    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    /**
     * setMethode fuer freiePlaetze
     * @param freiePlaetze 
     */
    public void setFreiePlaetze(int freiePlaetze) {
        this.freiePlaetze = freiePlaetze;
    }

    /**
     * get Methode fuer reiseL
     * @return reiseL
     */
    public String getReiseL() {
        return reiseL;
    }

    /**
     * setMethode fuer reiseL
     * @param reiseL 
     */
    public void setReiseL(String r) {
        this.reiseL = r;
    }
    
    /**
     * get Methode fuer maxTeilnehmer
     * @return maxTeilnehmer
     */
    public int getMaxTeilnehmer(){
        return maxTeilnehmer;
    }
    
    /**
     * setMethode fuer maxTeilnehmer
     * @param m 
     */
    public void setMaxTeilnehmer(int m){
        maxTeilnehmer = m;
    }

    /**
     * get Methode fuer preis
     * @return preis
     */
    public float getPreis(){
        return preis;
    }
    
    /**
     *  set Methode fuer preis
     * @param m 
     */
    public void setPreis(int m){
        preis = m;
    }
          
}
