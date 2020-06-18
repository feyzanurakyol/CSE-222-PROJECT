package com.Group1;
import java.util.ArrayList;
import java.util.Queue;

public class ChiefJailer extends Jailer {

    public ChiefJailer(String name, String surname, int id, String department, ArrayList<String> shiftHour){
        super(name,surname, id, department, shiftHour);
        job = JobType.ChiefJailer;
    }

    public ChiefJailer(){
        super();
    }

    public ChiefJailer(int id){
        this.id = id;
    }

    @Override
        public void personnelInterface() {
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
        System.out.println("[7] Set jailer's shift our.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[8] Manage jailer's department.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[9] Set your your shift our.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[10] Set your your department");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[11] Check census");
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
                String inmateNumber = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter telephone number of visitor: ");
                String telephone = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter date: ");
                String date = scan.nextLine();
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter enterance time: ");
                String time = scan.nextLine();

                addVisitor(new Visitor(name,surname,tc,inmateNumber,telephone,date,time),dataBase);

                break;
            case 2:
                removeVisitor(dataBase);
                break;
            case 3:
                clearVisitors(dataBase);
                break;
            case 4:
                for ( k = 0; k < 45; k++) System.out.print("-"); System.out.println();
                System.out.println("Enter ID of the prison: ");
                int id = scan.nextInt();
                System.out.println(dataBase.getInmate(id).toString());
                break;
            case 5:
                System.out.println("Shift hours:" );
                for (int i = 0; i < getShiftHours().size() ; i++) {
                    System.out.println(getShiftHours().get(i));
                }
                break;
            case 6:
                System.out.println("Department:" + getDP());
                break;

            default:
                break;

        }
    }

    protected String manageJailerDP(int id, String department, DataBase dataBase)
    {
        String temp = dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).getDP();
        dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).setDp(department);
        return temp;
    }

    protected ArrayList<String> manageJailerSH(int id, ArrayList<String> SH, DataBase dataBase)
    {
        ArrayList<String> temp = dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).getShiftHours();
        dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).setShiftHours(SH);
        return temp;
    }

    protected void addVisitor(Visitor newVisitor, DataBase dataBase)
    {
        dataBase.addVisitorToTheTop(newVisitor);
    }

    protected void removeVisitor(DataBase dataBase)
    {
        dataBase.deleteVisitorFromTop();
    }

    protected void clearVisitors(DataBase dataBase)
    {
        dataBase.getVisitors().clear();
    }
}
