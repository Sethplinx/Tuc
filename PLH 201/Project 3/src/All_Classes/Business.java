package All_Classes;

import java.util.Scanner;

public class Business extends Owner {
    private String address,repName;

///////////////////////CONSTRUCTOR////////////////////////

    public Business(String name, Long AFM,String address, String repName) {
        super(name, AFM);
        this.address = address;
        this.repName = repName;
    }

    public Business(){
        super();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the address: ");
        this.address = in.nextLine();
        System.out.print("Enter the representatives name: ");
        this.repName = in.nextLine();
    }

/////////////////////////GETTER///////////////////////////

    public String toString() {
        return (super.toString() + "Type: Business" + "\n" + "Address: " + address + "\n" +"repName: " + repName);
    }

}