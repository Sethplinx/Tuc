package All_Classes;

import java.util.Scanner;

import List_Classes.List;
import List_Classes.List_Item;
import List_Classes.List_Item_Owner;
import List_Classes.List_Item_Ownership;
import List_Classes.Node;

public abstract class Property {
	private String district,city;
    private float area,price,zonePrice;
    private Long Code;	
    private List listOfOwnerships;
    
///////////////////////CONSTRUCTOR////////////////////////
    
    public Property(String district, String city, float area, float price, float zonePrice, Long code) {
        this.district = district;
        this.city = city;
        this.area = area;
        this.price = price;
        this.zonePrice = zonePrice;
        Code = code;
        listOfOwnerships = new List();
    }
    
    public Property(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the district name: ");
        district = in.nextLine();
        System.out.print("Enter the city name: ");
        city = in.nextLine();
        System.out.print("Enter the area in squared meters: ");
        area = in.nextFloat();
        System.out.print("Enter the price: ");
        price = in.nextFloat();
        System.out.print("Enter the zone price: ");
        zonePrice = in.nextFloat();
        System.out.print("Enter the code: ");
        Code = in.nextLong();
        listOfOwnerships = new List();
    }

/////////////////////////GETTERS/////////////////////////

    public Long getCode() {
        return Code;
    }

    public String getDistrict() {
		return district;
	}

	public float getPrice() {
        return price;
    }

    public float getArea() {
        return area;
    }

    public float getZonePrice() {
        return zonePrice;
    }
    
    public void getAssociatedOwners() {																				//Function that prints specific information about the associated owner of a specific owner
    	System.out.println("Associated Owner(s)");
    	for(Node currNode = listOfOwnerships.getHead(); currNode != null; currNode = currNode.getNext()) {
    		Ownership Onw = (Ownership)currNode.getInfo().getItem();
    		Owner o = Onw.getAssociate();
    		System.out.println("Name: " + o.getName() + "\n" + "Percentage: " + Onw.getPercentage() + "\n");
    	}
    }
    
    public int getListOfOwnershipsLenght() {
		return listOfOwnerships.getLength();
	}

	public String toString() {
        return ( "\n" + "Property code: " + Code + "\n" + "Property district: " + district + "\n" + "Property City: " + city + "\n" + "Property Zone Pricing: " + zonePrice + "\n" + "Property Area: " + area + "\n" + "Property Price: " + price);
    }
    
    public void addOwnership(Ownership o) {
   	 listOfOwnerships.addNode(new List_Item_Ownership(o));	
    }
    
    abstract float calculateEnfia();

}
