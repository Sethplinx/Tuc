package All_Classes;

import java.util.Scanner;

public class Physical_Person extends Owner {
	 private String address,birthDate;
	
///////////////////////CONSTRUCTOR////////////////////////

	public Physical_Person(String name, Long AFM, String address, String birthDate) {
	super(name, AFM);
	this.address = address;
	this.birthDate = birthDate;
	}
	
	public Physical_Person(){
	super();
	
	Scanner in = new Scanner(System.in);
	System.out.print("Enter the address: ");
	this.address = in.nextLine();
	System.out.print("Enter the date of birth: ");
	this.birthDate = in.nextLine();
	}
	
	//////////////////////////METHODS//////////////////////////
	
	public String toString() {
		return (super.toString() + "Type: Physical person" + "\n" + "Address: " + address + "\n" + "birthDate: " + birthDate);
	}

}
