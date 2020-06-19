package com.Group1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class cook extends Personnel {
    LinkedList<String> menu = new LinkedList<String>();

     public cook(String name, String surname){
        super(1,name,surname,JobType.Cook,new HealthStatus ("deneme",0.0,0.0,0.0));
    }

    /**
     * Cook interface
     * Create new menu, delete menu, change menu,
     * delete all week.
     */
    /*
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
                        addMenu();
                        break;
                    case 2:
                        updateMenu();
                        break;
                    case 3:
                        deleteMenu();
                        break;
                    case 4:
                        DataBase.deleteAllMenu();
                        break;
                }

            }while (choose != 0);
        }
        else System.out.println("Wrong Password!");
    }*/

    /**
     * create new arraylist for enter meal.
     * enter day (monday, tuesday...)
     * After than create DailyFoodMenu with day and meals
     * add to linkedList in Database
     */
    private void addMenu(){
        ArrayList<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("enter day : ");
        String day = scan.nextLine();

        System.out.print("enter meal name (Breakfast, lunch or dinner : ");
        String meal = scan.nextLine();

        System.out.print("enter add food or [0] for back : ");
        String choice = scan.nextLine();
        while (!choice.equals("0")){
            menu.add(choice);
            System.out.print("enter add food or [0] for back : ");
            choice = scan.nextLine();
        }
        DailyFoodMenu newMenu = new DailyFoodMenu(menu,day,meal);
        DataBase.addMenu(newMenu);

    }

    /**
     * Delete menu specific day
     */
    private void deleteMenu(){
        ArrayList<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("enter day : ");
        String day = scan.nextLine();

        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Delete all day");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] delete just 1 meal press");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Back ");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.print( "Answer: ");
        int choice = scan.nextInt();
        if (choice == 1){
            if(DataBase.deleteMenu(day))
                System.out.println("Succesful!");
            else System.out.println("Failed!");
        }
        else if(choice == 2){
            System.out.print("enter meal name : ");
            scan.nextLine();
            String meal = scan.nextLine();

            if(DataBase.deleteMenu(day,meal))
                System.out.println("Succesful!");
            else System.out.println("Failed!");
        }
    }

    /**
     * update menu in specific day.
     * enter first which day wanted change and
     * enter new menu.
     */
    private void updateMenu(){
        ArrayList<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("enter day wanted to change : ");
        String day = scan.nextLine();

        System.out.print("enter meal name (Breakfast, lunch or dinner : ");
        String meal = scan.nextLine();

        System.out.print("enter add food or [0] for back : ");
        String choice = scan.nextLine();
        while (!choice.equals("0")){
            menu.add(choice);
            System.out.print("enter add food or [0] for back : ");
            choice = scan.nextLine();
        }
        DailyFoodMenu newMenu = new DailyFoodMenu(menu,day,meal);
        if(DataBase.updateMenu(day,meal,newMenu))
            System.out.println("Succesful!");
        else System.out.println("Failed!");


    }

    /**
     * show cook interface menu
     */
    private void showMenu() {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Cook Menu " + name);
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
        System.out.println("[3] Delete Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Delete All week");
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


}
