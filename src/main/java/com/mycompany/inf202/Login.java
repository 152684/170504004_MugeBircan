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

    static public long loginRichtig(String user, String pass){
        SelectRecords t = new SelectRecords();
        t.allMitarbeiterInArray(mitarbeitern);
        t.allChefInArray(chefs);
        
        Iterator<Mitarbeiter> iter = mitarbeitern.iterator();
        Iterator<Mitarbeiter> iter2 = mitarbeitern.iterator();
        Iterator<Mitarbeiter> iter3 = mitarbeitern.iterator();
        Iterator<Chef> iterC = chefs.iterator();
        Iterator<Chef> iterC2 = chefs.iterator();
        Iterator<Chef> iterC3 = chefs.iterator();

        boolean chefEx = false;
        boolean mitarbeiterEx = false;
        while(iterC.hasNext()){
            if(iterC.next().getUserName().equals(user)){
                if(iterC2.next().getPasswort().equals(pass)){
                    chefEx = true;
                    break;
                }else{
                    break;
                }
            }else{
            }
            iterC2.next();
            iterC3.next();
        }
        if(!chefEx){
            while(iter.hasNext()){
                if(iter.next().getUserName().equals(user)){
                    if(iter2.next().getPasswort().equals(pass)){
                        mitarbeiterEx = true;
                        break;
                    }else{
                        break;
                    }
                }else{
                }
                iter2.next();
                iter3.next();
            }
            if(mitarbeiterEx){
                return iter3.next().getBurgerID();
            }else{
                return 0;
            }
        }else{
            return iterC3.next().getBurgerID();
        }
            
    }
    
}
