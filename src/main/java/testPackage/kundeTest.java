/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import com.mycompany.inf202.Arbeiter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mbirc
 */
public class kundeTest {
    public void test(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        
        System.out.println("-----------setKunde und kundeAlphPrint Funktionen überprüfen---------------");
        
        Date d = null;
        Arbeiter a = new Arbeiter("muge", 170504, "maltepe", "email", 555372, d);
        a.setKunde();
        a.setKunde(); //muge id=2020
        a.setKunde();
        a.kundeAlphPrint();

        System.out.println("-----------deleteKunde Funktion überprüfen---------------");
        a.deleteKunde();
        a.kundeAlphPrint();
    }
}
