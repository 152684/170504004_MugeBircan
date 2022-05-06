/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import databaseFunctions.UpdateRecords;

/**
 *
 * @author mbirc
 */
public class UpdateRecordsTest {
    public void test(){        
        UpdateRecords r = new UpdateRecords();

        //???? primaryKey not found hatasi verilmiyo. Islem yapildi gibi gozukuyor ama zapilmiyor
        
        System.out.println("-----------updateMitarbeiter überprüfen---------------");    
        r.updateMitarbeiter("turan", "mugla", "email4", 45, 170504005);
        r.updateMitarbeiter("ayse2", "kadikoy2", "email2", 45, 170504009);
        
        System.out.println("-----------updateChef überprüfen---------------");    
        r.updateChef("turan", "mugla", "email4", 45, 170504005);
        r.updateChef("turan", "mugla", "email4", 45, 170504006);
        
        System.out.println("-----------updateMitarbeiterUserNameUndPass überprüfen---------------");    
        r.updateMitarbeiterUserNameUndPass("userName1", "pass12345", 170504009);
        
        System.out.println("-----------updateChefUserNameUndPass überprüfen---------------");    
        r.updateChefUserNameUndPass("userName2", "pass123456", 170504006);

        System.out.println("-----------updateReiseL überprüfen---------------");    
        r.updateReiseL("veli", "mugla", "email4", 45, 170504008);

        System.out.println("-----------updateKunde überprüfen---------------");    
        r.updateKunde("hasan2", "mugla", "email4", 45, 170504007);

        System.out.println("-----------updateHotel überprüfen---------------");    
        r.updateHotel("antalyaHotel", "fethiye", "email4", 45, 160);

        
    }
}
