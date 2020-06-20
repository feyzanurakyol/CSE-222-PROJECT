package com.Group1;
import javax.xml.crypto.Data;
import java.util.Scanner;

public class Administrator {

	/**
	 * It's encrypted
	 */
	private String password;

	public Administrator (String pass) {
		password = Encryption.encryptPassword(pass);
	}

	/**
	 * Change the password with a new one.
	 * Check the old password before setting the new password.
	 */
	public void setPassword () {
		Scanner pass_scanner = new Scanner(System.in);
		String old_pass = null;
		String new_pass = null;

		System.out.print("Enter your old password\n");
		try {
			old_pass = pass_scanner.nextLine();
		}
		catch (Exception e) {
			System.out.print("Please enter a valid value!\n");
			pass_scanner.nextLine();
		}

		System.out.print("Enter your new password\n");
		try {
			new_pass = pass_scanner.nextLine();
		}
		catch (Exception e) {
			System.out.print("Please enter a valid value!\n");
			pass_scanner.nextLine();
		}

		if (checkPassword(old_pass) ) {
			password = Encryption.encryptPassword(new_pass);
			System.out.print("Your new password has successfully set.\n");
		} else System.out.print("You Entered Wrong Password!\n");
	}

	/**
	 * Check that input matches the password
	 * @param input the input that will be compared with the password.
	 * @return true if the input is the same with the password.
	 */
	public boolean checkPassword (String input) { return Encryption.decryptPassword(password).equals(input); }

	private boolean addGovernor (int id, String name, String surname, String password, DataBase db) {
		Personnel p = new Personnel(id, name, surname, password, JobType.Governor);
		return db.addPersonnel(p);
	}

	private boolean removeGovernor (int id, DataBase db) {
		Personnel p = db.getPersonnel(id);
		if (p.job == JobType.Governor) {
			db.deletePersonnel(db.getPersonnel(id));
			return true;
		}
		return false;
	}

	/*
		Appoint a new governor.
		There must be a governor every time
		so administrator cannot add or remove
		governor directly (Also there must be
		one governor at the same time).
		Other information about the governor
		can be found in the database using id.
	*/
	public void appointGovernor (DataBase db) {
		System.out.println("Enter the current Governor's id");
		int oldid = GetChoiceFromUser.getIDFromUser(db);

		String name = GetChoiceFromUser.getStringFromUser("Name: ");
		String surname = GetChoiceFromUser.getStringFromUser("Surname: ");
		int id = GetChoiceFromUser.getIDFromUser(db);
		String password = GetChoiceFromUser.getStringFromUser("Password: ");

		if ( removeGovernor(oldid, db) ) {
			addGovernor(id, name, surname, password, db);
		}
	}

}