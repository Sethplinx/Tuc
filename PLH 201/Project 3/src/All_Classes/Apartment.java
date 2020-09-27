package All_Classes;

import java.util.Scanner;

public class Apartment extends Building {
    private int floor,rooms;

///////////////////////CONSTRUCTORS////////////////////////

    public Apartment(String district, String city, float area, float price, float zonePrice, Long code, String address, int buildDate, String use, int floor, int rooms) {
        super(district, city, area, price, zonePrice, code, address, buildDate, use);
        this.floor = floor;
        this.rooms = rooms;
    }

    public Apartment(){
        super();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter the floor number: ");
        floor = in.nextInt();
        System.out.print("Enter the number of rooms: ");
        rooms = in.nextInt();
    }

/////////////////////////GETTER///////////////////////////

    public int getFloor() {
        return floor;
    }

    public String toString() {
        return(super.toString() + "\n" + "floor: " + floor + "\n" + "Rooms: " + rooms + "\n" );
    }

	@Override
	float calculateEnfia() {
        return(getZonePrice() * getArea() * getHowOld() * (1 + getFloor() * 0.05f));
	}

}