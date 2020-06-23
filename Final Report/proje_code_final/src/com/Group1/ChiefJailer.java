package com.Group1;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class ChiefJailer extends Jailer {

    public ChiefJailer(String name, String surname, int id, String department, ArrayList<String> shiftHour) {
        //super(-1,"No info","No info",JobType.Jailer,new HealthStatus ());
        job = JobType.ChiefJailer;
    }

    public ChiefJailer(DataBase dataBase) {
        super(dataBase);
    }

    public ChiefJailer(int id) {
        this.id = id;
    }


    public void showMenu(Personnel chiefJailer) {
        int k;
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("Welcome Chief Jailer " + name);
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("What Do you want to do ?");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[1] Add a visitor");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[2] Remove a visitor");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[3] Clear all visitors");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[4] Get a prisoner");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[5] Get your shift our");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[6] Get your department");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[7] Set jailer's shift our.");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[8] Manage jailer's department (workplace).");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[9] Set your your shift our.");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[10] Set your your department");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[11] Check census");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[0] Main Menu.");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }

    public void manage(Personnel chiefJailer) {

        int choose;
        do {
            showMenu(chiefJailer);
            choose = GetChoiceFromUser.getSubChoice(10, "Answer: ");

            switch (choose) {
                case 1:
                    addVisitor();
                    break;

                case 2:
                    removeVisitor();
                    break;

                case 3:
                    clearVisitors();
                    break;

                case 4:
                    getPrison();
                    break;

                case 5:
                    getShiftOur();
                    break;

                case 6:
                    System.out.println("Department:" + this.place.toString());
                    break;
                case 7:
                    setJailerSH();
                    break;

                case 8:
                    setJailerDP();
                    break;

                case 9:
                    setYourSH();
                    break;

                case 10:
                    setYourDP();
                    break;

                case 11:
                    dataBase.printLastMenu();
                    break;

                default:
                    break;

            }
        }while (choose != 0);
    }

    public void setJailerSH(){
        Scanner scan = new Scanner(System.in);
        int k;
        String shiftTimes = "";
        ArrayList<Days> newShiftdays = new ArrayList<>();
        System.out.println("Enter the ID of the jailer:");
        int jailerID = scan.nextInt();

        do {
            System.out.println("Enter the new working days:");
            shiftTimes = scan.nextLine();

            switch (shiftTimes) {
                case "Monday":
                    newShiftdays.add(Days.Monday);
                    break;
                case "Tuesday":
                    newShiftdays.add(Days.Tuesday);
                    break;
                case "Wednesday":
                    newShiftdays.add(Days.Wednesday);
                    break;
                case "Thursday":
                    newShiftdays.add(Days.Thursday);
                    break;
                case "Friday":
                    newShiftdays.add(Days.Friday);
                    break;
                case "Saturday":
                    newShiftdays.add(Days.Saturday);
                    break;
                case "Sunday":
                    newShiftdays.add(Days.Sunday);
                    break;
                default:
                    System.out.println("Not a valid day! Enter again!");
            }

        } while (!(shiftTimes.equals("-")));

        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("Choose a shift time:");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[1] Daytime - 08.00 - 16.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[2] Evening - 16.00 - 00.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[3] Night - 00.00 - 08.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        Shifts shift = Shifts.daytime;
        int choose;
        do {
            choose = scan.nextInt();

            switch (choose) {
                case 1:
                    shift = Shifts.daytime;
                    break;
                case 2:
                    shift = Shifts.evening;
                    break;
                case 3:
                    shift = Shifts.night;
                    break;
                default:
                    System.out.println("Not a valid day! Enter again");
                    break;
            }
        } while (!(choose == 1 || choose == 2 || choose == 3));

        dataBase.getPersonnel(jailerID).setShift(new PersonnelShift(shift, newShiftdays));
    }

    public void setJailerDP(){
        Scanner scan = new Scanner(System.in);
        int k;
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.println();
        System.out.println("Enter new workplace's block: ");
        String blockName = scan.nextLine();
        Block block = new Block(blockName);

        System.out.println("Enter new workplace's floor: ");
        int floor = scan.nextInt();
        System.out.println("Enter the Jailer's id: ");
        int jailerId = scan.nextInt();
        dataBase.getPersonnel(jailerId).setPlace(new WorkPlace(block, floor));
    }

    public void setYourSH(){
        Scanner scan = new Scanner(System.in);
        int k;
        String shiftTimes = "";
        ArrayList<Days> newShiftdays = new ArrayList<>();
        do {
            System.out.println("Enter the new working days:");
            shiftTimes = scan.nextLine();

            switch (shiftTimes) {
                case "Monday":
                    newShiftdays.add(Days.Monday);
                    break;
                case "Tuesday":
                    newShiftdays.add(Days.Tuesday);
                    break;
                case "Wednesday":
                    newShiftdays.add(Days.Wednesday);
                    break;
                case "Thursday":
                    newShiftdays.add(Days.Thursday);
                    break;
                case "Friday":
                    newShiftdays.add(Days.Friday);
                    break;
                case "Saturday":
                    newShiftdays.add(Days.Saturday);
                    break;
                case "Sunday":
                    newShiftdays.add(Days.Sunday);
                    break;
                default:
                    System.out.println("Not a valid day! Enter again!");
            }

        } while (!(shiftTimes.equals("-")));

        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("Choose a shift time:");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[1] Daytime - 08.00 - 16.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[2] Evening - 16.00 - 00.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[3] Night - 00.00 - 08.00");
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        Shifts shift = Shifts.daytime;
        int choose = 0;
        do {
            choose = scan.nextInt();

            switch (choose) {
                case 1:
                    shift = Shifts.daytime;
                    break;
                case 2:
                    shift = Shifts.evening;
                    break;
                case 3:
                    shift = Shifts.night;
                    break;
                default:
                    System.out.println("Not a valid day! Enter again");
                    break;
            }
        } while (!(choose == 1 || choose == 2 || choose == 3));

        this.setShift(new PersonnelShift(shift, newShiftdays));
    }

    public void setYourDP(){
        Scanner scan = new Scanner(System.in);
        int k;
        for (k = 0; k < 45; k++) System.out.print("-");
        System.out.println();
        System.out.println("Enter your new workplace's block: ");
        String blockName = scan.nextLine();
        Block block = new Block(blockName);

        System.out.println("Enter your new workplace's floor: ");
        int floor = scan.nextInt();

        this.setPlace(new WorkPlace(block, floor));
    }

}
