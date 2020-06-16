package OtherPersonnel;

import java.util.Scanner;

public class doctor extends Personnel {

    public doctor(String name, String surname){
        super(name,surname,JobType.Doctor);
    }

    // doktor menüsü açılacak ve yapılacak işlemler belirlenecek
    @Override
    public void Interface() {
        Scanner scan = new Scanner(System.in);
        System.out.print("password : ");
        String password = scan.nextLine();  // Read user input
        if( checkPassword(password)){

            int choose;
            do {
                showMenu();
                choose = scan.nextInt();
                switch(choose) {
                    case 1:
                        // code block
                        break;
                    case 2:
                        // code block
                        break;
                }

            }while (choose != 0);
        }
        else System.out.println("Wrong Password!");
    }
    public void showMenu() {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Doctor Menu " + name);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("What Do you want to do ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Add Daily Food Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Change Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.print( "Answer: ");
    }

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
