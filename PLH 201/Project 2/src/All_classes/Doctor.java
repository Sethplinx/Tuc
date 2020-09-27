package All_classes;

import java.util.Scanner;

public class Doctor {
    private String Full_name,Specialty;
    private int AAAE;

////////////////////Constuctors///////////////////////

    public Doctor(String name,String specialty,int aaae){
        Full_name = name;
        Specialty = specialty;
        AAAE = aaae;
    }

    public Doctor(){
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the Full name of the doctor you want to add to the system: ");
        Full_name = in.nextLine();

        System.out.print("Enter the specialty of " + Full_name + " : ");
        Specialty = in.nextLine();

        System.out.print("Enter the AAAE of " + Full_name + " : ");
        AAAE = in.nextInt();
    }

//////////////////////Getters/////////////////////////

    public String getFull_name() {
        return Full_name;
    }

    public int getAAAE(){
        return AAAE;
    }

/////////////////////Methods/////////////////////////

    public void getFullDetails() {
        System.out.println();
        System.out.println("Full_name: " + Full_name);
        System.out.println("Specialty: " + Specialty);
        System.out.println("AAAE: " + AAAE);
    }

}
