/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inf202;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import databaseFunctions.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import testPackage.*;
/**
 *
 * @author mbirc
 * 
 * Main class wobei der TestMethoden gerufen wurde
 */


public class Inf202 {
    
    public static void main(String[] args) throws UngueltigeIDException {
        System.out.println("---------------INF202 Project------------- ");
       
       
        //InsertRecordsTest.test(); //nur richtige IDs sollen inserted werden.
        
        SelectRecordsTest.test(); // program abstürtz beim ungueltiegeIDException / auch wenn MitarbeiterID in Chef gesucht wird
        //UpdateRecordsTest.test();
        //DeleteRecordsTest.test();
        
    }
}
