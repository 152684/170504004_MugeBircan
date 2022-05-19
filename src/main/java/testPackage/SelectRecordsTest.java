/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testPackage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mycompany.inf202.*;
import com.mycompany.inf202.UngueltigeIDException;
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

    public static void test() throws UngueltigeIDException{
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
        
        System.out.println("-----------selectTourKunden überprüfen---------------");
        String s = SelectRecords.selectTourKunden("antalyaTour");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> in = gson.fromJson(s, type);  
        System.out.println("tourKunden2: "+ in);

        String s2 = SelectRecords.selectTourKunden("antalyaTour2");
        ArrayList<String> in2 = gson.fromJson(s2, type);  
        System.out.println("tourKunden2: "+ in2);
*/
/*
        System.out.println("-----------findMitarbeiter überprüfen---------------");
        Mitarbeiter m = SelectRecords.findMitarbeiter(17050405007L);
        System.out.println("der Name ist " + m.getName());

        System.out.println("-----------findChef überprüfen---------------");
        Chef c = SelectRecords.findChef(17050400508L);
        System.out.println("der Name ist " + c.getName());
*/
/* 
        System.out.println("-----------findKunde überprüfen---------------");
        Kunde k = SelectRecords.findKunde(17050405014L);
        System.out.println("der Name ist " + k.getName());

        System.out.println("-----------findReiseL überprüfen---------------");
        ReiseLeiter r = SelectRecords.findReiseL(17050405018L);
        System.out.println("der Name ist " + r.getName());
*/
        System.out.println("-----------findTour überprüfen---------------");
        Tour t = SelectRecords.findTour("antalyaTour");
        System.out.println("der Info ist " + t.getInfo());
        
    }

    
}
