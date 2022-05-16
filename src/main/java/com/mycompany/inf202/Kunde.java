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
public class Kunde extends Person{
    
    private ArrayList<Reise> reisen = new ArrayList();
    private String reisenString;
    
    public Kunde(String n, String ID, String anschr, String e, int telefon, Date geburt) {
        super(n, ID, anschr, e, telefon, geburt);
    }

    public Kunde(String n, String ID, String anschr, String e, int telefon, Date geburt, String reise) {
        super(n, ID, anschr, e, telefon, geburt);
        reisenString = reise;
    }
    
    public void setReise(Tour t, Hotel h)
    {
        
    }
    /*
    public Reise getReise(String n)
    {
        
    }
    */
    public void updateReise(String n)
    {
        
    }

/*    
    @Override public String toString()
    {
        
    }
*/

}
