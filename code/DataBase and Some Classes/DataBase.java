package com.Akif;

import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DataBase {
    private LinkedList<DailyFoodMenu> menuList;
    private Queue<Visitor> visitors;
    private Queue<ToDo> toDos;
    private PriorityQueue<HealthAppointment> healthAppointments;
    BinarySearchTree<Inmate> prisoners;
    BinarySearchTree<Personnel> allPersonnel;
    private LinkedList<Jailer> jailers;
    private LinkedList<ChiefJailer> chiefJailers;
    
    public DataBase(){
        menuList = new LinkedList<> ();
        visitors = new LinkedList<> ();
        jailers = new LinkedList<> ();
        chiefJailers = new LinkedList<> ();
        toDos = new LinkedList<> ();
        healthAppointments = new PriorityQueue<> ();
        prisoners = new BinarySearchTree<> ();
        allPersonnel = new BinarySearchTree<> ();
        
    }
    public void addMenu(DailyFoodMenu menu){
        if (menu.getDate ().compareTo (new Date ())<=0){
            System.out.println ("Your date is less than please use update screen.");
        }
        else{
            menuList.add (menu);
        }
    }
    public boolean deleteMenu(DailyFoodMenu menu ){
        int index =findMenu (menu);
        if (index!=-1){
            menuList.remove (index);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean updateMenu(DailyFoodMenu oldMenu, DailyFoodMenu newMenu){
        int index =findMenu (oldMenu);
        if (index!=-1){
            menuList.set (index,newMenu);
            return true;
        }
        else {
            return false;
        }
    }
    public DailyFoodMenu getMenu(int index){
        if (index<0 || index>menuList.size ()-1)
            throw new ArrayIndexOutOfBoundsException();
        return menuList.get (index);
    }
    public void addVisitor(Visitor visitor){
        visitors.offer (visitor);
    }
    public Visitor deleteVisitor(Visitor visitor){
        if (visitors.isEmpty ())
            return null;
        return visitors.poll ();
    }
    public Visitor getVisitor(){
        if (visitors.isEmpty ())
            return null;
        return visitors.peek ();
    }
    //no update for queue
    public void addToDo(ToDo job){
    
    }
    public void deleteToDo(ToDo job){

    }
    public Visitor getToDo(){
        return null;
    }
    public void addHealthAppointment(HealthAppointment appointment){

    }
    public void deleteHealthAppointment(HealthAppointment appointment){

    }
    public Visitor getHealthAppointment(){
        return null;
    }
    public void addInmate(Inmate inmate){

    }
    public void deleteInmate(Inmate inmate ){

    }
    public void updateInmate(Inmate oldInmate, Inmate newInmate){

    }
    public Inmate getInmate(int inmateID){
        return null;
    }
    public void addPersonnel(Personnel inmate){

    }
    public void deletePersonnel(Personnel inmate ){

    }
    public void updatePersonnel(Personnel oldInmate, Personnel newInmate){

    }
    public Personnel getPersonnel(int personnelID){
        return null;
    }
    private int findMenu(DailyFoodMenu menu){
        for (int i=0;i<menuList.size ();i++){
            if (menuList.get (i).getDate ().compareTo (menu.getDate ())==0){
                return i;
            }
        }
        return -1;
    }

}
