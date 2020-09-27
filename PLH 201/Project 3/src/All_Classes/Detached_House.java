package All_Classes;

import java.util.Scanner;

public class Detached_House extends Building {
    private float poolArea;
    private int floors;

///////////////////////CONSTRUCTORS////////////////////////

    public Detached_House(String district, String city, float area, float price, float zonePrice, Long code, String address, int buildDate, String use, int floors, float poolArea) {
        super(district, city, area, price, zonePrice, code, address, buildDate, use);
        this.poolArea = poolArea;
        this.floors = floors;
    }

    public Detached_House(){
       super();
       Scanner in = new Scanner(System.in);

       System.out.println("Does the detached building have a pool? Press Y for yes or N for no");
       System.out.println();
       System.out.print("Your answer: ");

       if(in.nextLine().equalsIgnoreCase("y")) {
           System.out.print("Enter squared area of the pool: ");
           this.poolArea = in.nextFloat();
       }
       else if(in.nextLine().equalsIgnoreCase("n"))
           this.poolArea = 0.0f;


       System.out.println("Does the detached building has multiple floors? Press Y for yes or N for no");
       System.out.println();
       System.out.print("Your answer: ");
       in.nextLine();
       
       if(in.nextLine().equalsIgnoreCase("y")) {
           System.out.print("Enter the number of floors: ");
           this.floors = in.nextInt();
       }
       else if(in.nextLine().equalsIgnoreCase("n"))
           this.floors = 0;
       
    }

/////////////////////////GETTER///////////////////////////

    public float getPoolArea() {
        return poolArea;
    }

    public String toString() {
        return(super.toString() + "\n" + "Highest floor: " + floors + "\n" + "Pool area: " + poolArea + "\n");
    }

	@Override
	float calculateEnfia() {
	    return(getZonePrice() * getArea() * getHowOld() +  getPoolArea() * 10);
	}

}
