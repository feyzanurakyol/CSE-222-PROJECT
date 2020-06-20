import java.util.Scanner;

public abstract class Administrator {

	private String password;

	public Administrator (String pass) {
		password = pass;
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
			password = new_pass;
			System.out.print("Your new password has successfully set.\n");
		} else System.out.print("You Entered Wrong Password!\n");
	}

	/**
	 * Check that input matches the password
	 * @param input the input that will be compared with the password.
	 * @return true if the input is the same with the password.
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