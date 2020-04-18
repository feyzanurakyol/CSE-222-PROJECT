package OtherPersonnel;

import java.util.LinkedList;

public class cook extends Personnel {
    LinkedList<String> menu = new LinkedList<String>();

    public cook(String name, String surname, int id){
        super(name,surname,id);
    }

    // aşçının menüsü açılacak ve yapılacak işlemler belirlenecek
    // haftalık yemek menüsü
    // menüyü değiştirme
    @Override
    public void personnelInterface() {    }

    // işe giriş yaptığında kayıt et
    protected void checkInTime(){
        super.checkInTime();
    }

    //işten çıkış saati
    protected void checkOutTime(){
        super.checkOutTime();
    }

    //haftalık menü oluşturma
    private void menu(){    }

    //menü içeriği değiştirme
    private void changeMenu(){ }

}
