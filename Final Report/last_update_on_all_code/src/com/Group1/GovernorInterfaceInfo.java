package com.Group1;

import java.util.ArrayList;
import java.util.Scanner;

public class GovernorInterfaceInfo {
	public static Jailer addJailerInfo() {
    	int k = 0;
    	Scanner scan = new Scanner(System.in);
    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
    	 System.out.println("Enter name: ");
         String name = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter surname: ");
         String surname = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter available id: ");
         int id = scan.nextInt();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter department: ");
         String department = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter password: ");
         String password = scan.nextLine();
        

         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         ArrayList<String>shiftHours = new ArrayList<String>();
         System.out.println("Please enter shift hours : ");
         int i = 0;
         while(true) {
        	 System.out.println("Enter a shift hour, if if there is no shift hours, enter Q.");
        	 String shiftHour = scan.nextLine();
        
        	if(shiftHour.contentEquals("Q")) {
        		 break;
        	 }else {
        		shiftHours.add(shiftHour); 
        	 }
         }
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         /*düzeltilebilir*/
         return new Jailer(name,surname,id,password,department,shiftHours);
    }
    
    public static ChiefJailer addChiefJailerInfo() {
    	int k = 0;
    	Scanner scan = new Scanner(System.in);
    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
    	 System.out.println("Enter ChiefJailer name: ");
         String name = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter ChiefJailer surname: ");
         String surname = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter available id: ");
         int id = scan.nextInt();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter password: ");
         String password = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter department: ");
         String department = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         ArrayList<String>shiftHours = new ArrayList<String>();
         System.out.println("Please enter shift hours : ");
         int i = 0;
         while(true) {
        	 System.out.println("Enter " + i + ". shift hour, if if there is no shift hours, enter Q.");
        	 String shiftHour = scan.nextLine();
        	 if(shiftHour.contentEquals("Q")) {
        		 break;
        	 }else {
        		shiftHours.add(shiftHour); 
        	 }
         }
         //scan.close();
         for ( k = 0; k < 45; k++) System.out.print("-");
         /*düzeltilebilir*/
         return new ChiefJailer(name,surname,id,password,department,shiftHours);
    }
    
    public static cook addCookInfo() {
    	int k = 0;
    	Scanner scan = new Scanner(System.in);
    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
    	 System.out.println("Enter Cook name: ");
         String name = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter Cook surname: ");
         String surname = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter available id: ");
         int id = scan.nextInt();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter password: ");
         String password = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        // scan.close();
         /*düzeltilebilir*/
         return new cook(name,surname,id,password);
    }
    
    public static doctor addDoctorInfo() {
    	Scanner scan = new Scanner(System.in);
    	int k = 0;
    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
    	 System.out.println("Enter Doctor name: ");
         String name = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter Doctor surname: ");
         String surname = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter available id: ");
         int id = scan.nextInt();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         System.out.println("Enter password: ");
         String password = scan.nextLine();
         for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
         /*düzeltilebilir*/
         return new doctor(name,surname,id,password);
    }
    
    public static Inmate addInmateInfo() {
    	int k = 0;
    	Scanner scan = new Scanner(System.in);
    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
    	System.out.println("Enter name: ");
        String name = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter Crime type: ");
        String crimeType = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter available id: ");
        int id = scan.nextInt();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter remaining day: ");
        int remainingDay  = scan.nextInt();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter ward no: ");
        int wardNo  = scan.nextInt();
        
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Please enter health informations: ");
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter blood group: ");
        String bloodGroup = scan.next();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter height: ");
        int height = scan.nextInt();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter weight: ");
        int weight = scan.nextInt();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter pulse: ");
        int pulse = scan.nextInt();
        
        HealthStatus healthStatus = new HealthStatus(bloodGroup, height, weight, pulse);
        
        return new Inmate(id,name,crimeType,remainingDay,wardNo,healthStatus);
        
        
    
        
        return new Inmate(name,surnam,id,password);

    }
}
