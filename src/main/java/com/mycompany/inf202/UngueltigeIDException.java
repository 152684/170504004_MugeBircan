/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inf202;

/**
 *
 * @author mbirc
 */
public class UngueltigeIDException extends Exception{
    public UngueltigeIDException(){
        super("ID darf nur aus 11 numerische Ziffern bestehen.");
    }
    
}
