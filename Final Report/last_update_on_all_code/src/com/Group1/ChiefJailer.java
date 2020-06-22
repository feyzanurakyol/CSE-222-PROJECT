package com.Group1;
import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Scanner;

public class ChiefJailer extends Jailer {

    public ChiefJailer(String name, String surname, int id, HealthStatus healthStatus,String department, ArrayList<String> shiftHour){
        super(name,surname,id,healthStatus,department,shiftHour);
        job = JobType.ChiefJailer;
    }

    public ChiefJailer(){
        super();
    }

    public ChiefJailer(int id){
        this.id = id;
    }

    //@Override
    public void personnelInterface(DataBase dataBase) {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Chief Jailer " + name);
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
        System.out.println("[3] Get a prisoner");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Get your shift our");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[5] Get your department");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[6] Set jailer's shift our.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[7] Manage jailer's department.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[8] Set your your shift our.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[9] Set your your department");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.print( "Answer: ");

        Scanner scan = new Scanner(System.in);
        int answer = scan.nextInt();


        switch (answer){
            case 1:
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
                System.out.println("Enter entrance time: ");
                String time = scan.nextLine();

                addVisitor(new Visitor(name,surname,tc,inmateNumber,telephone,date,time),dataBase.getVisitorSet(),dataBase);

                break;

            case 2:
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter name: ");
                name = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter surname: ");
                surname = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter TC number: ");
                tc = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter inmate id: ");
                inmateNumber = scan.nextInt();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter telephone number of visitor: ");
                telephone = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter date: ");
                date = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter entrance time: ");
                time = scan.nextLine();

                removeVisitor(,new Visitor(name,surname,tc,inmateNumber,telephone,date,time),dataBase);
                break;

            case 3:
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter ID of the prison: ");
                int id = scan.nextInt();
                System.out.println(dataBase.getJailerByID(id).toString());
                break;

            case 4:
                System.out.println("Shift hours:" );
                for (int i = 0; i < getShiftHours().size() ; i++) {
                    System.out.println(getShiftHours().get(i));
                }
                break;

            case 5:
                System.out.println("Department:" + getDP());
                break;

            case 6:
                String shiftTimes = "";
                ArrayList<String> newShiftHours = new ArrayList<String>();
                System.out.println("Enter the ID of the jailer:");
                int jailerID = scan.nextInt();
                do {
                    System.out.println("Enter the new shift ours: \n Enter - to end");
                    shiftTimes = scan.nextLine();
                    newShiftHours.add(shiftTimes);
                }while (!(shiftTimes.equals("-")));

                dataBase.getJailerByID(jailerID).setShiftHours(newShiftHours);

                break;

            case 7:
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter new department: ");
                String department = scan.nextLine();
                System.out.println("Enter the Jailer's id: ");
                int idPrison = scan.nextInt();
                dataBase.removeJailerByID(idPrison);
                break;

            case 8:
                shiftTimes = "";
                newShiftHours = new ArrayList<String>();
                do {
                    System.out.println("Enter the your new shift ours: \n Enter - to end");
                    shiftTimes = scan.nextLine();
                    newShiftHours.add(shiftTimes);
                }while (!(shiftTimes.equals("-")));
                this.setShiftHours(newShiftHours);
                break;

            case 9:
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter your new department: ");
                String departmentt = scan.nextLine();
                setDp(departmentt);
                break;

            default:
                break;

        }
    }

    protected String manageJailerDP(int id, String department, DataBase dataBase)
    {
        String oldDepartment = dataBase.getJailerByID(id).getDP();
        dataBase.getJailerByID(id).setDp(department);
        return oldDepartment;
    }

    protected ArrayList<String> manageJailerSH(int id, ArrayList<String> sh, DataBase dataBase)
    {
        ArrayList<String> oldSh = dataBase.getJailerByID(id).getShiftHours();
        dataBase.getJailerByID(id).setShiftHours(sh);
        return oldSh;
    }

    public void addVisitor(Inmate prisoner, NavigableSet<Visitor> visitorSet,DataBase dataBase){
        dataBase.addVisitor(prisoner,visitorSet);
    }

    protected void removeVisitor(Inmate prisoner,Visitor visitor,DataBase dataBase){
        dataBase.deleteVisitor(prisoner,visitor);
    }

}
