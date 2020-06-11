

public class Governor {
	private String name;
	private String surname;
	private String TCNumber;
	public Governor(String name, String surname, String TCNumber)
	{
		this.name = name;
		this.surname = surname;
		this.TCNumber = TCNumber;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public String getTCNumber()
	{
		return TCNumber;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
	public void setTCNumber(String TCNumber)
	{
		this.TCNumber = TCNumber;
	}
	//governor'ın yapacağı işlemler ayrı bir class'a alınabilir
	//governor için add daily to do seçeneği eklenicek ve yapılacak işleri sırasıyla giricek.
	public void addJailer(/*Jailer type object OR name, surname, TC, etc.*/)
	{
		
	}
	
	public void removeJailer(/*Jailer type object OR jailer informations */)
	{
		
	}
	
	public void addInmate(/*Inmate type object OR prisoner informations */)
	{
		
	}
	
	public void removeInmate(/* Inmate type object OR prisoner informations */)
	{
		
	}
	
	public void addPersonnel(/* Personnel type object OR prisoner informations */)
	{
		
	}
	
	public void removePersonnel(/* Personnel type object OR prisoner informations */)
	{
		
	}
	
	public void addVisitor(/* Visitor type object OR visitor informations*/)
	{
		
	}
	
	public void updateVisitorInformation(/* Visitor information */)
	{
		/* This method updated visitor's exit time. */
	}
}
