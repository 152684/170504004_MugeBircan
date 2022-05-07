/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.SelectRecords;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mbirc
 */
public class Login {
    private static ArrayList<Chef> chefs = new ArrayList();
    private static ArrayList<Mitarbeiter> mitarbeitern = new ArrayList();

    static public boolean loginRichtig(String user, String pass){
        System.out.println("userName: " + user + "  pass: " + pass);
        SelectRecords t = new SelectRecords();
        t.allMitarbeiterInArray(mitarbeitern);
        t.allChefInArray(chefs);
        
        Iterator<Mitarbeiter> iter = mitarbeitern.iterator();
        Iterator<Mitarbeiter> iter2 = mitarbeitern.iterator();
        Iterator<Chef> iterC = chefs.iterator();
        Iterator<Chef> iterC2 = chefs.iterator();

        boolean mitarbeiterEx = false;
        while(iter.hasNext()){
            System.out.println("mit while icerde");
            if(iter.next().getUserName().equals(user)){
                System.out.println("mit if1 icerde");
                if(iter2.next().getPasswort().equals(pass)){
                    System.out.println("mit if2 icerde");
                    mitarbeiterEx = true;
                    break;
                }else{
                    break;
                }
            }else{
                System.out.println("mit userName nicht gleich");
            }
            iter2.next();
        }
        boolean chefEx = false;
        while(iterC.hasNext()){
            System.out.println("chef while icerde");
            if(iterC.next().getUserName().equals(user)){
                System.out.println("chef if1 icerde");
                if(iterC2.next().getPasswort().equals(pass)){
                    System.out.println("chef if2 icerde");
                    chefEx = true;
                    break;
                }else{
                    break;
                }
            }else{
                System.out.println("chef userName nicht gleich");                
            }
            iterC2.next();
        }
        System.out.println("chef " + chefEx + "  mit " + mitarbeiterEx);
        return mitarbeiterEx || chefEx;
    
    }
    
}
