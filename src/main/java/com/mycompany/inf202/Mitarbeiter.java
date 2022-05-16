/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

import databaseFunctions.UpdateRecords;
import java.util.Date;

/**
 *
 * @author mbirc
 */
public class Mitarbeiter extends Arbeiter{
    
    public Mitarbeiter(String n, String ID, String anschr, String e, int telefon, Date geburt, int persID, String user, String pass) {
        super(n, ID, anschr, e, telefon, geburt, persID, user, pass);
    }

    public void setLogin(){
        String pass = this.setPasswort();
        String user = this.setUserName();
        UpdateRecords.updateChefUserNameUndPass(user, pass, personalID);
    }
    
}
