package com.Akif;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

public class DailyFoodMenu {
    //every food in the menu will be added to the list one by one.
    private ArrayList<String> menu;
    private Date date; //date is id of menu at that data there can be just one menu.
    public ArrayList<String> getAllMenu () {
        return menu;
    }

    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }

    public ArrayList<String> getMenu (Date date) {
        if (this.date.equals (date)){
            return menu;
        }
        else
            throw new NoSuchElementException ();
    }

    public void setAllMenu (ArrayList<String> menu) {
        this.menu = menu;
    }
    @Override
    public String toString () {
       StringBuilder stringBuilder = new StringBuilder ();
        for (String s : menu) {
            stringBuilder.append (s);
            stringBuilder.append ("\n");
        }
       return stringBuilder.toString ();
    }
}
