package com.Group1;

import java.util.ArrayList;

public class GovernorInterfaceInfo {
	public static Personnel addJailerInfo(DataBase dataBase) {
    	int id = GetChoiceFromUser.getIDFromUser (dataBase);
    	String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
    	String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,Encryption.encryptPassword (password),JobType.Jailer,healthStatus,personnelShift,workPlace);
    }
    private static HealthStatus getHealthInfo(){
        String bloodGroup = GetChoiceFromUser.getStringFromUser ("Enter blood Group: ");
        String lastControlResult = GetChoiceFromUser.getStringFromUser ("Enter Last Control Result: ");
        double height = GetChoiceFromUser.getDouble ("Enter Height: ");
        double weight = GetChoiceFromUser.getDouble ("Enter weight: ");
        double pulse = GetChoiceFromUser.getDouble ("Enter pulse: ");
        return new HealthStatus (bloodGroup,lastControlResult,height,weight,pulse);
    }
    private static PersonnelShift getShiftInfo(){
        String shift = GetChoiceFromUser.getStringFromUser ("Enter Shift Time(daytime,evening,night): ");
        ArrayList<Days> arrayList = new ArrayList<> ();
        do {
            System.out.println ("Enter shift days(Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday) to back enter exit ");
            String day =GetChoiceFromUser.getStringFromUser ("Day: ");
            if (day.equals ("exit"))
                break;
            arrayList.add (Days.valueOf (day));

        }while(true);
        return new PersonnelShift(Shifts.valueOf (shift),arrayList);
    }
    private static WorkPlace place(){
	    String blok = GetChoiceFromUser.getStringFromUser ("Enter block: ");
	    int floor = GetChoiceFromUser.getSubChoice (1,"Enter Floor(0,1): ");
	    return new WorkPlace (new Block (blok),floor);
    }
    public static Personnel addChiefJailerInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
        String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,Encryption.encryptPassword (password),JobType.ChiefJailer,healthStatus,personnelShift,workPlace);
    }
    
    public static Personnel addCookInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
        String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,Encryption.encryptPassword (password),JobType.Cook,healthStatus,personnelShift,workPlace);
    }
    
    public static Personnel addDoctorInfo(DataBase dataBase) {
        int id = GetChoiceFromUser.getIDFromUser (dataBase);
        String name = GetChoiceFromUser.getStringFromUser ("Enter name: ");
        String surname=GetChoiceFromUser.getStringFromUser ("Enter Surname: ");
        String password =GetChoiceFromUser.getStringFromUser ("Enter Password: ");
        HealthStatus healthStatus= getHealthInfo ();
        PersonnelShift personnelShift= getShiftInfo ();
        WorkPlace workPlace = place ();
        return new Personnel (id,name,surname,Encryption.encryptPassword (password),JobType.Doctor,healthStatus,personnelShift,workPlace);
    }
    
    public static Inmate addInmateInfo(DataBase dataBase) {
    	return  null;

    }
}
