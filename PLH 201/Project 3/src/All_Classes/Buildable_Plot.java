package All_Classes;

import java.util.Scanner;

public class Buildable_Plot extends Plot{
	private float buildableArea;
	
///////////////////////CONSTRUCTORS////////////////////////
	
	public Buildable_Plot(String district, String city, float area, float price, float zonePrice, Long code, float buildArea) {
		super(district, city, area, price, zonePrice, code);
		this.buildableArea = buildArea;
	}
	
	public Buildable_Plot() {
		super();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the buildable area in squared meters: ");
		int Area = in.nextInt();
		this.buildableArea = Area;		
	}

/////////////////////////GETTER///////////////////////////

	public float getBuildableArea() {
		return buildableArea;
	} 
	
	public String toString() {
		return (super.toString() + "Type: Buildable plot" + "\n" +"buildable area: " + buildableArea + "\n" + "Enfia: " + calculateEnfia() + "\n" );
	}

	@Override
	float calculateEnfia() {
	    return(getZonePrice() * getArea() + 0.15f * getZonePrice() * getBuildableArea());
	}
	
}
