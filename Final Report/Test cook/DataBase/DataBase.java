package DataBase;

import OtherPersonnel.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DataBase {

    private static List<DailyFoodMenu> menuList;
    private static Queue<HealthAppointment> healthAppointmentsQueue;
    private SkipList<Personnel> allPersonnel;
    private static AVLTree<Inmate> prisoners = new AVLTree<>();

    public DataBase(){
        menuList = new LinkedList<> ();
        healthAppointmentsQueue = new LinkedList<> ();
        allPersonnel = new SkipList<> ();
    }

    /**
     * controlling menu with day matching. if they matched warning
     * to user. Else add to linkedList.
     * @param menu added menu.
     */
    public static void addMenu(DailyFoodMenu menu){
        if (findMenu(menu.getDate(),menu.getMeal()) != -1)
            System.out.println("This day added before. Chech Again!");

        else
            menuList.add (menu);

    }

    /**
     * deleted menu from taking day
     * @param day wanted delete day
     * @return true if deleted
     */
    public static boolean deleteMenu(String day){
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
    public static boolean deleteMenu(String day,String meal){
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
    public static void deleteAllMenu(){
        menuList.clear();
    }

    /**
     * update a meal
     * @param day day
     * @param meal meal name
     * @param newMenu new addeed menu
     * @return true if changed
     */
    public static boolean updateMenu(String day,String meal,DailyFoodMenu newMenu){
        int index = findMenu (day,meal);
        if (index!=-1){
            menuList.set (index,newMenu);
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
    private static int findMenu(String day){
        int i = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate())){
                return i;
            }
            i++;
        }
        return -1;
    }
    public static void ListMenu(){
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
    private static int findMenu(String day, String meal){
        int i = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate()) && meal.equalsIgnoreCase(temp.getMeal())){
                return i;
            }
            i++;
        }
        return -1;
    }

    public static void addHealthAppointment(HealthAppointment appointment){
        healthAppointmentsQueue.add(appointment);
    }
    //SHOULD BE USED VERY REARLY!!!!
    public static void deleteHealthAppointment(HealthAppointment appointment){
        healthAppointmentsQueue.remove(appointment);
    }

    /**
     * doctor uses it
     * @return returns the next appointment doctor should go through
     */
    public static HealthAppointment deleteHealthAppointmentFromTop(){
        if(!healthAppointmentsQueue.isEmpty())
            return healthAppointmentsQueue.poll();
        else
            return null;
    }

    public static void addInmate(Inmate inmate){
        prisoners.add(inmate);
    }
    public static Inmate getInmateById(String inmate_id){
        return prisoners.find(new Inmate(inmate_id));
    }
    public void deletePersonnel(Personnel inmate ){

    }
    public void updatePersonnel(Personnel oldInmate, Personnel newInmate){

    }
    public Personnel getPersonnel(int personnelID){
        return null;
    }


}
