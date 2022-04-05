
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mbirc
 */
public class Arbeiter extends Person{
    
    private int personalID;
    private String passwort;
    
    public Arbeiter(String n, int ID, String anschr, String e, int telefon, Date geburt) {
        super(n, ID, anschr, e, telefon, geburt);
    }
    
    public void setKunde(String n, int ID, String anschr, String e, int telefon, Date geburt)
    {
        
    }
    
    public void updateKundenIfno(String n, String anschr, String e, int telefon)
    {
        
    }
    
    public void deleteKunde(String n)
    {
        
    }
    
    public void kundeAlphPrint()
    {
        
    }
    
    public void printKunde(String n)
    {
        
    }
    
    public void printKunde(int id)
    {
        
    }
    
    public void kundeNachIDprint()
    {
        
    }
    
    public void setTour(String n, Date d, String info, String reiseL, int maxT, float preis, String hotel)
    {
        
    }
    
    public void updateTourReiseL(String tourName, String reiseL)
    {
        
    }
    
    public void updateTourDate(String tourName, Date d)
    {
        
    }
    
    public void updateTourInfo(String tourName, String info)
    {
        
    }

    public void updateTourMaxTeilnehmer(String tourName, int m)
    {
        
    }
    
    public void updateTourPreis(String tourName, float preis)
    {
        
    }

    public void deleteTour(String tourName)
    {
        
    }

    public void tourAlphPrint()
    {
        
    }

    public void tourPreisPrint()
    {
        
    }

    public void printTour(String tour)
    {
        
    }

    public void printTourKunden(String tour)
    {
        
    }

    public void tourSetHotel(String tour, String hotel)
    {
        
    }
    
    public void tourSetKunde(String tour, String kunde)
    {
        
    }
    
    public void tourDeleteKunde(String tour, String kunde)
    {
        
    }
    
    public void setHotel(String n, String ansch, int telefon, float preis)
    {
        
    }
    
    public void hotelAlphPrint()
    {
        
    }
    
    public void printHotel(String n)
    {
        
    }
    
    public void deleteHotel(String n)
    {
        
    }
    
    public void updateHotelInfo(String n, String ansch, int telefon, float preis)
    {
        
    }
    
    public void setReiseL(String n, int ID, String anschr, String e, int telefon, Date geburt)
    {
        
    }
    
    public void updateReiseLInfo(String n, String anschr, String e, int telefon)
    {
        
    }
    
    public void reiseLAlphPrint()
    {
        
    }
    
    public void printReiseL(String n)
    {
        
    }
    
    public void deleteReiseL(String n)
    {
        
    }
    
}
