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
    private ReiseLeiter r;

    public Tour(String n, Date d, String info, int maxT, String hN, float p, ReiseLeiter rL)
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

    public Tour(String n, Date d, int maxT, String hN, float p, int freiP, ReiseLeiter rL)
    {
        tourName = n;
        tourDatum = d;
        maxTeilnehmer = maxT;
        hotelName = hN;
        preis = p;
        freiePlaetze = freiP;
        r = rL;        
    }
            
    public void tourUpdate(Date d, int maxT, String info, String hN, float p, ReiseLeiter rL){
        tourDatum = d;
        maxTeilnehmer = maxT;
        tourInfo = info;
        hotelName = hN;
        preis = p;
        r = rL;        
        
    }

    public String getName()
    {
        return tourName;
    }
    
    public void setDate(Date d)
    {
        tourDatum = d;
    }
    
    public void setInfo(String i)
    {
        tourInfo = i;
    }
    
    public void setMaxTeilnehmer(int m)
    {
        maxTeilnehmer = m;
    }

    public void setHotel(String h)
    {
        hotelName = h;
    }
    
    public void setPreis(float p)
    {
        preis = p;
    }
    
    public float getPreis(){
        return preis;
    }
    
    public void setFreiP(int f)
    {
        freiePlaetze = f;
    }
    
    public int getFreiP()
    {
        return freiePlaetze;
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
        
    
   
    public void setKunde(Kunde k)
    {
        if(freiePlaetze != 0){
            kunden.add(k);
            freiePlaetze--;
            System.out.println("Der Kunde " + k.toString() + "ist erfolgreich zu Tour " + this.toString() + " angemeldet worden.");
        }else{
            System.out.println("Der Kunde kann zu Tour nicht angemeldet werde, da der Tour voll ist!");
        }
        
    }
    
    public void deleteKunde(Kunde k)
    {
        
    }
    
}
