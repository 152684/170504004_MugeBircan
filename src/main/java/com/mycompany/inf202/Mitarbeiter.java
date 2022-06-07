/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.UpdateRecords;
import java.util.Date;

/**
 *
 * @author mbirc
 */
public class Mitarbeiter extends Arbeiter{
    
    private int registrierteKunden;
    private int abgemeldeteKunden;
    private float erfolgsRate;

    public float getErfolgsRate() {
        return erfolgsRate;
    }

    public void setErfolgsRate(float erfolgsRate) {
        this.erfolgsRate = erfolgsRate;
    }

    public int getRegistrierteKunden() {
        return registrierteKunden;
    }

    public void setRegistrierteKunden(int registrierteKunden) {
        this.registrierteKunden = registrierteKunden;
    }

    public int getAbgemeldeteKunden() {
        return abgemeldeteKunden;
    }

    public void setAbgemeldeteKunden(int abgemeldeteKunden) {
        this.abgemeldeteKunden = abgemeldeteKunden;
    }
    
    
    public Mitarbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
    }

    public Mitarbeiter(String n, long ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass, float erfolgsRate) throws UngueltigeIDException{
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
        this.erfolgsRate = erfolgsRate;
    }
    
}
