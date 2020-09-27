package All_Classes;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Building extends Property{
    private String address,use;
    private int buildYear;

///////////////////////CONSTRUCTORS////////////////////////

    public Building(String district, String city, float area, float price, float zonePrice, Long code, String address, int buildYear, String use) {
        super(district, city, area, price, zonePrice, code);
        this.address = address;
        this.buildYear = buildYear;
        this.use = use;
    }

    public Building(){
        super();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the address: ");
        address = in.nextLine();
        System.out.print("Enter the build year(in 'yyyy' format): ");
        int date = in.nextInt();
        buildYear = date;
        int choice;
        do {
        	System.out.println();
	        System.out.println("..........Used for........");
	        System.out.println("..........................");
	        System.out.println("1.HOME....................");
	        System.out.println("2.BUSINESS................");
	        System.out.println();
	        System.out.print("Your answer: ");
	        choice = in.nextInt();
        }while(choice < 0 || choice > 2);
        System.out.println();
        if(choice == 1) 
        	this.use = "HOME";
        else
        	this.use = "BUSINESS";
        
    }

/////////////////////////GETTERS///////////////////////////

    public String toString() {
        return(super.toString() + "\n" + "Address: " + address + "\n" + "Build date: " + buildYear + "\n" + "Use: " + use );
    }
 
    public float getHowOld() {									//Function that calculates the oldeness factor
    	int differ = LocalDate.now().getYear() - buildYear;
    	
    	if(differ <= 10)
    		return 1;
    	else if(differ <= 20)
    		return 0.9f;
    	else if(differ <= 30)
    		return 0.8f;
    	else
    		return 0.5f;
    }
    
}
