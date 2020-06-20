
package com.Group1;

import java.util.ArrayList;
import java.util.Scanner;

public class Governor {
	
	protected String name;
    protected String surname;
    protected int id;
    protected JobType job;
    protected HealthStatus healthStatus;
    private String password;
	public Governor(String name, String surname, int id, HealthStatus healthStatus, String password)
	{
		this.name = name;
		this.surname = surname;
		this.id = id;
		this.job = JobType.Governor;
		this.healthStatus = healthStatus;
		this.password = password;
	}
	
	private boolean checkPassword(String password) {
		if(this.password.equals(password)) {
			return true;
		}
		return false;
	}
	
	
    public void Interface(DataBase database) {
        Scanner scan = new Scanner(System.in);
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Welcome to Governor screen.");
        for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
       
            int choose, choose1;
            do {
            	System.out.println("What do you want to do? ");
            	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
            	System.out.println("[1] Add a Personnel");
            	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
            	System.out.println("[2] Delete a Personnel"); 
            	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
            	System.out.println("[3] Update a Personnel");
            	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
            	System.out.println("[4] Add an Inmate");
            	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
            	System.out.println("[5] Remove an Inmate");
            	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
            	System.out.println("[6] Update an Inmate");
            	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            	System.out.println("[7] Add a daily to-do");
            	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            	System.out.println("[8] Remove a daily to-do");
            	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
            	System.out.println("Answer : ");
                choose = scan.nextInt();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                switch(choose) {
                    case 1:
                    	do {
	                    	 System.out.println("Please choose one: ");
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("[1] Add a Jailer");
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("[2] Add a ChiefJailer");
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("[3] Add a Cook");
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("[4] Add a Doctor");
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("[5] Add a Cleaner");
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("[6] Quit "); 
	                    	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                    	 System.out.println("Answer : ");
	                         choose1 = scan.nextInt();
	                         
	                         if(choose1 == 1) {
	                        	 database.addPersonnel(GovernorInterfaceInfo.addJailerInfo());
	                         }
	                         
	                         else if(choose1 == 2) {
	                             database.addPersonnel(GovernorInterfaceInfo.addChiefJailerInfo());   
	                         }
	                         else if(choose1 == 3) {
	                        	
	                             database.addPersonnel(GovernorInterfaceInfo.addCookInfo());
	                         }
	                         
	                         else if(choose1 == 4) {
	                             database.addPersonnel(GovernorInterfaceInfo.addDoctorInfo());
	                         }
	                         else if(choose1 == 5) {
	                        	 /* Cleaner class is empty */
	                         }
	                         else if(choose1 == 6) {
	                        	 break;
	                         }
	                         else { 
	                        	 for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
	                        	 System.out.println("Wrong choice. Please try again.");
	                         }
                    	} while(choose1 != 1 && choose1 != 2 && choose1 != 3 && choose1 != 4 && choose1 != 5 && choose1 != 6); 
                        break;
                    case 2:
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	System.out.println("Enter the id the personnel you want to delete: ");
                    	int id = scan.nextInt();
                    	System.out.println("Enter the password the personnel you want to delete: ");
                    	String password = scan.next();
                    	
                    	Personnel personnel = database.getPersonnel(id,password);
                    	
                    	removePersonnel(personnel,database);
                        break;
                    case 3:
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	System.out.println("Enter id of the personnel you want to update: ");
                    	int pid = scan.nextInt();
                    	System.out.println("Enter password of the personnel you want to update: ");
                    	String passwordd = scan.next();
                    	Personnel oldPersonnel = database.getPersonnel(pid,passwordd);
                    	JobType Job = oldPersonnel.job;
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	System.out.println("Enter the information of the personnel to be updated: ");
                    	if(Job.equals(Job.Jailer)) {
                    		Jailer jailer = GovernorInterfaceInfo.addJailerInfo();
                    		database.updatePersonnel(oldPersonnel, jailer);
                    	}
                    	else if(Job.equals(Job.ChiefJailer)) {
                    		ChiefJailer chiefjailer = GovernorInterfaceInfo.addChiefJailerInfo();
                    		database.updatePersonnel(oldPersonnel, chiefjailer);
                    	}
                    	else if(Job.equals(Job.Doctor)) {
                    		doctor doctor1 = GovernorInterfaceInfo.addDoctorInfo();
                    		database.updatePersonnel(oldPersonnel, doctor1);
                    	}
                    	else if(Job.equals(Job.Cook)) {
                    		cook cook1 = GovernorInterfaceInfo.addCookInfo();
                    		database.updatePersonnel(oldPersonnel, cook1);
                    	}
                    	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
                        break;
                    case 4:
                        addInmate(GovernorInterfaceInfo.addInmateInfo(),database);
                        break;
                    case 5: 
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	System.out.println("Enter the id the inmate you want to delete: ");
                    	int inmateID = scan.nextInt();
                    	
                    	Inmate inmate = database.getInmate(inmateID);
                    	removeInmate(inmate,database);
                    	
                    	break;
                    case 6:
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	System.out.println("Enter id of the inmate you want to update: ");
                    	int inmateid = scan.nextInt();
                    	Inmate oldInmate = database.getInmate(inmateid);
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	System.out.println("Enter the information of the personnel to be updated: ");
                    	Inmate newInmate = GovernorInterfaceInfo.addInmateInfo();
                    	
                    	updateInmate(oldInmate,newInmate,database);
                    	break;
                    case 7:
                    	for ( k = 0; k < 45; k++) System.out.print("-");   System.out.println();
                    	System.out.println("Enter the Job you want to add: ");
                    	String job = scan.nextLine();
                    	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
                    	System.out.println("If the Job is urgent, enter 1, if the job is not urgent, enter 0: ");
                    	int urgency = 0, counter = 0;
                    	while(counter < 3) {
                    		urgency = scan.nextInt();
                    		if(urgency != 1 && urgency != 0) {
                    			if(counter  == 2) {
                    				System.out.println("You have entered the option incorrectly 3 times. You are directed to the start screen.");
                    			}
                    			else {	
	                    			System.out.println("Please enter 1 or 2. " + urgency + " is not available. ");
	                    			counter++;
                    			}
                    		}
                    		else {
                    			break;
                    		}
                    	}
                    	for ( k = 0; k < 45; k++) System.out.print("-");
                    	System.out.println("Enter the id of the personnel you give a Job: ");
                    	int ID = scan.nextInt();
                    	for ( k = 0; k < 45; k++) System.out.print("-");
                    	ToDo todo = new ToDo(job, ID);
                    	
                    	add_daily_to_do(database, todo, urgency);
                    	for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                    	break;
                    case 8:
                    	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
                    	System.out.println("Enter the Job you want to delete: ");
                    	String job2 = scan.nextLine();
                    	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
                    	System.out.println("Enter the id of the personnel you delete a Job: "); 
                    	ID = scan.nextInt();
                    	for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
                    	// burada bir hata olabilir
                    	todo = new ToDo(job2, ID);
                    	remove_daily_to_do(database, todo);
                    	
                }

            }while (choose != 0);
       
    }
	
	//governor'ýn yapacaðý iþlemler ayrý bir class'a alýnabilir
	//governor için add daily to do seçeneði eklenicek ve yapýlacak iþleri sýrasýyla giricek.
    
    
    public Inmate addInmateForMenu() {
    	return null;
    }
	
    
    
    
	public void add_daily_to_do(DataBase database, ToDo todo, int urgency) {
		if(urgency == 0 && database.addToDoToTheTop(todo)) {
			System.out.println("This job has been added to the to-do. ");
		}
		else if(urgency == 1 && database.addUrgentTodo(todo)) {
			System.out.println("This urgent job has  been added to the to-do. ");
		}
	}
	
	public void remove_daily_to_do(DataBase database, ToDo todo) {
		if(database.deleteToDoFromTop(todo) != null) {
			System.out.println("This job has been deleted from the to-do.");
		}
		else {
			System.out.println("This job could not be deleted from to-do. Please check informations and try again.");
		}
	}
	
	public void addInmate(Inmate inmate, DataBase database){
		if(database.addInmate(inmate)) {
			System.out.println("This Inmate is successfully added to the system.");
		}
		else {
			System.out.println("This Inmate already added in System.");
		}
	}
	
	public void removeInmate(Inmate inmate, DataBase database)
	{
		if(database.deleteInmate(inmate) == null) {
    		System.out.println("This Inmate could not be deleted to the system. Please check informations and try again.");
    	}
    	else {
    		System.out.println("This Inmate is successfully deleted to the system.");
    	}
	}
	
	public void updateInmate(Inmate oldInmate, Inmate newInmate, DataBase database) {
		if(database.updateInmate(oldInmate, newInmate)) {
			System.out.println("This inmate has been successfully updated.");
		}
		else {
			System.out.println("This inmate could not be updated. Please check the informations.");
		}
	}
	
	
	public void addPersonnel(Personnel personnel, DataBase database){
		//boolean add = database.addPersonnel(personnel);
		if( database.addPersonnel(personnel)) {
			System.out.println("This " + personnel.job + " is successfully added to the system.");
    	}
    	else {
    		System.out.println("This " + personnel.job +  " already added in System.");
    	}
	}
	
	public void removePersonnel(Personnel personnel, DataBase database){
    	if(database.deletePersonnel(personnel) == null) {
    		System.out.println("This " + personnel.job + " could not be deleted to the system. Please check informations and try again.");
    	}
    	else {
    		System.out.println("This " + personnel.job + " is successfully deleted to the system.");
    	}
	}
	
	public void updatePersonnel(Personnel oldPersonnel, Personnel newPersonnel, DataBase database) {
		if(database.updatePersonnel(oldPersonnel, newPersonnel)) {
			System.out.println("This personnel has been successfully updated.");
		}
		else {
			System.out.println("This personnel could not be updated. Please check the informations.");
		}
	}
	
	
	
	
}
