import java.util.ArrayList;

public class ChiefJailer extends Personnel {

    public ChiefJailer(String name, String surname, int id){
        super(name, surname, id);
    }
    @Override
    public void personnelInterface() {
    }

    protected String manageJailerDP(int id, String department)
    {
        String temp = db.getJailer(id).getDp();
        db.getJailer(id).setDp(department);
        return temp;
    }

    protected ArrayList<String> manageJailerSH(int id, ArrayList<String> SH)
    {
        ArrayList<String> temp = db.getJailer(id).getShiftHours();
        db.getJailer(id).setShiftHours(SH);
        return temp;
    }

    protected void addVisitor(Visitor newVisitor)
    {
        db.visitors.push(newVisitor);
    }

    protected void removeVisitor()
    {
        db.visitors.pop();
    }

    protected void clearVisitors()
    {
        db.visitors.clear();
    }
}
