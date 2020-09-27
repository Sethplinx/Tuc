package main_class;

import All_classes.*;

import java.time.LocalDate;
import java.util.*;

public class Console {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;

            Drug_system drug_sys = new Drug_system("IKA", "www.ika.gr");

            drug_sys.insertInsured(new Person("alex st",6969666));
            drug_sys.insertInsured(new Person("d ang",6969777));
            drug_sys.insertInsured(new Person("a sif",6969888));

            drug_sys.insertDoctor(new Doctor("sotiris tsiordas","fasion icon",6664 ));
            drug_sys.insertDoctor(new Doctor("xardalias","superman",6665 ));
            drug_sys.insertDoctor(new Doctor("filitsis","navy",6666 ));

            drug_sys.insertDrug(new Drug("Depon",1,12.5f));
            drug_sys.insertDrug(new Drug("xanax",2,22.58f));
            drug_sys.insertDrug(new Drug("ponstan",3,2.0f));

            drug_sys.insertPrescription(6969666, "sotiris tsiordas", "Depon", "Xanax", "ponstan", "aaa", LocalDate.now(), LocalDate.now().plusDays(10));
            drug_sys.insertPrescription(6969666, "xardalias", "Depon", "aaa", "aaa", "aaa", LocalDate.now().plusDays(10), LocalDate.now().plusDays(20));
            drug_sys.insertPrescription(6969777, "sotiris tsiordas", "Depon", "Xanax", "ponstan", "aaa", LocalDate.now().plusDays(20), LocalDate.now().plusDays(30));
            drug_sys.insertPrescription(6969888, "filitsis", "Depon", "Xanax", "aaaa", "aaa", LocalDate.now().plusDays(40), LocalDate.now().plusDays(60));

        do {
            System.out.println("...............System choices...............");
            System.out.println("............................................");
            System.out.println("1.Add new person............................");
            System.out.println("2.Add new drug..............................");
            System.out.println("3.Add new doctor............................");
            System.out.println("4.Add new prescription......................");
            System.out.println("5.Find specific prescription................");
            System.out.println("6.Print info................................");
            System.out.println("7.Delete insured............................");
            System.out.println("8.Exit......................................");
            System.out.println();
            System.out.print("Your choise: ");

            choice = in.nextInt();

            switch (choice) {
                case 1:
                    drug_sys.addInsured(new Person());
                    break;
                case 2:
                    drug_sys.addDrug(new Drug());
                    break;
                case 3:
                    drug_sys.addDoctor(new Doctor());
                    break;
                case 4:
                    drug_sys.createPrescription();
                    break;
                case 5:
                    drug_sys.findPrescription();
                    break;
                case 6:
                    drug_sys.printInfo();
                    break;
                case 7:
                    drug_sys.deletePerson();
                    break;
            }
        } while (choice != 8);
    }
}