
import java.util.*;
import java.util.Scanner;


public class Visitor{
	/**Data fields*/
	protected String name;
	protected String surname;
	/*TCNumber yerine tcNumber yazıldı database classında 
	visitor.TCNumber yerine tcNumber yazılmalı*/
	protected String tcNumber;
	protected String inmateNumber;
	protected String telephoneNumber;
	protected String date;
	protected String entranceTime;
	protected String exitTime;


	/**Constructor eight parameters, includes name,surname,tcnumber,
	inmate number, telephone number, date, entrance time and exit time.
	*/
	public Visitor(String name,String surname,String tcNumber,String inmateNumber,String telephoneNumber,String date,String entranceTime,String exitTime){
		this.name = name;
		this.surname = surname;
		this.tcNumber = tcNumber;
		this.inmateNumber = inmateNumber;
		this.telephoneNumber = telephoneNumber;
		this.date = date;
		this.entranceTime = entranceTime;
		this.exitTime = null;	//now is null
	}
	/**Get visitor's name*/
	public String getName(){
		return name;
	}
	/**Get visitor's surname*/
	public String getSurname(){
		return surname;
	}
	/**Get visitor's TCNumber*/
	public String getTCNumber(){
		return tcNumber;
	}
	/**Get visitor's InmateNumber*/
	public String getInmateNumber(){
		return inmateNumber;
	}
	/**Get visitor's TelephoneNumber*/
	public String getTelephoneNumber(){
		return telephoneNumber;
	}
	/**Get visitor's Date*/
	public String getDate(){
		return date;
	}
	/**Get visitor's EntranceTime*/
	public String getEntranceTime(){
		return entranceTime;
	}
	/**Get visitor's ExitTime*/
	public String exitTime(){
		return exitTime;
	}
	/**Set visitor's name
	*@param name Visitor name
	*/
	public void setName(String name){
		this.name = name;
	}
	/**Set visitor's surname
	*@param surname Visitor surname
	*/
	public void setSurname(String surname){
		this.surname = surname;
	}
	/**Set visitor's TCNumber
	*@param tcNumber Visitor TCNumber
	*/
	public void setTCNumber(String tcNumber){
		this.tcNumber = tcNumber;
	}
	/**Set visitor's inmate number
	*@param inmateNumber Visitor inmateNumber
	*/
	public void setInmateNumber(String inmateNumber){
		this.inmateNumber = inmateNumber;
	}
	/**Set visitor's telephone number
	*@param telephoneNumber Visitor telephoneNumber
	*/
	public void setTelephoneNumber(String telephoneNumber){
		this.telephoneNumber = telephoneNumber;
	}
	/**Set visitor's date
	*@param date Visitor date
	*/
	public void setDate(String date){
		this.date = date;
	}
	/**Set visitor's entranceTime
	*@param entranceTime Visitor entranceTime
	*/
	public void setEntranceTime(String entranceTime){
		this.entranceTime = entranceTime;
	}
	/**Set visitor's entranceTime
	*@param exitTime Visitor entranceTime
	*/
	public void setExitTime(String exitTime){
		this.exitTime = exitTime;
	}
	/**
	*Visitor informations is added to set, firstly, then
	added database with inmate information.
	*@param base Database
	*@param mate Inmate info
	*/
	public void addVisitor(DataBase base,Inmate mate){
		Set<Visitor> setVisitor = new HashSet<>();
		setVisitor.add(this);
		base.addVisitor(mate,setVisitor);
	}
	/**
	*Visitor informations is removed method,
	call database method and delete it.
	*@param base Database
	*@param mate Inmate info
	*@return Return type is Visitor, if have not deleted visitor, return null
	*/
	public Visitor deleteVisitor(DataBase base, Inmate mate){
		Visitor removeVisitor;
		removeVisitor = base.deleteVisitor(mate,this);
		return removeVisitor;
	}
	/**
	*Get visitor information, Visitor TC Number entering is method inside.
	*@param base Database
	*@return Return type is Visitor, if TC is not have, return null
	*/
	public Visitor getVisitorWithTC(DataBase base){
		Scanner input = new Scanner(System.in);
		System.out.print("Please Enter Visitor TC Number: ");
		String number = input.nextLine();

		Visitor getVisitor;
		getVisitor = base.getVisitorWithTC(number);
		return getVisitor;
	}

}
