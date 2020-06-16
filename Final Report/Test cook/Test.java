import DataBase.*;
import OtherPersonnel.*;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        DataBase data = new DataBase();
        cook newcook = new cook("alper", "yasar");
        for (int i = 0; i < 12;i++){
            assignFood(data,i);
        }
        data.ListMenu();

        newcook.Interface();
        data.ListMenu();
    }
    public static void assignFood(DataBase data,int i){
        ArrayList<String> menu = new ArrayList<>();
        for (int j = 0; j < 4; j++) { menu.add(i + " - food - " + j); }
        DailyFoodMenu food = new DailyFoodMenu(menu,day(i), meal(i));
        data.addMenu(food);
    }
    static String day(int i){
        if (i>=0 && i < 3)
            return "Monday";
        else if (i>=3 && i < 6)
            return "Tuesday";
        else if (i>=6 && i < 9)
            return "Wednesday";
        else return "Thursday";
    }
    static String meal(int i){
        if (i%3 == 0)
            return "breakfast";
        else if (i%3 == 1)
            return "lunch";
        else
            return "dinner";
    }

}
