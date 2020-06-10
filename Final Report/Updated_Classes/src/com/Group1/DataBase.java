package com.Group1;

import java.util.Date;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * This class keeps all data regarding the system in a n appropriate data structure.
 * It also operate the data.
 * It keeps data by using List,Queue and Binary Search Tree.
 * We wrote this class for reusable purpose, we will use this operations later.
 * */
public class DataBase {
    private LinkedList<DailyFoodMenu> menuList;
    private Queue<Visitor> visitors;
    private PriorityQueue<ToDo> toDos; //todos has changed.
    private PriorityQueue<HealthAppointment> healthAppointments;
    BinarySearchTree<Inmate> prisoners;
    BinarySearchTree<Personnel> allPersonnel; //personnel can be changed as SkipList
    public DataBase(){
        menuList = new LinkedList<> ();
        visitors = new LinkedList<> ();
        toDos = new PriorityQueue<> ();
        healthAppointments = new PriorityQueue<> ();
        prisoners = new BinarySearchTree<> ();
        allPersonnel = new BinarySearchTree<> ();
    }
    public void addMenu(DailyFoodMenu menu){
        if (menu.getDate ().compareTo (new Date ())<=0){
            System.out.println ("Your date is less than now, Please use update option.");
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
    public void addVisitorToTheTop(Visitor visitor){
        visitors.offer (visitor);
    }
    
    /* Parametreye gerek yok poll yapmak için diye düşündüm.
    public Visitor deleteVisitorFromTop(Visitor visitor){
        if (visitors.isEmpty ())
            return null;
        return visitors.poll ();
    } */
    
    public Visitor deleteVisitorFromTop(){
        if (visitors.isEmpty ())
            return null;
        return visitors.poll ();
    }
    
    public Visitor getVisitorFromTop(){
        if (visitors.isEmpty ())
            return null;
        return visitors.peek ();
    }
    //no update for queue
    public void addToDoToTheTop(ToDo job){
        toDos.offer (job);
    }
    public ToDo deleteToDoFromTop(ToDo job){
        if (toDos.isEmpty ())
            return null;
        return toDos.poll ();
    }
    public ToDo getToDoFromTop(){
        if (toDos.isEmpty ())
            return null;
        return toDos.peek ();
    }
    public void addHealthAppointmentToTheTop(HealthAppointment appointment){
        healthAppointments.offer (appointment);
    }
    public HealthAppointment deleteHealthAppointmentFromTop(HealthAppointment appointment){
        if (toDos.isEmpty ())
            return null;
        return healthAppointments.poll ();
    }
    public HealthAppointment getHealthAppointment(){
        if (toDos.isEmpty ())
            return null;
        return healthAppointments.peek ();
    }
    public void addInmate(Inmate inmate){
        prisoners.add (inmate);
    }
    public Inmate deleteInmate(Inmate inmate ){
       return prisoners.delete (inmate);
    }
    public void updateInmate(Inmate oldInmate, Inmate newInmate){
        prisoners.delete (oldInmate);
        prisoners.add (newInmate);
    }
    public Inmate getInmate(int inmateID){
        return prisoners.find (new Inmate (inmateID));
    }
    public void addPersonnel(Personnel personnel){
        allPersonnel.add (personnel);
    }
    public Personnel deletePersonnel(Personnel personnel ){
        return allPersonnel.delete (personnel);
    }
    public void updatePersonnel(Personnel oldPersonnel, Personnel newPersonnel){
        allPersonnel.delete (oldPersonnel);
        allPersonnel.add (newPersonnel);
    }
    public Personnel getPersonnel(int personnelID){
        return allPersonnel.find (new Personnel (personnelID) );
    }
    public void printAllData(){
        System.out.println ("***All Data is in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        printAllHealthAppointments ();
        printAllMenus ();
        printAllPersonnel ();
        printAllVisitor ();
        printAllToDos ();
        printAllPrisoners ();
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllMenus(){
        System.out.println ("***All Menu in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        //print
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();

    }
    public void printAllVisitor(){
        System.out.println ("***All Visitors in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        //print
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllToDos(){
        System.out.println ("***All ToDos in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        //print
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllHealthAppointments(){
        System.out.println ("***All Health Appointments in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        //print
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPrisoners(){
        System.out.println ("***All Prisoners in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        //print
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPersonnel(){
        System.out.println ("***All Personnel in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        //print
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
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
