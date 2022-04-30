/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import com.mycompany.inf202.Arbeiter;
import databaseFunctions.*;
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
        //Arbeiter a = new Arbeiter("muge", 17050402, "maltepe", "email", 55537203, d);
        
        InsertRecords r = new InsertRecords();
        r.insertArbeiter("muge", 17050402, "maltepe", "email", 55537203, d);
        System.out.println("erfolg");
        /*
        a.setKunde();
        a.setKunde(); //muge id=2020
        a.setKunde();
        a.kundeAlphPrint();

        System.out.println("-----------deleteKunde Funktion überprüfen---------------");
        a.deleteKunde();
        a.kundeAlphPrint();
        */
    }
}
