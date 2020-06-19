package com.Group1;
import java.util.ArrayList;
import java.util.Queue;

public class ChiefJailer extends Jailer {

    public ChiefJailer(String name, String surname, int id, String department, ArrayList<String> shiftHour){
        //super(-1,"No info","No info",JobType.Jailer,new HealthStatus ());
        job = JobType.ChiefJailer;
    }

    public ChiefJailer(){
        super();
    }

    public ChiefJailer(int id){
        this.id = id;
    }
/*
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
    }*/

    protected String manageJailerDP(int id, String department, DataBase dataBase)
    {
       /* String temp = dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).getDP();
        dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).setDp(department);
        return temp;*/
       return null;
    }

    protected ArrayList<String> manageJailerSH(int id, ArrayList<String> SH, DataBase dataBase)
    {
        /*ArrayList<String> temp = dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).getShiftHours();
        dataBase.getJailer().get(dataBase.getJailer().indexOf(new Jailer(id))).setShiftHours(SH);
        return temp;*/
        return null;
    }

    protected void addVisitor(Visitor newVisitor, DataBase dataBase)
    {
        //dataBase.addVisitorToTheTop(newVisitor);
    }

    protected void removeVisitor(DataBase dataBase)
    {
        //dataBase.deleteVisitorFromTop();
    }

    protected void clearVisitors(DataBase dataBase)
    {
        //dataBase.getVisitors().clear();
    }
}
