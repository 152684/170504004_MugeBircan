/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import databaseFunctions.UpdateRecords;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author mbirc
 */
public class UpdateRecordsTest {
    public static void test(){        
        //???? primaryKey not found hatasi verilmiyo. Islem yapildi gibi gozukuyor ama zapilmiyor
/*        
        System.out.println("-----------updateMitarbeiter überprüfen---------------");    
        UpdateRecords.updateMitarbeiter("turan", "mugla", "email4", 45, 170504005);
        UpdateRecords.updateMitarbeiter("ayse2", "kadikoy2", "email2", 45, 170504009);
        
        System.out.println("-----------updateChef überprüfen---------------");    
        UpdateRecords.updateChef("turan", "mugla", "email4", 45, 170504005);
        UpdateRecords.updateChef("turan", "mugla", "email4", 45, 170504006);
        
        System.out.println("-----------updateMitarbeiterUserNameUndPass überprüfen---------------");    
        UpdateRecords.updateMitarbeiterUserNameUndPass("userName1", "pass12345", 170504009);
        
        System.out.println("-----------updateChefUserNameUndPass überprüfen---------------");    
        UpdateRecords.updateChefUserNameUndPass("userName2", "pass123456", 170504006);

        System.out.println("-----------updateReiseL überprüfen---------------");    
        UpdateRecords.updateReiseL("veli", "mugla", "email4", 45, 170504008);

        System.out.println("-----------updateKunde überprüfen---------------");    
        UpdateRecords.updateKunde("hasan2", "mugla", "email4", 45, 170504007);

        System.out.println("-----------updateHotel überprüfen---------------");    
        UpdateRecords.updateHotel("antalyaHotel", "fethiye", "email4", 45, 160);
*/
        System.out.println("-----------updateTour überprüfen---------------");    
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date geburt = null;
        System.out.println("Geben Sie den Geburtsdatum ein: ");
        String d = sc.nextLine();
        try{
            geburt = dateFormat.parse(d);        
        }catch(ParseException ex){
            System.out.println("Der eingegebene Datum ist nicht gueltig.");
            ex.printStackTrace();
        }        

        java.sql.Date sqlDate = new java.sql.Date(geburt.getTime());

        UpdateRecords.updateTourInfo("antalyaTour", sqlDate, 25, "burasi orasi surasi", "fethiyeHotel", 410, "ayse");
    }
}
