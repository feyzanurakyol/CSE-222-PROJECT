package OtherPersonnel;

public class doctor extends Personnel {

    public doctor(String name, String surname, int id){
        super(name,surname,id);
    }

    // doktor menüsü açılacak ve yapılacak işlemler belirlenecek
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

    //hastalar ile ilgilenecek
    private void patient(){ }
}
