/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mbirc
 */

import java.util.ArrayList;
import java.util.Date;

public class Kunde extends Person{
    
    private ArrayList<Reise> reisen = new ArrayList();
    
    public Kunde(String n, int ID, String anschr, String e, int telefon, Date geburt) {
        super(n, ID, anschr, e, telefon, geburt);
    }
    
    public void setReise(Tour t, Hotel h)
    {
        
    }
    
    public Reise getReise(String n)
    {
        
    }
    
    public void updateReise(String n)
    {
        
    }

    
    @Override public String toString()
    {
        
    }


}
