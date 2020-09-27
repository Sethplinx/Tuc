package All_Classes;

import java.util.Scanner;
import List_Classes.List;
import List_Classes.List_Item_Ownership;
import List_Classes.List_Item_Property;
import List_Classes.Node;

public abstract class Owner {
    
	private String name;
    private float costOfProperties;
    private Long AFM;
    private List listOfOwnerships;

///////////////////////CONSTRUCTORS////////////////////////

    public Owner(String name,Long AFM){
        this.name = name;
        this.AFM = AFM;
        listOfOwnerships = new List();
        costOfProperties = 0;
    }

    public Owner(){
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the name: ");
        this.name = in.nextLine();
        System.out.print("Enter the afm of the person:");
        this.AFM=in.nextLong();
        listOfOwnerships = new List();
        costOfProperties = 0;
    }
    
/////////////////////////GETTERS/////////////////////////
   
    public Long getAFM() {
        return AFM;
    }
    
    public String getName() {
		return name;
	}

    public void getAssociatedProperties() {        																		//Function that prints specific information about the associated properties of a specific owner 
    	System.out.println("\n" + "Associated Properties");
    	for(Node currNode = listOfOwnerships.getHead(); currNode != null; currNode = currNode.getNext()) {
    		Ownership Onw = (Ownership)currNode.getInfo().getItem();
    		Property pr = Onw.getAssociatedProperty();
    		System.out.println("Property district: " + pr.getDistrict()+ "\n" + "Property enfia: " + pr.calculateEnfia() +"\n" + "Percentage: " + Onw.getPercentage() + "\n");
    	}
    }
    
    public int getListOfOwnershipsLenght() {
		return listOfOwnerships.getLength();
	}
    
    public String toString() {
        return("\n" + "Owner name: " + name + "\n" + "AFM: " + AFM + "\n" + "Cost of Properties: " + calculateWorth() + "\n" + "Enfia: " + calculateEnfia() + "\n");
    }
    
/////////////////////////METHODS/////////////////////////	
    
    public void addOwnership(Ownership o) {																				//Function for adding an ownership title to the list of ownerships every owner has									
    	 listOfOwnerships.addNode(new List_Item_Ownership(o));	
    }
    
    public String calculateWorth() {																					//Function for calculating the total cost of properties of an owner	
    	Ownership own;
    	Property prop;
    	float totalCost = 0;
    	
    	if(listOfOwnerships.getLength() == 0) 
    		return ("0" + " (No associated properties)");
    	
    	for(Node currNode = listOfOwnerships.getHead(); currNode != null; currNode = currNode.getNext()) {
    		own = (Ownership)currNode.getInfo().getItem();
    		totalCost += own.getAssociatedProperty().getPrice();
    	}
    	return Float.toString(totalCost);
    }

    public float calculateEnfia() {																						//Function for calculating the total cost of enfia of an owner																		
    	Property pr = null;
    	Ownership own = null;
    	float enfia = 0,percent = 0;
    	
    	for(Node currNode = listOfOwnerships.getHead(); currNode != null; currNode = currNode.getNext()) {
    		own = (Ownership)currNode.getInfo().getItem();
    		pr = own.getAssociatedProperty();
    		enfia += pr.calculateEnfia() * own.getPercentage() * 0.01f;
    	}
    	return enfia;
    }

}
