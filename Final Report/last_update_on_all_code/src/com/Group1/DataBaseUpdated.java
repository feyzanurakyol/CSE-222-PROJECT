package com.Group1;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * This class keeps all data regarding the system in an appropriate data structure.
 * It also operate the data.
 * It keeps data by using List,Queue and Binary Search Tree.
 * We wrote this class for reusable purpose, we will use this operations later.
 * */
public class DataBaseUpdated {
    //updated data structures
    private List<DailyFoodMenu> menuList ;
    private NavigableMap<Inmate, NavigableSet<Visitor>> visitorsMap;
    private PriorityQueue<ToDo> activeToDoQueue ;
    private List<ToDo> passiveToDo;//Todos that was done before
    private Queue<HealthAppointment> healthAppointmentsQueue ;
    private AVLTree<Inmate> prisonersTree ;
    private SkipList<Personnel> allPersonnel ;
    private ListGraph prison_structure; //it will change a generic graph
    private List<Jailer> jailerList ;
    private boolean fileFlag = false;
    private ReadAndWriteFile readAndWriteFile;
    public DataBase(){
        menuList = new LinkedList<> ();
        visitorsMap = new TreeMap<> ();
        activeToDoQueue = new PriorityQueue<> ();
        passiveToDo = new ArrayList<> ();
        healthAppointmentsQueue = new LinkedList<> ();
        prisonersTree = new AVLTree<> ();
        allPersonnel = new SkipList<> ();
        prison_structure = new ListGraph (5,true);
        jailerList = new ArrayList<> ();
        readAndWriteFile = new ReadAndWriteFile (this);
    }
    public void openFlag(){fileFlag=true;}
    public void closeFlag(){fileFlag=false;}
    /**
     * controlling menu with day matching. if they matched warning
     * to user. Else add to linkedList.
     * @param menu added menu.
     */
    public void addMenu(DailyFoodMenu menu){
        if (!menuList.isEmpty ()&&findMenu(menu.getDate(),menu.getMeal()) != -1)
            System.out.println("This day added before. Check Again!");

        else{
            menuList.add (menu);
            if (fileFlag)
                readAndWriteFile.writeFoodMenu (menu);
        }

    }

    /**
     * deleted menu from taking day
     * @param day wanted delete day
     * @return true if deleted
     */
    public boolean deleteMenu(String day){
        int index =findMenu (day);
        if (index!=-1){
            while (index != -1){
                menuList.remove (index);
                index =findMenu (day);
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * delete specific meal in a day
     * @param day day
     * @param meal name of meal
     * @return true if deleted
     */
    public boolean deleteMenu(String day,String meal){
        int index =findMenu (day,meal);
        if (index!=-1){
            menuList.remove (index);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * clear menu list
     */
    public void deleteAllMenu(){
        menuList.clear();
    }

    /**
     * update a meal
     * @param day day
     * @param meal meal name
     * @param newMenu new addeed menu
     * @return true if changed
     */
    public boolean updateMenu(String day,String meal,DailyFoodMenu newMenu){
        int index = findMenu (day,meal);
        if (index!=-1){
            menuList.set (index,newMenu);
            readAndWriteFile.updateFoodMenu (menuList.get (index),newMenu);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * get menu
     * @param index index
     * @return menu
     */
    public DailyFoodMenu getMenu(int index){
        if (index<0 || index>menuList.size ()-1)
            throw new ArrayIndexOutOfBoundsException();
        return menuList.get (index);
    }

    /**
     *
     * list menu in specific day
     * @param day food menu.
     * @param meal name of meal
     */
    public void ListMenu(String day,String meal){
        int index = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate()) && meal.equalsIgnoreCase(temp.getMeal())){
                System.out.println(temp.toString());
            }
        }
    }

    /**
     * find a menu in day
     * @param day day
     * @return index if true
     */
    private int findMenu(String day){
        int i = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate())){
                return i;
            }
            i++;
        }
        return -1;
    }
    public void ListMenu(){
        for (DailyFoodMenu temp : menuList){
            System.out.println(temp.toString());
        }
    }


    /**
     * find a meal in a day
     * @param day day
     * @param meal name of meal
     * @return index if true
     */
    private int findMenu(String day, String meal){
        int i = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate()) && meal.equalsIgnoreCase(temp.getMeal())){
                return i;
            }
            i++;
        }
        return -1;
    }
    public NavigableSet<Visitor> getVisitorSet(Inmate inmate){
        return visitorsMap.get (inmate);
    }
    public void setVisitorSet(Inmate inmate ,NavigableSet<Visitor> visitorSet,Visitor visitor){
        visitorsMap.replace (inmate,visitorSet);
    }
    public void addVisitor(Inmate prisoner,NavigableSet<Visitor> visitorSet){
        visitorsMap.put (prisoner,visitorSet);
    }
    public Visitor deleteVisitor(Inmate prisoner,Visitor visitor){
        Collection<NavigableSet<Visitor>> values = visitorsMap.values ();
        for (Set<Visitor> visitorSet : values) {
            if (visitorSet.contains (visitor)){
                visitorSet.remove (visitor);
                return visitor;
            }
        }
        return null;
    }
    public Visitor getVisitorWithTC(String TC){
        Collection<NavigableSet<Visitor>> values = visitorsMap.values ();
        for (Set<Visitor> visitorSet : values) {
            for (Visitor visitor:visitorSet) {
                if (visitor.tcNumber.equals (TC)){
                    return visitor;
                }
            }
        }
        return null;
    }
    //no update for queue
    public boolean addToDoToTheTop(ToDo job){
        if (fileFlag)
            readAndWriteFile.writeTodo (job);
        return activeToDoQueue.offer (job);
    }
    public ToDo deleteToDoFromTop(ToDo todo){
        if (activeToDoQueue.isEmpty ())
            return null;
        passiveToDo.add (activeToDoQueue.peek ());
        return activeToDoQueue.poll ();
    }
    
    // parametredeki todo eger toptaki elemanla ayni degilse null döndürür.
    public ToDo getToDoFromTop(ToDo job){
        if (activeToDoQueue.isEmpty ())
            return null;
        if(activeToDoQueue.peek().equals(job)) {
	        passiveToDo.add (activeToDoQueue.peek ());
	        return activeToDoQueue.poll ();
        }
        else {
        	return null;
        }
    }
    public int toDoSize(){
        return activeToDoQueue.size ();
    }
    
    public Personnel getPersonnel(int personnelID, String password){
        return allPersonnel.find (new Personnel (personnelID,password) );
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
    public boolean addUrgentTodo(ToDo urgentTodo){
        if (!activeToDoQueue.isEmpty ()){
            urgentTodo.setImportanceOrder (activeToDoQueue.peek ().getImportanceOrder ()-1);
        }
        readAndWriteFile.writeTodo (urgentTodo);
        return activeToDoQueue.add (urgentTodo);
    }
    public void addHealthAppointmentToTheTop(HealthAppointment appointment){
        healthAppointmentsQueue.offer (appointment);
        if (fileFlag)
            readAndWriteFile.writeHealthAppointments (appointment);
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
    public boolean addInmate(Inmate inmate){
        return prisonersTree.add (inmate);
    }
    public Inmate deleteInmate(Inmate inmate ){
       return prisonersTree.delete (inmate);
    }
    
    /* methodun typei voidten booleana cevrildi.*/
    public boolean updateInmate(Inmate oldInmate, Inmate newInmate){
        prisonersTree.delete (oldInmate);
        readAndWriteFile.updateInmate (oldInmate,newInmate);
        return prisonersTree.add (newInmate);
        
    }
    public Inmate getInmate(int inmateID){
        return prisonersTree.find (new Inmate (inmateID));
    }
    public boolean addPersonnel(Personnel personnel){
        if (fileFlag)
            readAndWriteFile.writePersonnel (personnel);
        return allPersonnel.add (personnel);

    }
    public Personnel deletePersonnel(Personnel personnel ){
        return allPersonnel.delete (personnel);
    }
    public boolean updatePersonnel(Personnel oldPersonnel, Personnel newPersonnel){
        allPersonnel.delete (oldPersonnel);
        readAndWriteFile.updatePersonnel (oldPersonnel,newPersonnel);
        return allPersonnel.add (newPersonnel);
    }
    public int numberOfPersonnel(){
        return allPersonnel.size ();
    }
    public boolean checkPassword(int ID,String pass){
      return allPersonnel.contains (new Personnel (ID,pass));
    }
    public void addJailer(Jailer jailer){
        jailerList.add (jailer);
        allPersonnel.add (jailer);
    }
    public void removeJailer(Jailer jailer){
        jailerList.remove (jailer);
        allPersonnel.remove (jailer);
    }
    public void removeJailerByID(int id){
        for (Jailer ja :jailerList) {
            if (ja.id==id){
                allPersonnel.remove (ja);
                jailerList.remove (ja);
            }

        }
    }
    public Jailer getJailer(int index){
        return jailerList.get (index);
    }
    public Jailer getJailerByID(int id){
        for (Jailer ja :jailerList) {
            if (ja.id==id)
                return ja;
        }
        return null;
    }
    public void updateJailer(Jailer oldJailer, Jailer newJailer){
        int i =0;
        for (Jailer ja :jailerList) {
            if (ja.id==oldJailer.id){
                jailerList.set (i,newJailer);
                updatePersonnel (oldJailer,newJailer);
            }
            i++;
        }
    }

    //------------Printing-----------------------------------------------------------------
    public void printAllData(){
        System.out.println ("***All Data is in the system***");
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
        Stack<DailyFoodMenu> dailyFoodMenuStack = new Stack<> ();
        System.out.println ("***All Menu in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (DailyFoodMenu menu:menuList) {
            dailyFoodMenuStack.push (menu);
        }
        while (!dailyFoodMenuStack.empty ())
            System.out.println (dailyFoodMenuStack.pop ());
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();

    }
    public void printAllVisitor(){
        System.out.println ("***All Visitors in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        Set<Inmate> inmates = visitorsMap.keySet ();
        Collection<NavigableSet<Visitor>> values = visitorsMap.values ();
        Iterator<NavigableSet<Visitor>> iter =values.iterator ();
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
        System.out.println ("***All ToDos in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (ToDo toDo : activeToDoQueue) {
            System.out.println (toDo);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllHealthAppointments(){
        System.out.println ("***All Health Appointments in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (HealthAppointment appointment:healthAppointmentsQueue) {
            System.out.println (appointment);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPrisoners(){
        System.out.println ("***All Prisoners in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println (prisonersTree);
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPersonnel(){
        System.out.println ("***All Personnel in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println (allPersonnel);
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPassiveToDo(){
        System.out.println ("***All Passive ToDos in the system***");
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

}
