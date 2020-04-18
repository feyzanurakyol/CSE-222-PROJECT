public abstract class Administrator {

	private String password;

	/*
		Change the password with a new one.
		Check the old password before setting the new password.
		Throw excpetion if there is a problem
		eg. Invalid password.
	*/
	public void setPassword (String new_pass);

	/*
		Check that input matches the password 
	*/
	public boolean checkPassword (String input);

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