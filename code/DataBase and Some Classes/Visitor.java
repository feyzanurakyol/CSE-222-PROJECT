package com.Akif;
public class Visitor {
	String name;
	String surname;
	String TCNumber;
	String inmateNumber;
	String telephoneNumber;
	String date;
	String entrance_time;
	String exit_time;
	
	public Visitor(String name, String surname, String TCNumber, String inmateNumber, String telephoneNumber, String date, String entrance_time)
	{
		this.name = name;
		this.surname = surname;
		this.TCNumber = TCNumber;
		this.inmateNumber = inmateNumber;
		this.telephoneNumber = telephoneNumber;
		this.date = date;
		this.entrance_time = entrance_time;
		this.exit_time = null;
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
	
	public String getInmateNumber()
	{
		return inmateNumber;
	}
	
	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getEntranceTime()
	{
		return entrance_time;
	}
	
	public String getExitTime()
	{
		return exit_time;
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
	
	public void setInmadeName(String inmateNumber)
	{
		this.inmateNumber = inmateNumber;
	}
	
	public void setTelephoneNumner(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setEntranceTime(String entrance_time)
	{
		this.entrance_time = entrance_time;
	}
	
	public void setExitTime(String exit_time)
	{
		this.exit_time = exit_time;
	}
	
	
	
	
	
	
}
