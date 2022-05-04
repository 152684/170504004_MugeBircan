/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import databaseFunctions.InsertRecords;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mbirc
 */
public class InsertRecordsTest {
    public void test(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        
        System.out.println("-----------insertArbeiter überprüfen---------------");
        
        Scanner sc = new Scanner(System.in);
        Date geburt = null;
        System.out.println("Geben Sie den Geburtsdatum ein: ");
        String d = sc.nextLine();
        try{
            geburt = dateFormat.parse(d);        
        }catch(ParseException e){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            e.printStackTrace();
        }        

        java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
       
        InsertRecords r = new InsertRecords();

        r.insertArbeiter("muge", 170504, "maltepe", "email", 55537203, sqlDate, 45);
        //r.insertArbeiter("ayse", 170504, "kadikoy", "email", 55537203, sqlDate, 45);


        System.out.println("-----------insertChef überprüfen---------------");
        r.insertChef("ayse", 2000879, "kadikoy", "email2", 654987123, sqlDate, 96);
        
        System.out.println("-----------insertKunde überprüfen---------------");
        r.insertKunde("hasan", 2000879, "kadikoy", "email2", 654987123, sqlDate);
        
        System.out.println("-----------insertReiseLeiter überprüfen---------------");
        r.insertReiseLeiter("ali", 2000879, "kadikoy", "email2", 654987123, sqlDate);
        
        System.out.println("-----------insertHotel überprüfen---------------");
        r.insertHotel("antalyaHotel", "antalya", 15675342, "emailHotel", 150);
 
        System.out.println("-----------insertTour überprüfen---------------");
        r.insertTour("antalyaTour", sqlDate, "burada kalinacak, suraya gidilecek", 20, "antalyaHotel", 50, 20, "ali");
        
    }
    
}
