package com.Group1;

import java.text.DateFormat;
import java.util.Date;

public class ManageJailer{

	/**Data fields*/
	private DataBase base;

	/**
	*Constructor one parameter is database 
	*@param base Database
	*/
	public ManageJailer(DataBase base){
		this.base = base;
	}

	/**
	*Manage method to chief jailer, include many choices
	*@param jailer using which class
	*/
	public void manage(Personnel jailer){
		int choice;
		do{
			showMenu(jailer);
			choice = GetChoiceFromUser.getSubChoice(5, "Answer: ");
			if(choice == 1)
				getLastCensus ();
			else if(choice == 2)
				addCensus ();
			else if(choice == 3)
				removeLastCensus ();
			else if(choice == 4)
				base.setAlert ();
			else if(choice == 5)
				base.undoAlert ();
		}while(choice != 0);
	}

	/**
	*Get inmate information by id, id take from user
	*If id is not avaliable,return null
	*@return Inmate 
	*/
	public void getLastCensus(){
		if (base.getLastInmateCensus ()!=null)
			System.out.println (base.getLastInmateCensus ());
		else
			System.out.println ("No Last Census");

	}
	public void addCensus(){
		int number = GetChoiceFromUser.getNumber ("Enter number of Inmate: ");
		base.addInmateCensus (number, DateFormat.getInstance().format(new Date ()));
		System.out.println ("Census info was Added with today's date.");
	}

	public void removeLastCensus(){
		base.deleteLastCensus ();
	}

	public void showMenu(Personnel jailer){
		int i,k;
    	for(i=0;i<45;i++) System.out.print("-");
    	System.out.print("\n"+"   ");
    	System.out.println("Welcome Jailer " + jailer.name + " " + jailer.surname);
    	for(i=0;i<45;i++) System.out.print("-");
    	System.out.print("\n");
    	System.out.println("What do you want to do? ");
    	for(i=0;i<45;i++) System.out.print("-"); System.out.print("\n");
		System.out.println("[1] Check Last census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[2] Add new Census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[3] Delete Last Census");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[4] Set Alert");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[5] Undo Alert");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n"+"   ");
		System.out.println("[0] Main Menu.");
		for ( k = 0; k < 45; k++) System.out.print("-");
		System.out.print("\n");
	}




}
