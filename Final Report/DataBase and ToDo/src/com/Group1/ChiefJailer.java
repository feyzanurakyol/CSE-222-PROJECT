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