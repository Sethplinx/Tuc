package All_classes;

import java.util.Scanner;

public class Drug {
    private String name;
    private float price;
    private int code;

////////////////////Constuctors///////////////////////

    public Drug(String name,int code, float price){
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public Drug(){
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Enter the name of the drug you want to add to the system: ");
        name = in.nextLine();

        System.out.print("Enter the code of " + name + " : ");
        code = in.nextInt();

        System.out.print("Enter the price of " + name + " : ");
        price = in.nextFloat();
    }

//////////////////////Getters/////////////////////////

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getCode() {
        return code;
    }

/////////////////////Methods/////////////////////////

    public void getFullDetails() {
        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
        System.out.println("Price: " + price);
    }

}
