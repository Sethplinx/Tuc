package All_classes;

import java.time.LocalDate;
import java.util.*;

public class Drug_system {
    private String System_name, URL;
    private List<Person> insured;
    private List<Doctor> Doctors;
    private List<Drug> Drugs;
    private List<Prescription> Prescriptions;

////////////////////CONSTRUCTORS///////////////////////

    public Drug_system(String name, String url) {
        System_name = name;
        URL = url;
        insured = new ArrayList<Person>();
        Doctors = new ArrayList<Doctor>();
        Drugs = new ArrayList<Drug>();
        Prescriptions = new ArrayList<Prescription>();
    }

/////////////////////Methods/////////////////////////

    /////////////////GENERAL//////////////////

    public void contrinueMessage() {
        Scanner in = new Scanner(System.in);

        System.out.println();
        System.out.print("Press enter to continue");
        in.nextLine();
        System.out.println();
    }

    public void printInfo(){
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.println("...................Print................");
        System.out.println("........................................");
        System.out.println("1.Insured...............................");
        System.out.println("2.Drugs.................................");
        System.out.println("3.Doctors...............................");
        System.out.println("4.Prescriptions.........................");
        System.out.println("5.Exit..................................");
        System.out.println();
        System.out.print("Your choise: ");

        choice = in.nextInt();

        switch (choice) {
            case 1:
                printInsured();
                break;
            case 2:
                printDrugs();
                break;
            case 3:
                printDoctors();
                break;
            case 4:
                printPrescriptions();
                break;
            case 5:
                break;
        }

        contrinueMessage();
    }

    /////////////////INSURED//////////////////

    public void insertInsured(Person p) {
        insured.add(p);
    }

    public void addInsured(Person p) {
        if (insured.size() < 100)
            insured.add(p);
        else
            System.out.println("Can't archive more people");

        contrinueMessage();
    }

    public Person searchAmka(int amka) {
        for (int i = 0; i < insured.size(); i++) {
            if (amka == insured.get(i).getAmka())
                return insured.get(i);
        }
        return null;
    }

    public void printInsured(){
        for(int i=0; i < insured.size(); i++)
            insured.get(i).getFullDetails();
    }

    public void deletePerson(){
        Scanner in = new Scanner(System.in);
        int amka;

        System.out.println();
        System.out.print("Enter the AMKA of the person you want to be deleted from the system:");
        amka = in.nextInt();
        Person P_to_D = searchAmka(amka);

        if(P_to_D == null) {
            System.out.println("Couldn't find a person with this AMKA in the system");
            contrinueMessage();
            return;
        }

        searchPrescAmka_delete(amka);
        removePerson(amka);

        contrinueMessage();
    }

    /////////////////DRUGS////////////////////

    public void insertDrug(Drug d) {
        Drugs.add(d);
    }

    public void addDrug(Drug d) {
        if (Drugs.size() < 50)
            Drugs.add(d);
        else
            System.out.println("Can't archive more drugs");

        contrinueMessage();
    }

    public Drug searchDrugName(String name) {
        for (int i = 0; i < Drugs.size(); i++) {
            if (name.equalsIgnoreCase(Drugs.get(i).getName()))
                return Drugs.get(i);
        }
        return null;
    }

    public void removePerson(int amka){
        int count = 0;
        for(int i=0; i < insured.size(); i++) {
            if (amka == insured.get(i).getAmka()) {
                insured.remove(i);
                count++;
            }
        }

        System.out.println("Person and associated prescriptions removed");
    }

    public void printDrugs(){
        for(int i=0; i < Drugs.size(); i++)
            Drugs.get(i).getFullDetails();
    }

    /////////////////DOCTORS//////////////////

    public void insertDoctor(Doctor d) {
            Doctors.add(d);
    }

    public void addDoctor(Doctor d) {
        if ((Doctors.size() < 100))
            Doctors.add(d);
        else
            System.out.println("Can't archive more drugs");

        contrinueMessage();
    }

    public Doctor searchDocName(String name) {
        for (int i = 0; i < Doctors.size(); i++) {
            if (name.equalsIgnoreCase(Doctors.get(i).getFull_name()))
                return Doctors.get(i);
        }
        return null;
    }

    public void printDoctors(){
        for(int i=0; i < Doctors.size(); i++)
            Doctors.get(i).getFullDetails();
    }

    //////////////PRESCRIPTIONS///////////////

    public void insertPrescription(int person_amka, String doctor_name, String drug_name_1, String drug_name_2, String drug_name_3, String drug_name_4, LocalDate now_date, LocalDate exp_date) {
        Prescriptions.add(new Prescription(searchAmka(person_amka), searchDocName(doctor_name), searchDrugName(drug_name_1), searchDrugName(drug_name_2), searchDrugName(drug_name_3), searchDrugName(drug_name_4), now_date, exp_date));
    }

    public void createPrescription() {
        Scanner in = new Scanner(System.in);
        int i;
        int count;
        int req_amka;
        int num_of_drugs;
        String req_doc;
        String req_drug;
        Person presc_per;
        Doctor presc_doc;
        List<Drug> presc_drugs;

        System.out.println();
        if (Prescriptions.size() < 400) {}
        else {
            System.out.println("Can't archive more prescriptions");
            contrinueMessage();
            return;
        }

        System.out.print("Enter the AMKA of the recipient: ");
        req_amka = in.nextInt();
        presc_per = searchAmka(req_amka);
        if (presc_per == null) {
            System.out.println("Couldn't find that person in the system");
            contrinueMessage();
            return;
        }

        in.nextLine();

        System.out.print("Enter the full name of the doctor: ");
        req_doc = in.nextLine();
        presc_doc = searchDocName(req_doc);
        if (presc_doc == null) {
            System.out.println("Couldn't find that doctor in the system");
            contrinueMessage();
            return;
        }

        do {
            System.out.println("Enter the number of drugs you want to prescribe");
            System.out.println("Note you can add up to 4 drugs");
            System.out.print("Your answer: ");
            num_of_drugs = in.nextInt();
        } while (num_of_drugs < 0 || num_of_drugs > 4);

        presc_drugs = new ArrayList<Drug>();

        in.nextLine();

        for (i = 0; i < num_of_drugs; i++) {
            count = i + 1;

            System.out.print("Enter the name of drug #" + count + ": ");
            req_drug = in.nextLine();

            presc_drugs.add(searchDrugName(req_drug));

            if (presc_drugs.get(i) == null) {
                System.out.println("Couldn't find that drug");
                contrinueMessage();
                return;
            }
        }

        Prescriptions.add(new Prescription(presc_per, presc_doc, presc_drugs, LocalDate.now(), LocalDate.now().plusDays(10)));

        contrinueMessage();
        return;
    }

    public void searchPrescAmka(int amka){
        int count = 0;
        for(int i=0; i < Prescriptions.size(); i++) {
            if (amka == Prescriptions.get(i).getAssignedPerson().getAmka()) {
                Prescriptions.get(i).getFullDetails();
                count++;
            }
        }
         if(count == 0)
            System.out.println("Couldn't find a prescription associated with that AMKA");

        contrinueMessage();
    }

    public void searchPrescdoc(int aaae){
        int count = 0;
        for(int i=0; i < Prescriptions.size(); i++){
            if(aaae == Prescriptions.get(i).getAssignedDoctor().getAAAE()) {
                Prescriptions.get(i).getFullDetails();
                count++;
            }
        }
        if(count == 0)
            System.out.println("Couldn't find a prescription associated with that AAAE");

        contrinueMessage();
    }

    public void searchPrescdrug(int code){
        int count = 0;
        for(int i=0; i < Prescriptions.size(); i++){
            for(int j=0; j < Prescriptions.get(i).getAssignedDrugs().size(); j++) {
                if (code == Prescriptions.get(i).getAssignedDrugs().get(j).getCode()) {
                    Prescriptions.get(i).getFullDetails();
                    count++;
                }
            }
        }
        if(count == 0)
            System.out.println("Couldn't find a prescription associated with that drug code");

        contrinueMessage();
    }

    public void searchPrescdate(){
        Scanner in = new Scanner(System.in);
        int count = 0;

        System.out.print("Enter the starting date: ");
        LocalDate start_date = LocalDate.parse(in.nextLine());
        System.out.print("Enter the ending date: ");
        LocalDate end_date = LocalDate.parse(in.nextLine());

        if(start_date.compareTo(end_date) > 0) {
            System.out.println("Ending date can't be before the starting date");
            contrinueMessage();
            return;
        }

        for(int i=0; i < Prescriptions.size(); i++){
            if(start_date.compareTo(Prescriptions.get(i).getDate_Of_Creation()) >= 0 && end_date.compareTo(Prescriptions.get(i).getDate_of_expiration()) <= 0) {
                Prescriptions.get(i).getFullDetails();
                count++;
            }
        }
        if(count == 0)
            System.out.println("Couldn't find a prescription that was/is active in that period of time code");

        contrinueMessage();
    }

    public void findPrescription() {
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.println();
        System.out.println("................Search by:..............");
        System.out.println("........................................");
        System.out.println("1.Specific AMKA.........................");
        System.out.println("2.Date..................................");
        System.out.println("3.Specific Doctor.......................");
        System.out.println("4.Specific Drug.........................");
        System.out.println("5.Exit..................................");
        System.out.println();
        System.out.print("Your choise: ");

        choice = in.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                System.out.print("Enter the AMKA associated with the prescription(s): ");
                searchPrescAmka(in.nextInt());
                break;
            case 2:
                System.out.println("Enter the 2 dates (in yyyy-mm-dd format) associated with the prescription(s)");
                searchPrescdate();
                break;
            case 3:
                in.nextLine();
                System.out.print("Enter the AAAE of the doctor associated with the prescription(s): ");
                searchPrescdoc(in.nextInt());
                break;
            case 4:
                in.nextLine();
                System.out.print("Enter the code of the drug associated with the prescription(s): ");
                searchPrescdrug(in.nextInt());
                break;
            case 5:
                return;
        }

    }

    public void searchPrescAmka_delete(int amka){
        int count = 0;
        for(int i=0; i < Prescriptions.size(); i++) {
            if (amka == Prescriptions.get(i).getAssignedPerson().getAmka()) {
                Prescriptions.remove(i--);
                count++;
            }
        }
        if(count == 0)
            System.out.println("Couldn't find a prescription associated with that AMKA");
    }

    public void printPrescriptions(){
        for(int i=0; i < Prescriptions.size(); i++)
            Prescriptions.get(i).getFullDetails();
    }

}