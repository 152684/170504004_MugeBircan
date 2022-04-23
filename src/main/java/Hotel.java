/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mbirc
 */
public class Hotel {
    
    private String name;
    private String anschrift;
    private int telefonNummer;
    private String email;
    private float preis;
    
    public Hotel(String n, String ansch, int tel, String e, float p)
    {
        name = n;
        anschrift = ansch;
        telefonNummer = tel;
        email = e;
        preis = p;
    }
    
    public void updateInfo(String ansch, int tel, String e, float p)
    {
        anschrift = ansch;
        telefonNummer = tel;
        email = e;
        preis = p;        
    }
    
    public void printInfo()
    {
        
    }
}
