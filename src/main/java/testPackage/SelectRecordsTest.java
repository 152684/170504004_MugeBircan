/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.inf202.Chef;
import com.mycompany.inf202.Mitarbeiter;
import databaseFunctions.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author mbirc
 */
public class SelectRecordsTest {

    private static ArrayList<Chef> chefs = new ArrayList();
    private static ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();

    public static void test(){
/*        
        System.out.println("-----------allMitarbeiterInArray überprüfen---------------");
        SelectRecords.allMitarbeiterInArray(mitarbeitern);
        Iterator<Mitarbeiter> iter = mitarbeitern.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next().getName());
        }
        
        System.out.println("-----------allChefInArray überprüfen---------------");
        SelectRecords.allChefInArray(chefs);
        Iterator<Chef> iterC = chefs.iterator();
        while(iterC.hasNext()){
            System.out.println(iterC.next().getName());
        }
*/        
        System.out.println("-----------selectTourKunden überprüfen---------------");
        String s = SelectRecords.selectTourKunden("antalyaTour");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> in = gson.fromJson(s, type);  
        System.out.println("tourKunden2: "+ in);

        String s2 = SelectRecords.selectTourKunden("antalyaTour2");
        ArrayList<String> in2 = gson.fromJson(s2, type);  
        System.out.println("tourKunden2: "+ in2);

    }

    
}
