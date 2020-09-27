package All_classes;

import java.util.*;

public class Person {
    private String Full_name;
    private int amka;

////////////////////Constuctors///////////////////////

    public Person(String name, int amka){
        Full_name = name;
        this.amka = amka;
    }

    public Person(){
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the Full name of the person you want to add to the system: ");
        Full_name = in.nextLine();

        System.out.print("Enter the AMKA of " + Full_name + " : ");
        amka = in.nextInt();
    }

//////////////////////Getters/////////////////////////

    public String getFull_name() {
        return Full_name;
    }

    public int getAmka(){
        return amka;
    }

/////////////////////Methods/////////////////////////

    public void getFullDetails() {
        System.out.println();
        System.out.println("Full_name: " + Full_name);
        System.out.println("AMKA: " + amka);
    }

}
