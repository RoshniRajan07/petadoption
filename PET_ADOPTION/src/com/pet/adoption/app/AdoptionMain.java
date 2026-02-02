package com.pet.adoption.app;

import com.pet.adoption.service.AdoptionService;
import java.sql.Date;
import java.util.Scanner;
public class AdoptionMain { 
    private static AdoptionService adoptionService; 
 
    public static void main(String[] args) { 
        adoptionService = new AdoptionService(); 
Scanner sc = new Scanner(System.in); 
System.out.println("--- Pet Adoption Console ---"); 
try { 
boolean r = adoptionService.adoptPet("PET1002","Karan Rao","karan.r@example.com",new Date(0)); 
System.out.println(r ? "ADOPTED" : "FAILED"); 
} catch(Exception e) { System.out.println(e); } 

try { 
boolean r = adoptionService.adoptPet("PET1001","Sonia Mehta","sonia.m@example.com",new Date(0)); 
System.out.println(r ? "ADOPTED" : "FAILED"); 
} catch(Exception e) { System.out.println(e); } 

try 
{ 
boolean r = adoptionService.cancelAdoption(160001, null); 
System.out.println(r ? "CANCELLED" : "FAILED"); 
} catch(Exception e) { System.out.println(e);
} 
sc.close(); 

} 
}




