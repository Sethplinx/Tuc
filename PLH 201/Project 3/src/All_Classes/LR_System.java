package All_Classes;

import java.util.Scanner;

import List_Classes.EnhancedSortedList;
import List_Classes.List_Item_Owner;
import List_Classes.List_Item_Ownership;
import List_Classes.List_Item_Property;
import List_Classes.Node;

public class LR_System {
	private String name,url;
	private EnhancedSortedList propertyList,ownerList,ownershipList;
	
///////////////////////CONSTRUCTORS////////////////////////

	public LR_System(String name, String url) {
		this.name = name;
		this.url = url;
		propertyList = new EnhancedSortedList();
		ownerList = new EnhancedSortedList();
		ownershipList = new EnhancedSortedList();
	}
	
//////////////////////////METHODS/////////////////////////	
	
    /////////////////////Owners///////////////////////

	public void insertOwner(Owner o) {																		//Function for inserting an owner from the given data
		ownerList.addNode(new List_Item_Owner(o));
	}
	
	public void addOwner() {																				//Function for adding an owner to the system by asking the user to input the data
		Scanner in = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("..............Types of owners..............");
			System.out.println("1.Physical person..........................");
			System.out.println("2.Business.................................");
			System.out.println("3.Exit.....................................");
			System.out.println();
			System.out.print("Your answer: ");
			choice = in.nextInt();
		}while(choice > 3 || choice < 0);
		
		switch(choice) {
			case 1:
				ownerList.addNode(new List_Item_Owner(new Physical_Person()));
				break;
			case 2:
				ownerList.addNode(new List_Item_Owner(new Business()));
				break;
			case 3:
				return;
		}
	}
	
	public void printSpecificOwner_afm() {																	//Function that prints information of an owner if there is one with the afm given by the user, in the system 
		Scanner in = new Scanner(System.in);
		Owner o;
		
		System.out.print("Enter the afm of the owner: ");
		o = (Owner)ownerList.findInList(in.nextLong());
		
		if(o == null) {
			System.out.println("Couldn't find an owner with this afm");
			return;
		}
		
		System.out.println(o);
		if(o.getListOfOwnershipsLenght() == 0) {
			System.out.println("No associated properties");
			return;
		}
		o.getAssociatedProperties();
	}

	public void printPropertyWorth() {																		//Function that prints the total worth the of the properties an owner has if the there is an owner with the 
		Scanner in = new Scanner(System.in);																//afm given by the user, in the system			
		Owner o;
		
		System.out.print("Enter the afm of the owner: ");
		o = (Owner)ownerList.findInList(in.nextLong());
		if(o == null) {
			System.out.println("Couldn't find an owner with this afm");
			return;
		}
		System.out.println("Total property worth: " + o.calculateWorth());		
	}
   
	public void printEnfia() {																				//Function that prints the enfia price according to the properties an owner has			
		Scanner in = new Scanner(System.in);
		Owner o;
		
		System.out.print("Enter the afm of the owner: ");
		o = (Owner)ownerList.findInList(in.nextLong());
		
		if(o == null) {
			System.out.println("Couldn't find an owner with that afm");
			return;
		}
				
		System.out.println("Price of enfia: " +  Float.toString(o.calculateEnfia()));
	}
	
	public void printAllOwners() {																			//Function that prints all the owners in the system (for debugging reasons)
		ownerList.pritnAllList();
	}

	/////////////////////Properties///////////////////

	public void insertProperty(Property prop) {																//Function for inserting a property from the given data
		propertyList.addNode(new List_Item_Property(prop));
	}
	
	public void addProperty() {																				//Function for adding a property to the system by asking the user to input the data
		Scanner in = new Scanner(System.in);
		int choice;
		
		do {
			System.out.println("..............Types of owners..............");
			System.out.println("1.Apartment................................");
			System.out.println("2.Detached house...........................");
			System.out.println("3.Buildabel plot...........................");
			System.out.println("4.Land plot................................");
			System.out.println("5.Exit.....................................");
			System.out.println();
			System.out.print("Your answer: ");
			choice = in.nextInt();
		}while(choice > 5 || choice < 0);
		
		switch(choice) {
			case 1:
				propertyList.addNode(new List_Item_Property(new Apartment()));
				break;
			case 2:
				propertyList.addNode(new List_Item_Property(new Detached_House()));
				break;
			case 3:
				propertyList.addNode(new List_Item_Property(new Buildable_Plot()));
				break;
			case 4:
				propertyList.addNode(new List_Item_Property(new Land_Plot()));
				break;	
			case 5:
				return;
		}
	}
	
	public void printSpecificProperty_code() {																//Function that prints information of a property if there is one with the code given by the user, in the system
		Scanner in = new Scanner(System.in);																
		Property pr;
		
		System.out.print("Enter the propertys code: ");
		pr = (Property)propertyList.findInList(in.nextLong());
		
		if(pr == null) {
			System.out.println("Couldn't find a property with that code");
			return;
		}
		
		System.out.println(pr);
		if(pr.getListOfOwnershipsLenght() == 0) {
			System.out.println("No associated owners");
			return;
		}
		pr.getAssociatedOwners();
	}

	public void printSpecificProperty_category() throws ClassNotFoundException {							//Function that prints information of properties that are in a specific category
		Scanner in = new Scanner(System.in);
		int choice;
		
		System.out.println(".............Property categories............");
		System.out.println("1.Buildings.................................");
		System.out.println("2.Apartments................................");
		System.out.println("3.Detached houses...........................");
		System.out.println("4.Plots.....................................");
		System.out.println("5.Buildable plots...........................");
		System.out.println("6.Land plots................................");
		System.out.println("7.Exit......................................");
		System.out.println();
		System.out.print("Your answer: ");
		choice = in.nextInt();
		System.out.println();
		
		switch(choice) {
			case 1:
				propertyList.printItemsInHierarchy("All_Classes.Building");
				break;
			case 2:
				propertyList.printItemsInHierarchy("All_Classes.Apartment");
				break;
			case 3:
				propertyList.printItemsInHierarchy("All_Classes.Detached_House");
				break;
			case 4:
				propertyList.printItemsInHierarchy("All_Classes.Plot");
				break;
			case 5:
				propertyList.printItemsInHierarchy("All_Classes.Buildable_Plot");
				break;
			case 6:
				propertyList.printItemsInHierarchy("All_Classes.Land_Plot");
				break;
			case 7:
				break;
		}
		
	}

	public void printAllProperties() {																		//Function that prints all the properties in the system
		propertyList.pritnAllList();
	}

	/////////////////////Ownership///////////////////
	
	public void insertOwnership(Long afm, Long code, String authority, float percentage) {					//Function for inserting an ownership title from the given data
		Property pr;
        Owner ow;

        ow = (Owner)ownerList.findInList(afm);
        pr = (Property)propertyList.findInList(code);

        ownershipList.addNode(new List_Item_Ownership(new Ownership(ow,pr,authority,percentage)));	
	}
	
	public void createOwnership() {																			//Function for creating an ownership title by asking the user to give the necessary data
		Scanner in = new Scanner(System.in);
		Property req_prop;
		Owner req_own;
		
		System.out.print("Enter the afm of the owner: ");
		req_own = (Owner)ownerList.findInList(in.nextLong());
		if(req_own == null) {
			System.out.println("Couldn't find an owner with that afm");
			return;
		}
		
		System.out.print("Enter the code of the property: ");
		req_prop = (Property)propertyList.findInList(in.nextLong());
		if(req_prop == null) {
			System.out.println("Couldn't find a property with that code");
			return;
		}
		
		ownershipList.addNode(new List_Item_Ownership(new Ownership(req_own, req_prop)));
	}
	
	public void printSpecificOwnership() {																	//Function that prints information of the ownership titles an owner or a property has 
		Scanner in = new Scanner(System.in);
		Property req_prop;
		Ownership own;
		Owner req_own;
		int choice;
		do {
			System.out.println();
	        System.out.println(".......................Search by..........................");
	        System.out.println("..........................................................");
	        System.out.println("1.Owner...................................................");
	        System.out.println("2.Property................................................");
	        System.out.println("3.Exit....................................................");
			System.out.println();
			System.out.print("Your answer: ");
			choice = in.nextInt();
			System.out.println();
			
		}while(choice > 3 || choice < 0);
		
		switch(choice) {
			case 1:
				System.out.print("Enter the afm of the owner: ");
				req_own = (Owner)ownerList.findInList(in.nextLong());
				if(req_own == null) {
					System.out.println("Couldn't find an owner with that afm");
					return;
				}
				if(req_own.getListOfOwnershipsLenght() == 0) {
					System.out.println("No ownerships found");
					break;
				}
				
				for(Node currNode =  ownershipList.getHead(); currNode != null; currNode = currNode.getNext()) {
					own = (Ownership)currNode.getInfo().getItem();
						if(own.getAfm() == req_own.getAFM())
							System.out.println(own);	
		        }
				break;
			case 2:
				System.out.print("Enter the code of the property: ");
				req_prop = (Property)propertyList.findInList(in.nextLong());
				if(req_prop == null) {
					System.out.println("Couldn't find a property with that code");
					return;
				}
				
				if(req_prop.getListOfOwnershipsLenght() == 0) {
					System.out.println("No ownerships found");
					break;
				}
				
				for(Node currNode =  ownershipList.getHead(); currNode != null; currNode = currNode.getNext()) {
					own = (Ownership)currNode.getInfo().getItem();
					if(own.getCode() == req_prop.getCode()) 
							System.out.println(own);
				}
				break;
			case 3:
				break;
		}
    }
				
	public void printAllOwnerships() {																		//Function that prints all the ownership titles in the system (for debugging reasons)
		ownershipList.pritnAllList();
	}
	
}
