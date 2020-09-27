package Main_Class;

import java.util.Scanner;

import All_Classes.Apartment;
import All_Classes.Buildable_Plot;
import All_Classes.Business;
import All_Classes.Detached_House;
import All_Classes.LR_System;
import All_Classes.Land_Plot;
import All_Classes.Physical_Person;

public class Console_class {
	public static void main(String[] args) throws ClassNotFoundException {
		LR_System landRegistry = new LR_System("Ika","www.ika.gr");
		
		 Scanner in = new Scanner(System.in);
         int choice,inChoice;
         
         landRegistry.insertProperty(new Buildable_Plot("ATTIKHS","ATHINAION",800f,180000f,0.5f,1000020010L,600f));
         landRegistry.insertProperty(new Buildable_Plot("XANION","XANION",700f,1100000f,0.5f,1000020011L,400f));
         landRegistry.insertProperty(new Land_Plot("XANION","AKROTIRIOY",1100f,500000f,0.4f,1000020012L));
         
         landRegistry.insertProperty(new Apartment("PERYMNOY","PERYMNOY",90f,170000f,2f,1000030030L,"KOYNTOYRIOTOY 3",1977,"HOME",2,4));
         landRegistry.insertProperty(new Apartment("ATTIKHS","ATHINAION",105f,180000f,2.5f,1000030031L,"PANORMOY 20",2015,"HOME",4,5));
         landRegistry.insertProperty(new Apartment("HRAKLEIOY","HRAKLEIOY",150f,250000f,1.5f,1000030032L,"KNOSSOY 12",1990,"BUSINESS",0,6));

         landRegistry.insertProperty(new Detached_House("LASITHIOY","SHTEIA",80f,100000f,1.7f,1000040040L,"4HS SEPTEMBRIOY 2",1991,"HOME",1,0));
         landRegistry.insertProperty(new Detached_House("XANION","XANION",600f,500000f,1.5f,1000040041L,"PROFHTH HLIA 13",2017,"HOME",2,100));
         landRegistry.insertProperty(new Detached_House("ATTIKHS","XALANDRIOY",200f,300000f,1f,1000040042L,"AGIOY GEORGIOY 15",1980,"BUSINESS",1,0));

         landRegistry.insertOwner(new Physical_Person("NIKOLAOS ARAMPATZIS",123456789L,"PAPAFLESSA 2","05-12-1978"));
         landRegistry.insertOwner(new Physical_Person("GEORGIOS MIXAHL",987456321L,"MANOY 10","01-15-1985"));
         landRegistry.insertOwner(new Physical_Person("IOKASTH MANOY",741258963L,"KTISTAKH 1","11-13-1970"));
         landRegistry.insertOwner(new Physical_Person("ANNA KATRAKH",236716384L,"TSOXA 7","07-28-1990"));
         
         landRegistry.insertOwner(new Business("INFROMIX",341345657L,"PAPANASTASIOY 10","ELENH DHMOY"));
         landRegistry.insertOwner(new Business("SUPERFOOD",423451241L,"SOUTSOY 20","MARIA PAPPA"));
        
         landRegistry.insertOwnership(123456789L,1000020010L,"PLHRHS",50f);
         landRegistry.insertOwnership(987456321L,1000020010L,"PLHRHS",50f);
         landRegistry.insertOwnership(123456789L,1000020011L,"PLHRHS",100f);
         landRegistry.insertOwnership(741258963L,1000020012L,"PLHRHS",100f);
         landRegistry.insertOwnership(236716384L,1000030030L,"PLHRHS",100f);
         landRegistry.insertOwnership(236716384L,1000030031L,"YPSILH KYRIOTHTA",100f);
         landRegistry.insertOwnership(423451241L,1000030032L,"PLHRHS",100f);
         landRegistry.insertOwnership(741258963L,1000040040L,"PLHRHS",100f);
         landRegistry.insertOwnership(741258963L,1000040041L,"EPIKARPIA",100f);
         landRegistry.insertOwnership(341345657L,1000040042L,"PLHRHS",100f);
         
         do {
        	System.out.println();
            System.out.println("......................Ktimatologio........................");
            System.out.println("..........................................................");
            System.out.println("1.Find owner/property/ownership...........................");
            System.out.println("2.Print all owners/properties/ownership titles............");
            System.out.println("3.Create new ownership title..............................");
            System.out.println("4.Calculate total cost of properties/ENFIA................");
            System.out.println("5.Add new Owner/Property..................................");
            System.out.println("6.Exit....................................................");
            System.out.println();
            System.out.print("Your answer: ");
            choice = in.nextInt();
            System.out.println();

            switch (choice){
                case 1:
                	inChoice = 0;
                	do {
	                    System.out.println("..........................Find............................");
	                    System.out.println("..........................................................");
	                    System.out.println("1.Specific Owner..........................................");
	                    System.out.println("2.Specific Property.......................................");
	                    System.out.println("3.Specific Property Category..............................");
	                    System.out.println("4.Specific Ownership Title................................");
	                    System.out.println("5.Exit....................................................");
	                    System.out.println();
	                    System.out.print("Your answer: ");
	                    inChoice = in.nextInt();
	                    System.out.println();
                	}while(inChoice < 0 || inChoice > 5)  ;
                	
                	switch(inChoice) {
                		case 1:
                			landRegistry.printSpecificOwner_afm();
                            break;
                		case 2:
                			landRegistry.printSpecificProperty_code();
                        	break;
                		case 3:
                			landRegistry.printSpecificProperty_category();
                            break;
                		case 4:
                			landRegistry.printSpecificOwnership();
                        	break;
                		case 5:
                			break;
                	}
                	break;	
                case 2:
                	inChoice = 0;
                	do {
	                    System.out.println(".........................Print All........................");
	                    System.out.println("..........................................................");
	                    System.out.println("1.Owners..................................................");
	                    System.out.println("2.Properties..............................................");
	                    System.out.println("3.Ownership Titles........................................");
	                    System.out.println("4.Exit....................................................");
	                    System.out.println();
	                    System.out.print("Your answer: ");
	                    inChoice = in.nextInt();
	                    System.out.println();
                	}while(inChoice < 0 || inChoice > 4);
                	
                	switch(inChoice) {
            		case 1:
            			landRegistry.printAllOwners();
                        break;
            		case 2:
            			landRegistry.printAllProperties();
                    	break;
            		case 3:
            			landRegistry.printAllOwnerships();
                        break;
            		case 4:
            			break;
                	}
                	break;
                case 3:
                	landRegistry.createOwnership();
                    break;
                case 4:
                	inChoice = 0;
                	do {
	                    System.out.println(".........................Calculate........................");
	                    System.out.println("..........................................................");
	                    System.out.println("1.Enfia...................................................");
	                    System.out.println("2.Total Cost Of Properties................................");
	                    System.out.println("3.Exit....................................................");
	                    System.out.println();
	                    System.out.print("Your answer: ");
	                    inChoice = in.nextInt();
	                    System.out.println();
                	}while(inChoice < 0 || inChoice > 3);
                	
                	switch(inChoice) {
            		case 1:
            			landRegistry.printEnfia();
                        break;
            		case 2:
            			landRegistry.printPropertyWorth();
                    	break;
            		case 3:
            			break;
                	}
                	break;
                case 5:
                	inChoice = 0;
                	do {
	                    System.out.println(".........................Add new..........................");
	                    System.out.println("..........................................................");
	                    System.out.println("1.Owner...................................................");
	                    System.out.println("2.Property................................................");
	                    System.out.println("3.Exit....................................................");
	                    System.out.println();
	                    System.out.print("Your answer: ");
	                    inChoice = in.nextInt();
	                    System.out.println();
                	}while(inChoice < 0 || inChoice > 3);
                	
                	switch(inChoice) {
            		case 1:
            			landRegistry.addOwner();
                        break;
            		case 2:
            			landRegistry.addProperty();
                    	break;
            		case 3:
            			break;
                	}
                	break;
                case 6: 
                	break;
            }
         }while(choice != 6);
    }	
		
}
