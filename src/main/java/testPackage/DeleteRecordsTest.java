/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import databaseFunctions.DeleteRecords;

/**
 *
 * @author mbirc
 */
public class DeleteRecordsTest {
    public static void test(){
/* 
        System.out.println("-----------deleteMitarbeiter überprüfen---------------");
        DeleteRecords.deleteMitarbeiter(170504014);
        DeleteRecords.deleteMitarbeiter(170504007);

        System.out.println("-----------deleteChef überprüfen---------------");
        DeleteRecords.deleteChef(170504014);
        DeleteRecords.deleteChef(170504011);
        
        System.out.println("-----------deleteKunde überprüfen---------------");
        DeleteRecords.deleteKunde(170504014);
        DeleteRecords.deleteKunde(170504012);
*/
        System.out.println("-----------deleteReiseL überprüfen---------------");
        DeleteRecords.deleteReiseL(170504014);
        DeleteRecords.deleteReiseL(170504017); //fehler, reiseL mit der ID ex nicht
/*
        System.out.println("-----------deleteHotel überprüfen---------------");
        DeleteRecords.deleteHotel("fethiye");
        DeleteRecords.deleteHotel("antalyaHotel2");

        System.out.println("-----------deleteTour überprüfen---------------");
        DeleteRecords.deleteTour("fethiye");
        DeleteRecords.deleteTour("antalyaTour2");
*/        
    }
    
}
