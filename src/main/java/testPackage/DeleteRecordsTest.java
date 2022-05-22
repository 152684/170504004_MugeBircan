/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import com.mycompany.inf202.UngueltigeIDException;
import databaseFunctions.DeleteRecords;

/**
 *
 * @author mbirc
 */
public class DeleteRecordsTest {
    public static void test() throws UngueltigeIDException{
/* 
        System.out.println("-----------deleteMitarbeiter überprüfen---------------");
        DeleteRecords.deleteMitarbeiter(17050405005L);
        DeleteRecords.deleteMitarbeiter(17050405005L);

        System.out.println("-----------deleteChef überprüfen---------------");
        DeleteRecords.deleteChef(17050405006L);
        DeleteRecords.deleteChef(17050405006L);
        
        System.out.println("-----------deleteKunde überprüfen---------------");
        DeleteRecords.deleteKunde(17050405011L);
        DeleteRecords.deleteKunde(17050405011L);

        System.out.println("-----------deleteReiseL überprüfen---------------");
        DeleteRecords.deleteReiseL(17050405018L);
*/        //DeleteRecords.deleteReiseL(17050405013L); 
/*
        System.out.println("-----------deleteHotel überprüfen---------------");
        DeleteRecords.deleteHotel("fethiye");
        DeleteRecords.deleteHotel("antalyaHotel2");

        System.out.println("-----------deleteTour überprüfen---------------");
        DeleteRecords.deleteTour("fethiye");
        DeleteRecords.deleteTour("antalyaTour2");
*/

        System.out.println("-----------deleteKundeVonTour überprüfen---------------");
        DeleteRecords.deleteKundeVonTour("Tour Istanbul", "veli2");
        DeleteRecords.deleteKundeVonTour("Tour Istanbul", "veli");
        DeleteRecords.deleteKundeVonTour("Tour Istanbul", "veli3");
        DeleteRecords.deleteKundeVonTour("Tour Istanbul", "veli2");
        
    }
    
}
