package com.Group1;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Jailer Class
 */
public class Jailer extends Personnel{
    /**
     * This field will be used when we make operations.
     * */
    protected DataBase dataBase; //we will use it when we make operations


    public Jailer(){
        super(-1,"No info","No info","No info",JobType.Jailer);
    }

    public Jailer(DataBase data) {
        super(-1);
        dataBase = data;
    }

    /**
     *Get inmate information by id, id take from user
     *If id is not avaliable,return null
     *@return Inmate
     */
    public void getLastCensus(){
        if (dataBase.getLastInmateCensus ()!=null)
            System.out.println (dataBase.getLastInmateCensus ());
        else
            System.out.println ("No Last Census");

    }
    public void addCensus(){
        int number = GetChoiceFromUser.getNumber ("Enter number of Inmate: ");
        dataBase.addInmateCensus (number, DateFormat.getInstance().format(new Date()));
        System.out.println ("Census info was Added with today's date.");
    }

    public void removeLastCensus(){
        dataBase.deleteLastCensus ();
    }
    /**
     * Checks if the count of the prisoners checks with the system census information
     * @param numberOfPrisoners counted prisoner number
     * @return true if count checks with the system, false if otherwise
     */
    public boolean checkCensus(int numberOfPrisoners, DataBase dataBase)
    {
        /*if(dataBase.prisoners.size() == numberOfPrisoners) return true;
        else return false;*/
        return false;
    }

       public void showMenu(Personnel jailer) {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Jailer " + name);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("What Do you want to do ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Add a visitor");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Remove a visitor");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Clear all visitors");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Get a prisoner");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[5] Get your shift our");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[6] Get your department");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[7] Check census");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[8] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }

    public void manage(Personnel jailer){

        int choose;
        do {
            showMenu(jailer);
            choose = GetChoiceFromUser.getSubChoice(10, "Answer: ");

            switch (choose) {
                case 1:
                    addVisitor();
                    break;
                case 2:
                    removeVisitor();
                    break;

                case 3:
                    clearVisitors();
                    break;

                case 4:
                    getPrison();
                    break;

                case 5:
                    getShiftOur();
                    break;

                case 6:
                    System.out.println("Department:" + this.place.toString());
                    break;

                case 7:
                    getLastCensus(); //im not sure

                case 8:
                    dataBase.printLastMenu();
                    break;

                default:
                    break;

            }
        }while (choose != 0);
    }

    public void addVisitor(){
        int k;
        Scanner scan = new Scanner(System.in);
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter name: ");
        String name = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter surname: ");
        String surname = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter TC number: ");
        String tc = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter inmate id: ");
        int inmateNumber = scan.nextInt();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter telephone number of visitor: ");
        String telephone = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter date: ");
        String date = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter enterance time: ");
        String time = scan.nextLine();
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();

        addVisitor(new Visitor(name,surname,tc,inmateNumber,telephone,date,time),new Inmate(id),dataBase);
    }

    public void removeVisitor(){
        int k;
        Scanner scan = new Scanner(System.in);
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter Visitor's TC number: ");
        String tc = scan.nextLine();
        removeVisitor(tc,dataBase);
    }

    public void getPrison(){
        int k;
        Scanner scan = new Scanner(System.in);
        for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
        System.out.println("Enter ID of the prison: ");
        int id = scan.nextInt();
        System.out.println(dataBase.getPersonnel(id).toString());
    }

    public void getShiftOur(){
        int k;
        Scanner scan = new Scanner(System.in);
        System.out.println("Shift hours:" );
        for ( k = 0; k < 45; k++) System.out.print("-");

        for (int i = 0; i < this.shift.workdays.size(); i++) {
            System.out.println(this.shift.workdays.get(i));
        }
    }


    /**
     * If the alert is deactivated, activate
     * If the alert is active, deactivate
     */
  /*  public void declareAlert(){
        if(dataBase.getAlertState())
            db.setAlertState(false);
        else db.setAlertState(true);
    }*/


    protected void addVisitor(Visitor newVisitor,Inmate inmate, DataBase dataBase)
    {
        dataBase.addVisitor(inmate,dataBase.getVisitorSet(inmate));
    }

    protected void removeVisitor(String tc,DataBase dataBase)
    {
        dataBase.deleteVisitor(new Inmate(dataBase.getVisitorWithTC(tc).inmateNumber) ,dataBase.getVisitorWithTC(tc));
    }

    protected void clearVisitors()
    {
        dataBase.setVisitorSet(null,null,null);
    }
}


