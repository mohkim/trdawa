/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.islamic.DawaPage.DawaPage;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author KEMAL
 */
public class sample {
    
    
    public static void main(String[] args) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      
      String  password="kim12";
         System.out.println(encoder.encode(password));
         
         if(encoder.matches("kim12", "$2a$10$WBBX3QvZFYaa7pOyGn4WlOuAWjPt8ny19nt/FMi0J0AR3OC70//Q2"))
             System.out.println("Bingo");
         
         else   System.out.println("testas");
      
    }
}
