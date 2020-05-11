import java.util.Scanner;

public abstract class Administrator {

	private String password;

	public Administrator (String pass) {
		if (isValid(pass) ) {
			password = pass;
		} else throw new Exception(); // this will be replaced with InvalidPasswordException
		// TO-DO: Implement InvalidPasswordException
	}

	/*
		Checks is the given password is valid.
		TO-DO:
		This method will be implemented when the
		conditions for password validity are defined.
	*/
	private boolean isValid (String password);

	/*
		Change the password with a new one.
		Check the old password before setting the new password.
		Throw excpetion if there is a problem
		eg. Invalid password.
	*/
	public void setPassword (String new_pass) {
		if (isValid(new_pass) ) {
			Scanner old_pass_scanner = new Scanner(System.in);
			String old_pass = old_pass_scanner.nextLine(); // this will be changed

			if (checkPassword(old_pass) ) {
				password = new_pass;
			} else throw new Exception(); // this will be replaced with WrongPasswordException
			// TO-DO: Implement WrongPasswordException
		} else throw new Exception(); // this will be replaced with InvalidPasswordException
	}

	/*
		Check that input matches the password 
	*/
	public boolean checkPassword (String input) { return password.equals(input); }

	private void addGovernor (int id);

	private void removeGovernor ();

	/*
		Appoint a new governor.
		There must be a governor every time
		so administrator cannot add or remove
		governor directly (Also there must be
		one governor at the same time).
		Other informations about governor
		can be found in the database using id.
	*/
	public void appointGovernor (int id);

}