/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inf202;

import databaseFunctions.*;
import java.util.ArrayList;
import java.util.Iterator;
import testPackage.*;
/**
 *
 * @author mbirc
 */


public class Inf202 {
    
    private static ArrayList<Chef> chefs = new ArrayList();
    private static ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();

    
    public static void main(String[] args) {
        System.out.println("---------------INF202 Project------------- ");
        /*
        kundeTest t = new kundeTest();
        t.test();
        */
        /*
        InsertRecordsTest t = new InsertRecordsTest();
        t.test();
        */
        /*
        SelectRecordsTest t = new SelectRecordsTest();
        t.test();
        */
        /*
        SelectRecords t = new SelectRecords();
        t.allMitarbeiterInArray(mitarbeitern);
        t.allChefInArray(chefs);
        
        Iterator<Mitarbeiter> iter = mitarbeitern.iterator();
        Iterator<Chef> iterC = chefs.iterator();
        */
/*        
        while(iter.hasNext()){
                System.out.println("name:     " + iter.next().getName() + "\n" +
                                   "burgerID: " + iter.next().getBurgerID() + "\n"); 
                //schreibt alle Mitarbeitern nicht richtig auf, da mit iter.next() immer der nächste Mitarbeiter aufgerufen wird.
                //Hier ist das aber nicht wichtig, das wichtigste war zu verstehen, dass alles im ArrayList rictig geschrieben worden ist.
            
        }
        
        while(iterC.hasNext()){
                System.out.println("name:     " + iterC.next().getName() + "\n"); 
            
        }
*/
    
        UpdateRecordsTest t = new UpdateRecordsTest();
        t.test();
        
    }
}
