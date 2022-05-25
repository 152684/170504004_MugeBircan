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
 */
public class Tour {
    
    private String tourName;
    private Date tourDatum;
    private String tourInfo;
    private int maxTeilnehmer = 0;
    private String hotelName;
    private float preis = 0;
    private ArrayList<Kunde> kunden = new ArrayList();
    private int freiePlaetze = 0;
    private String r;

    public Tour(String n, Date d, String info, int maxT, String hN, float p, String rL)
    {
        tourName = n;
        tourDatum = d;
        tourInfo = info;
        maxTeilnehmer = maxT;
        hotelName = hN;
        preis = p;
        freiePlaetze = maxT;
        r = rL;        
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public Date getTourDatum() {
        return tourDatum;
    }

    public void setTourDatum(Date tourDatum) {
        this.tourDatum = tourDatum;
    }

    public String getTourInfo() {
        return tourInfo;
    }

    public void setTourInfo(String tourInfo) {
        this.tourInfo = tourInfo;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(ArrayList<Kunde> kunden) {
        this.kunden = kunden;
    }

    public int getFreiePlaetze() {
        return freiePlaetze;
    }

    public void setFreiePlaetze(int freiePlaetze) {
        this.freiePlaetze = freiePlaetze;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }
    
    public int getMaxTeilnehmer(){
        return maxTeilnehmer;
    }
    
    public void setMaxTeilnehmer(int m){
        maxTeilnehmer = m;
    }

    public float getPreis(){
        return preis;
    }
    
    public void setPreis(int m){
        preis = m;
    }

    @Override public String toString()
    {
        return String.format("Tour:                     " + tourName + "\n" +
                             "tourDatum:                " + tourDatum + "\n" +
                             "maximale Teilnehmerzahl:  " + maxTeilnehmer + "\n" +
                             "freiePlaetze:             " + freiePlaetze + "\n" +
                             "Hotel:                    " + hotelName + "\n" +
                             "Reiseleiter:              " + r + "\n" +
                             "preis:                    " + preis );
    }
           
}
