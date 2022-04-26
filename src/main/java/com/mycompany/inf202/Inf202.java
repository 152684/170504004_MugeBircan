/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.inf202;

import static com.mycompany.inf202.Connect.connect;
import testPackage.*;
/**
 *
 * @author mbirc
 */
public class Inf202 {

    public static void main(String[] args) {
        System.out.println("---------------INF202 Project------------- ");
        connect(); 
        
        kundeTest t = new kundeTest();
        t.test();
        
        
    }
}
