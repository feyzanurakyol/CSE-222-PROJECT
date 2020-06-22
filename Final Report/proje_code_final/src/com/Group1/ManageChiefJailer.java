package com.Group1;

import java.util.Scanner;

public class ManageChiefJailer{
	
	/**Data fields*/
	private DataBase database;

	/**
	*Constructor one parameter is database 
	*@param base Database
	*/
	public ManageChiefJailer(DataBase base){
		this.database = base;
	}

	/**
	*Manage method to chief jailer, include many choices
	*@param cJailor Chief Jailor using which class
	*/
	public void manage(Personnel cJailor){
		int choice;
		do{
			showMenu(cJailor);
			choice = GetChoiceFromUser.getSubChoice(6, "Answer: ");
			if(choice == 1)
				addVisitor(); 
			else if(choice == 2)
				deleteVisitor ();
			else if(choice == 3)
				getVisitorWithTC();
			else if(choice == 4)
				displayVisitor();
			else if(choice == 5)
				manageJailerDP();
			else if(choice == 6)
				manageJailerSH();
		}while(choice != 0);
	}
	/**
    *Visitor informations is added to set, firstly, then take user
    inmate id, added database with inmate information.
    */
	public void addVisitor(){
		int k;
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter inmate id: ");
		int inmateNumber = scan.nextInt();
		Inmate inmate = database.getInmate (inmateNumber);
		if (inmate != null){
			System.out.println("Enter name: ");
			String name = scan.nextLine();
			System.out.println("Enter surname: ");
			String surname = scan.nextLine();
			System.out.println("Enter TC number: ");
			String tc = scan.nextLine();
			System.out.println("Enter telephone number of visitor: ");
			String telephone = scan.nextLine();
			System.out.println("Enter date: ");
			String date = scan.nextLine();
			System.out.println("Enter entrance time: ");
			String time = scan.nextLine();
			database.addOneVisitor (inmate,new Visitor (name,surname,tc,inmateNumber,telephone,date,time));
		}
		else{
			System.out.println ("Inmate was not found!");
		}


	}
	/**
    *Visitor informations is removed method, take user inmate id
    Check inmate id have or not, then decided remove or not.
    *@return Return type is Visitor, if have not deleted visitor, return null
    */
	public void deleteVisitor(){
		int k;
		Scanner scan = new Scanner (System.in);
		System.out.println("Enter inmate id: ");
		int inmateNumber = scan.nextInt();
		Inmate inmate = database.getInmate (inmateNumber);
		if (inmate != null){
			System.out.println("Enter TC number: ");
			String tc = scan.nextLine();
			Visitor visitor = database.getVisitorWithTC (inmate,tc);
			if (visitor!=null){
				database.deleteVisitor (inmate,visitor);
				System.out.println ("Visitor was removed!");
			}
			else
				System.out.println ("Visitor was not found!");

		}
		else{
			System.out.println ("Inmate was not found!");
		}
	}
	/**
    *Get visitor information, Visitor TC Number entering is method inside.
    *@return Return type is Visitor, if TC is not have, return null
    */
	public void getVisitorWithTC(){
		String visitorId = GetChoiceFromUser.getStringFromUser("Please Enter Visitor TC Number: ");
		Visitor getVisitor=database.getVisitorWithTC(visitorId);
		if (getVisitor==null)
			System.out.println ("Visitor was not found");
		else
			System.out.println (getVisitor);
	}
	/**Printing all visitor information*/
	public void displayVisitor(){
		database.printAllVisitor();
	}
	/**
	*Manage Jailer department 
	*@return String type
	*/
	public void manageJailerDP(){
		int id =GetChoiceFromUser.getNumber ("Enter Jailer id: ");
		Personnel personnel = database.getPersonnel (id);
		if (personnel!=null){
			String temp = GetChoiceFromUser.getStringFromUser ("Enter Block(A/B/B1): ");

		}

	}

	public void manageJailerSH()
    {
		int id =GetChoiceFromUser.getNumber ("Enter Jailer id: ");
		Personnel personnel = database.getPersonnel (id);
		if (personnel!=null){
			personnel.setShift (GovernorInterfaceInfo.getShiftInfo ());
			System.out.println ("Shifts was changed!");
		}
		else
			System.out.println ("Jailer was not found!");
    }
    /**
    *Private method showing chief jailer menu
    *@param chiefJailer Using class paramater
    */
    private void showMenu(Personnel chiefJailer){
    	int i,k;
    	for(i=0;i<45;i++) System.out.print("-");
    	System.out.print("\n"+"   ");
    	System.out.println("Welcome Chief Jailer " + chiefJailer.name + " " + chiefJailer.surname);
    	for(i=0;i<45;i++) System.out.print("-");
    	System.out.print("\n");
    	System.out.println("What do you want to do? ");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
    	System.out.println("[1] Add Visitor");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
    	System.out.println("[2] Delete Visitor");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
    	System.out.println("[3] Get Visitor With TC");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
    	System.out.println("[4] Display All Visitor");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
    	System.out.println("[5] Manage Jailer Department");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
    	System.out.println("[6] Manage Jailer Shift Hours");
		for ( k = 0; k < 45; k++) System.out.print("-");  System.out.println();
		System.out.println("[0] Exit.");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n");

    }
}

