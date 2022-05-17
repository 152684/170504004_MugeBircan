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
    public static void test(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                
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

        //java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());
        
/*
        System.out.println("-----------insertMitarbeiter überprüfen---------------");
        InsertRecords.insertMitarbeiter("muge", 17050405001L, "maltepe", "email", 55537203, sqlDate, 45, "user1", "pass1");
        InsertRecords.insertMitarbeiter("ayse", 17050405002L, "kadikoy", "email", 55537203, sqlDate, 45, "user2", "pass2");
        InsertRecords.insertMitarbeiter("mehmet", 17050405003L, "bostanci", "email", 55537203, sqlDate, 45061, "user3", "pass3");
        InsertRecords.insertMitarbeiter("veli", 17050405004L, "uskudar", "email", 55537203, sqlDate, 45, "user4", "pass4");
        InsertRecords.insertMitarbeiter("veli2", 17050405005L, "beykoz", "email", 55537203, sqlDate, 45, "user8", "pass8");


        System.out.println("-----------insertChef überprüfen---------------");
        InsertRecords.insertChef("osman", 17050405006L, "kadikoy", "email2", 654987123, sqlDate, 96, "user5", "pass5");
        InsertRecords.insertChef("hasan", 17050405007L, "kadikoy", "email2", 654987123, sqlDate, 96, "user6", "pass6");
        InsertRecords.insertChef("nur", 17050400508L, "kadikoy", "email2", 654987123, sqlDate, 96, "user7", "pass7");
        InsertRecords.insertChef("nur2", 17050405009L, "kadikoy", "email2", 654987123, sqlDate, 96, "user9", "pass9");
        
        System.out.println("-----------insertKunde überprüfen---------------");
        InsertRecords.insertKunde("nurgul", 17050405010L, "kadikoy", "email2", 654987123, sqlDate);
        InsertRecords.insertKunde("nurgul2", 17050405011L, "kadikoy", "email2", 654987123, sqlDate);
        
        System.out.println("-----------insertReiseLeiter überprüfen---------------");
        InsertRecords.insertReiseLeiter("ali", 17050405012L, "kadikoy", "email2", 654987123, sqlDate);
        InsertRecords.insertReiseLeiter("ali", 17050405013L, "kadikoy", "email2", 654987123, sqlDate);
        
        System.out.println("-----------insertHotel überprüfen---------------");
        InsertRecords.insertHotel("antalyaHotel", "antalya", 15675342, "emailHotel", 150);
        InsertRecords.insertHotel("antalyaHotel2", "antalya", 15675342, "emailHotel", 150);
 
        System.out.println("-----------insertTour überprüfen---------------");
        InsertRecords.insertTour("antalyaTour", sqlDate, "burada kalinacak, suraya gidilecek", 20, "antalyaHotel", 50, 20, "ali");
        InsertRecords.insertTour("antalyaTour2", sqlDate, "orda burda surda", 20, "antalyaHotel", 50, 20, "ali");
*/ 
        System.out.println("-----------insertMitarbeiter überprüfen---------------");
        InsertRecords.insertMitarbeiter("muge", 17050405001L, "maltepe", "email", 55537203, geburt, 45, "user1", "pass1");
        InsertRecords.insertMitarbeiter("ayse", 17050405002L, "kadikoy", "email", 55537203, geburt, 45, "user2", "pass2");
        InsertRecords.insertMitarbeiter("mehmet", 17050405003L, "bostanci", "email", 55537203, geburt, 45061, "user3", "pass3");
        InsertRecords.insertMitarbeiter("veli", 17050405004L, "uskudar", "email", 55537203, geburt, 45, "user4", "pass4");
        InsertRecords.insertMitarbeiter("veli2", 17050405005L, "beykoz", "email", 55537203, geburt, 45, "user8", "pass8");


        System.out.println("-----------insertChef überprüfen---------------");
        InsertRecords.insertChef("osman", 17050405006L, "kadikoy", "email2", 654987123, geburt, 96, "user5", "pass5");
        InsertRecords.insertChef("hasan", 17050405007L, "kadikoy", "email2", 654987123, geburt, 96, "user6", "pass6");
        InsertRecords.insertChef("nur", 17050400508L, "kadikoy", "email2", 654987123, geburt, 96, "user7", "pass7");
        InsertRecords.insertChef("nur2", 17050405009L, "kadikoy", "email2", 654987123, geburt, 96, "user9", "pass9");
        
        System.out.println("-----------insertKunde überprüfen---------------");
        InsertRecords.insertKunde("nurgul", 17050405010L, "kadikoy", "email2", 654987123, geburt);
        InsertRecords.insertKunde("nurgul2", 17050405011L, "kadikoy", "email2", 654987123, geburt);
        
        System.out.println("-----------insertReiseLeiter überprüfen---------------");
        InsertRecords.insertReiseLeiter("ali", 17050405012L, "kadikoy", "email2", 654987123, geburt);
        InsertRecords.insertReiseLeiter("ali", 17050405013L, "kadikoy", "email2", 654987123, geburt);
        
        System.out.println("-----------insertHotel überprüfen---------------");
        InsertRecords.insertHotel("antalyaHotel", "antalya", 15675342, "emailHotel", 150);
        InsertRecords.insertHotel("antalyaHotel2", "antalya", 15675342, "emailHotel", 150);
 
        System.out.println("-----------insertTour überprüfen---------------");
        InsertRecords.insertTour("antalyaTour", geburt, "burada kalinacak, suraya gidilecek", 20, "antalyaHotel", 50, 20, "ali");
        InsertRecords.insertTour("antalyaTour2", geburt, "orda burda surda", 20, "antalyaHotel", 50, 20, "ali");
        
    }
    
}
