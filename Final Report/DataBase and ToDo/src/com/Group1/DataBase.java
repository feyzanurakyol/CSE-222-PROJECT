package com.Group1;

import java.util.*;

/**
 * This class keeps all data regarding the system in an appropriate data structure.
 * It also operate the data.
 * It keeps data by using List,Queue and Binary Search Tree.
 * We wrote this class for reusable purpose, we will use this operations later.
 * */
public class DataBase {
    //updated data structures
    private List<DailyFoodMenu> menuList;
    private Map<Inmate, Set<Visitor>> visitorsMap;
    private PriorityQueue<ToDo> activeToDoQueue;
    private List<ToDo> passiveToDo; //Todos that was done before
    private Queue<HealthAppointment> healthAppointmentsQueue;
    private AVLTree<Inmate> prisonersTree;
    private SkipList<Personnel> allPersonnel;
    private ListGraph prison_structure; //it will change a generic graph
    public DataBase(){
        menuList = new LinkedList<> ();
        visitorsMap = new HashMap<> ();
        activeToDoQueue = new PriorityQueue<> ();
        passiveToDo = new ArrayList<> ();
        healthAppointmentsQueue = new LinkedList<> ();
        prisonersTree = new AVLTree<> ();
        allPersonnel = new SkipList<> ();
        prison_structure = new ListGraph (5,true);
    }
    public void addMenu(DailyFoodMenu menu){
        Date todaysDate = new Date();
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
        String date = df.format(todaysDate);
        if (menu.getDate ().compareTo (date) < 0){
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
    public void addVisitor(Inmate prisoner,Set<Visitor> visitorSet){
        visitorsMap.put (prisoner,visitorSet);
    }
    public Visitor deleteVisitor(Inmate prisoner,Visitor visitor){
        Collection<Set<Visitor>> values = visitorsMap.values ();
        for (Set<Visitor> visitorSet : values) {
            if (visitorSet.contains (visitor)){
                visitorSet.remove (visitor);
                return visitor;
            }
        }
        return null;
    }
    public Visitor getVisitorWithTC(String TC){
        Collection<Set<Visitor>> values = visitorsMap.values ();
        for (Set<Visitor> visitorSet : values) {
            for (Visitor visitor:visitorSet) {
                if (visitor.TCNumber.equals (TC)){
                    return visitor;
                }
            }
        }
        return null;
    }
    //no update for queue
    public void addToDoToTheTop(ToDo job){
        activeToDoQueue.offer (job);
    }
    public ToDo deleteToDoFromTop(ToDo job){
        if (activeToDoQueue.isEmpty ())
            return null;
        passiveToDo.add (activeToDoQueue.peek ());
        return activeToDoQueue.poll ();
    }
    public ToDo getToDoFromTop(){
        if (activeToDoQueue.isEmpty ())
            return null;
        return activeToDoQueue.peek ();
    }
    public int toDoSize(){
        return activeToDoQueue.size ();
    }

    /**
     * Returns true if the personnel has most importance job.
     * @param personnelId personnel id of personnel
     * @return true if the personnel has most importance job.
     */
    public boolean personnelTodo(int personnelId){
        if (!activeToDoQueue.isEmpty ()){
            if (activeToDoQueue.peek ().getOwnerID () == personnelId){
                return true;
            }
        }
        return false;
    }
    public void addUrgentTodo(ToDo urgentTodo){
        if (!activeToDoQueue.isEmpty ()){
            urgentTodo.setImportanceOrder (activeToDoQueue.peek ().getImportanceOrder ()-1);
        }
        activeToDoQueue.add (urgentTodo);
    }
    public void addHealthAppointmentToTheTop(HealthAppointment appointment){
        healthAppointmentsQueue.offer (appointment);
    }
    public HealthAppointment deleteHealthAppointmentFromTop(HealthAppointment appointment){
        if (healthAppointmentsQueue.isEmpty ())
            return null;
        return healthAppointmentsQueue.poll ();
    }
    public HealthAppointment getHealthAppointment(){
        if (healthAppointmentsQueue.isEmpty ())
            return null;
        return healthAppointmentsQueue.peek ();
    }
    public void addInmate(Inmate inmate){
        prisonersTree.add (inmate);
    }
    public Inmate deleteInmate(Inmate inmate ){
       return prisonersTree.delete (inmate);
    }
    public void updateInmate(Inmate oldInmate, Inmate newInmate){
        prisonersTree.delete (oldInmate);
        prisonersTree.add (newInmate);
    }
    public Inmate getInmate(int inmateID){
        return prisonersTree.find (new Inmate (inmateID));
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

    //------------Printing-----------------------------------------------------------------
    public void printAllData(){
        System.out.println ("***All Data is in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        printAllHealthAppointments ();
        printAllMenus ();
        printAllPersonnel ();
        printAllVisitor ();
        printAllActiveToDos ();
        printAllPrisoners ();
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllMenus(){
        System.out.println ("***All Menu in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (DailyFoodMenu menu:menuList) {
            System.out.println (menu);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();

    }
    public void printAllVisitor(){
        System.out.println ("***All Visitors in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        Set<Inmate> inmates = visitorsMap.keySet ();
        Collection<Set<Visitor>> values = visitorsMap.values ();
        Iterator<Set<Visitor>> iter =values.iterator ();
        int j=0;
        System.out.println ("Inmates and Visitors:");
        for (Inmate inmate:inmates) {
            System.out.printf("[%d] %s\n",j+1,inmate.getName ());
            System.out.println ("\tVisitors:");
            j++;
            if (iter.hasNext ()){
                Set<Visitor> visitorSet = iter.next ();
                int i=0;
                for (Visitor visitor:visitorSet) {
                    System.out.printf("\t[%d] %s\n",i+1,visitor.getName ());
                    i++;
                }
            }
            else{
                break;
            }

        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllActiveToDos(){
        System.out.println ("***All ToDos in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (ToDo toDo : activeToDoQueue) {
            System.out.println (toDo);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllHealthAppointments(){
        System.out.println ("***All Health Appointments in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (HealthAppointment appointment:healthAppointmentsQueue) {
            System.out.println (appointment);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPrisoners(){
        System.out.println ("***All Prisoners in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println (prisonersTree);
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPersonnel(){
        System.out.println ("***All Personnel in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println (allPersonnel);
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPassiveToDo(){
        System.out.println ("***All Personnel in the system");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println ("Passive ToDos");
        for (ToDo toDo:passiveToDo) {
            System.out.println (toDo);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printPrison(){
       //graph will printed
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
