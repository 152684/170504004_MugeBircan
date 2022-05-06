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
public class ReiseLeiter extends Person{
    
    private ArrayList<String> touren = new ArrayList();
    private int reiseAnzahl = 0;
    
    public ReiseLeiter(String n, int ID, String anschr, String e, int telefon, Date geburt) {
        super(n, ID, anschr, e, telefon, geburt);
    }
    
}
