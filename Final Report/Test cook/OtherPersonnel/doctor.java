package OtherPersonnel;

import DataBase.DataBase;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Personnel {
    // it is for hold the patient in room. if doctor accept new patient
    // add to array list . if we do queue we cannt to reach patient when we
    // want heal it.
    private ArrayList<HealthAppointment> patient;

    private static int BED_CAPACITY = 100;
    /**
     * two parameter consturctor(other personnel)
     * @param name doctor's name
     * @param surname doctor's surname
     */
    public Doctor(String name, String surname){
        super(name,surname,JobType.Doctor);
        patient = new ArrayList<>();
    }
    // doktor menüsü açılacak ve yapılacak işlemler belirlenecek
    @Override
    public void Interface() {
        HealthAppointment current_ha = null;
        Scanner scan = new Scanner(System.in);
        System.out.print("password : ");
        String password = scan.nextLine();  // Read user input

        if( checkPassword(password)){
            int bedNumber = -1;
            int choose=-1;
            while(choose!=0) {
                //CHOOSING PATIENT
                do {
                    System.out.println("Welcome doctor: " + name);
                    System.out.println("[1]Take patient from the prison's hospital");
                    System.out.println("[2]Get next appointment");
                    System.out.println("[0] Main menu");
                    choose = Integer.parseInt(scan.nextLine());
                    switch (choose) {
                        case 1:
                            if (patient.isEmpty()) {
                                System.out.println("No one currently at prison's hospital");
                                choose = -1;//go back since there are no patients in the prison's hospital
                            } else {
                                System.out.println("Bed's filled:");
                                System.out.print("---");
                                for (int i = 0; i < patient.size(); ++i)
                                    System.out.print((i+1) + "---");
                                System.out.println();
                                System.out.println("Enter patient's bed number ( enter any other number to go back )");
                                bedNumber = Integer.parseInt(scan.nextLine());
                                if (bedNumber >= 1 && bedNumber <= patient.size())
                                    current_ha = patient.get(bedNumber-1);
                                else
                                    choose = -1;//go again
                            }
                            break;
                        case 2:
                            current_ha = DataBase.deleteHealthAppointmentFromTop();
                            if (current_ha == null) {
                                System.out.println("No new health appointments");
                                choose = -1;//make it go back since there is no patients
                            }
                            break;
                        case 0:
                            System.out.println("Going back to main menu");
                    }
                } while (choose != 0 && choose != 1 && choose != 2);
                // AFTER PATIENT IS CHOOSEN DO THE EXAMINATION
                while (choose != 0 && choose != 13) {
                    showMenuPatient();
                    choose = Integer.parseInt(scan.nextLine());
                    switch (choose) {
                        case 0:
                            System.out.println("Going back to main menu...");
                            break;
                        case 1:
                            System.out.println("Inamte's blood group is: " + current_ha.getHealthStatus().getBloodGroup());
                            break;
                        case 2:
                            System.out.println("Enter new blood group: ");
                            current_ha.getHealthStatus().setBloodGroup(scan.nextLine());
                            break;
                        case 3:
                            System.out.println("Last control's results: ");
                            System.out.println(current_ha.getHealthStatus().getLastControlResult());
                            break;
                        case 4:
                            System.out.println("Enter new control's result");
                            current_ha.getHealthStatus().setLastControlResult(scan.nextLine());
                            break;
                        case 5:
                            System.out.println("Inamte's height: " + current_ha.getHealthStatus().getHeight());
                            break;
                        case 6:
                            System.out.println("Enter new height(m)");
                            current_ha.getHealthStatus().setHeight(Double.parseDouble(scan.nextLine()));
                            break;
                        case 7:
                            System.out.println("Inamte's weight is " + current_ha.getHealthStatus().getWeight() + "kg");
                            break;
                        case 8:
                            System.out.println("Enter new weight: ");
                            current_ha.getHealthStatus().setWeight(Double.parseDouble(scan.nextLine()));
                            break;
                        case 9:
                            System.out.println("Inmate's pulse is: " + current_ha.getHealthStatus().getPulse());
                            break;
                        case 10:
                            System.out.println("Enter new pulse");
                            current_ha.getHealthStatus().setPulse(Double.parseDouble(scan.nextLine()));
                            break;
                        case 11:
                            if (!current_ha.getHealthStatus().isHospitalized() && patient.size() < BED_CAPACITY) {
                                System.out.println("Inmate hospitalized due to illness");
                                System.out.println("Bed number assigned: " + patient.size());
                                patient.add(current_ha);
                                current_ha.getHealthStatus().setHospitalized(true);
                                choose = 14;//after hospitalization its appointment is finished,
                            }
                            else if(patient.size()>=BED_CAPACITY)
                                System.out.println("There are not free beds!");
                            else
                                System.out.println("Patient is already hospitalized");
                            break;
                        case 12:
                            if (current_ha.getHealthStatus().isHospitalized()) {
                                System.out.println("Inmate discharged from hospital");
                                current_ha.getHealthStatus().setHospitalized(false);
                                patient.remove(bedNumber-1);
                            } else
                                System.out.println("Error! Patient not hospitalized");
                            break;
                        case 13:
                            System.out.println("Going back to choosing next patient...");
                    }

                }
            }
        }
        else System.out.println("Wrong Password!");
    }

    public void showMenuPatient() {
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Doctor " + name);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("What do you want to do?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1]Get inmate's blood group");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2]Set inmate's blood group.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3]Check last control's result");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4]Set new control's result");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[5]Get inmate's height");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[6]Set inmate's height");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[7]Get inmate's weight");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[8]Set inmate's weight");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[9]Get inmate's Pulse");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[10]Set inmate's Pulse");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+ "   ");
        System.out.println("[11]Hospitalize patient");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[12]Discharge patient from hospital");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[13]Get next patient");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n" + "   ");
        System.out.println("[0] Main menu");
        System.out.println("\n");
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
    //Will take HealthStatus of a patient and be able to change it
    private void patient(){ }

}