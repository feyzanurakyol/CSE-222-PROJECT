package OtherPersonnel;

import java.util.LinkedList;

public abstract class Personnel {
    protected String name;
    protected String surname;
    protected int id;
    //mesai saati
    private shiftLinkedList shift;

    private static class shiftLinkedList{
        protected String day;
        protected String checkIn;
        protected String checkOut;
    }

    protected Personnel(String name, String surname, int id){
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    // işe giriş yaptığında kayıt et
    protected void checkInTime(){    }

    // işten çıkış saati
    protected void checkOutTime(){    }

    public abstract void personnelInterface();
}
