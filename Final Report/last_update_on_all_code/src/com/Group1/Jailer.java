package com.Group1;
import java.util.ArrayList;
/**
 * Jailer Class
 */
public class Jailer extends Personnel{
    private String dp;
    private ArrayList<String> shiftHours;
    /**
     * Constructor
     * @param name Name
     * @param surname Surname
     * @param id ID
     */
    public Jailer(String name, String surname,int id,HealthStatus healthStatus, String department, ArrayList<String> shiftHour){
        super(name,surname,JobType.Jailer,healthStatus);
        this.dp = department;
        this.shiftHours = shiftHour;
    }

    public Jailer(){
        super();
    }

    public Jailer(int id){
        super(null,null,JobType.Jailer,new HealthStatus());
    }
/*
    @Override
    public void personnelInterface() {
    }
*/
    /**
     * Checks if the count of the prisoners checks with the system census information
     * @param numberOfPrisoners counted prisoner number
     * @return true if count checks with the system, false if otherwise
     */
    public boolean checkCensus(int numberOfPrisoners, DataBase dataBase)
    {
        /*if(dataBase.pris.size() == numberOfPrisoners) return true;
        else return false;*/
        return true;
    }

    @Override
    public void personnelInterface(DataBase dataBase) {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Jailer " + name);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("What Do you want to do ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Get a prisoner");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Get your shift our");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Get your department");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Check census");
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
                //get prison
                break;

            case 2:
                System.out.println("Shift hours:" );
                for (int i = 0; i < getShiftHours().size() ; i++) {
                    System.out.println(getShiftHours().get(i));
                }
                break;

            case 3:
                System.out.println("Department:" + getDP());
                break;

            case 4:
                //check census part
            default:
                break;

        }
    }


    /**
     * Get the prisoner object for further managing
     * @param id ID of the prisoner
     * @return Prisoner object
     */
    public Inmate getPrisoner(int id, DataBase dataBase)
    {
        //return dataBase.prisoners.find(new Inmate(id));
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

    protected String getDP(){ return dp; }
    protected ArrayList<String> getShiftHours(){ return shiftHours; }
    protected void setDp(String newDP){ dp = newDP;}
    protected void setShiftHours(ArrayList<String> newShiftHours){ shiftHours = newShiftHours; }
}
