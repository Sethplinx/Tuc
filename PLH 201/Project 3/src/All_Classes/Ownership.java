package All_Classes;

import java.time.LocalDate;
import java.util.Scanner;

public class Ownership {
	    private Owner associate ;
	    private Property associatedProperty;
	    private LocalDate creationTime;
	    private String authority;
	    private static int count;
	    private float percentage;
	    private int code;

	///////////////////////CONSTRUCTORS////////////////////////

	    public Ownership(Owner associate, Property associatedProperty) {
	        this.associate = associate;
	        this.associatedProperty = associatedProperty;
	        this.creationTime = LocalDate.now();
	        this.code = ++count;
	        setDegreeOfAuthority();
	        setAssignedPercentage();
	        associatedProperty.addOwnership(this);
	        associate.addOwnership(this);
	    }

	    public Ownership(Owner associate, Property associatedProperty, String authority, float percentage) {
	        this.associate = associate;
	        this.associatedProperty = associatedProperty;
	        this.creationTime = LocalDate.now();
	        this.authority = authority;
	        this.percentage = percentage;
	        this.code = ++count;
	        associatedProperty.addOwnership(this);
	        associate.addOwnership(this);
	    }

	/////////////////////////GETTERS///////////////////////////

	    public String toString() {
	        return ("\n" + "Ownership code: " + code + "\n" + "Associate: " + "\n" + "Owners Name: " + associate.getName() + "\n" + "Owners afm: " + associate.getAFM() + "\n" + "Associated property: " + "\n" + "Property code: " + associatedProperty.getCode() + "\n" + "Property district: " + associatedProperty.getDistrict()  + "\n" + "Percentage: " +  getPercentage() + "\n" + "Level of authority: " + authority + "\n" + "Time of creation: " + creationTime.toString());
	    } 

	    public Long getAfm(){
	        return associate.getAFM();
	    }

	    public Long getCode(){
	        return associatedProperty.getCode();
	    }

	    public float getPercentage() {
			return percentage;
		}
	    
	    public Property getAssociatedProperty() {															//Returns the property object the ownership contains
			return associatedProperty;	
		}
	    
		public Owner getAssociate() {																		//Returns the owner object the ownership contains
			return associate;
		}
		
	//////////////////////////SETTERS//////////////////////////


		public void setDegreeOfAuthority(){																	//Function for setting the degreeOfAuthority
	        Scanner in = new Scanner(System.in);
	        int choice;

	    do {
	        System.out.println("Levels of authority");
	        System.out.println("1.PLHRHS...........");
	        System.out.println("2.YPSILH KYRIOTHTA.");
	        System.out.println("3.EPIKARPIA........");
	        System.out.println();
	        System.out.print("Your answer: ");
	        choice = in.nextInt();
	        System.out.println();
	    }while(choice > 3 || choice < 0);

	    if(choice == 1)
	        this.authority = "PLHRHS";
	    else if(choice == 2)
	        this.authority = "YPSILH KYRIOTHTA";
	    else if(choice == 3)
	        this.authority = "EPIKARPIA";

	    }

	    public void setAssignedPercentage(){																//Function for setting the percentage the owner has on a property 	
	        Scanner in = new Scanner(System.in);
	        int choice;

	        do {
		        System.out.println("Enter the percentage the person has on this property");
		        System.out.println();
		        System.out.print("Your answer: ");
		        choice = in.nextInt();
	        }while(choice > 100 || choice < 0);

	        this.percentage = choice;
	    }

}	    