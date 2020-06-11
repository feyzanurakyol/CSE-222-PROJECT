package com.Group1;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
/**
Date objesi tarihi saatle ve dakika ile basıyor bu yuzden bu obje ile iş yaparken internetde date formatterlar
var stringe çevirmek için falan onları kullanın direk date kullanmayın bize zaman lazım değil çünkü sadece tarih.
Bu classı yazacak kişi dikkate alsın...
*/
public class DailyFoodMenu {
    //every food in the menu will be added to the list one by one.
    private ArrayList<String> menu;
    private Date date; //date is id of menu at that data there can be just one menu.
    public String getAllMenu () {
        return toString ();
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
        stringBuilder.append ("***Date: " +date+"***");
        stringBuilder.append ("\n");
        for (String s : menu) {
            stringBuilder.append (s);
            stringBuilder.append ("\n");
        }
       return stringBuilder.toString ();
    }
}
