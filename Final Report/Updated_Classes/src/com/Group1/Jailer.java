
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
    public Jailer(String name, String surname, int id, String department, ArrayList<String> shiftHour){
        super(name, surname, id,JobType.Jailer,new HealthStatus());
        this.dp = department;
        this.shiftHours = shiftHour;
    }

    public Jailer(){
        super();
    }

    public Jailer(int id){
        super(null,null,id,JobType.Jailer,null);
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
        if(dataBase.prisoners.size() == numberOfPrisoners) return true;
        else return false;
    }

    @Override
    public void personnelInterface() {

    }

    /**
     * Get the prisoner object for further managing
     * @param id ID of the prisoner
     * @return Prisoner object
     */
    public Inmate getPrisoner(int id, DataBase dataBase)
    {
        return dataBase.prisoners.find(new Inmate(id));
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