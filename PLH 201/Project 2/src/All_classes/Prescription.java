package All_classes;

import java.time.LocalDate;
import java.util.*;

public class Prescription {
    private int code;
    private LocalDate Date_Of_Creation;
    private LocalDate Date_of_expiration;
    private Person assignedPerson;
    private Doctor assignedDoctor;
    private List<Drug> assignedDrugs;
    private float Total_cost;
    private static int number=0;

////////////////////CONSTRUCTORS///////////////////////

    public Prescription(Person person, Doctor doctor, List<Drug> List_of_drugs, LocalDate now_date, LocalDate exp_date){
        this.code = ++number;
        assignedPerson = person;
        assignedDoctor = doctor;
        assignedDrugs = List_of_drugs;
        Date_Of_Creation = now_date;
        Date_of_expiration = exp_date;
        Total_cost = calculateCost();
    }

    public Prescription(Person person, Doctor doctor, Drug d1, Drug d2, Drug d3, Drug d4, LocalDate now_date, LocalDate exp_date){
        List<Drug> insertedDrugs =new ArrayList<Drug>();

        if(d1 != null)
        insertedDrugs.add(d1);
        if(d2 != null)
        insertedDrugs.add(d2);
        if(d3 != null)
        insertedDrugs.add(d3);
        if(d4 != null)
        insertedDrugs.add(d4);

        this.code = ++number;
        assignedPerson = person;
        assignedDoctor = doctor;
        assignedDrugs = insertedDrugs;
        Date_Of_Creation = now_date;
        Date_of_expiration = exp_date;
        Total_cost = calculateCost();
    }

//////////////////////Getters/////////////////////////

    public LocalDate getDate_Of_Creation() {
        return Date_Of_Creation;
    }

    public LocalDate getDate_of_expiration() {
        return Date_of_expiration;
    }

    public Person getAssignedPerson() {
        return assignedPerson;
    }

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    public List<Drug> getAssignedDrugs() {
        return assignedDrugs;
    }

/////////////////////Methods/////////////////////////

    public float calculateCost(){
        float cost=0;
        for(int i=0; i < assignedDrugs.size(); i++)
            cost += assignedDrugs.get(i).getPrice();

        return cost;
    }

    public void printDrugs(){
        for(int i=0; i < assignedDrugs.size(); i++)
            System.out.print(assignedDrugs.get(i).getName() + " | ");
        System.out.println();
    }

    public void getFullDetails(){
        System.out.println();
        System.out.println("Prescription Code: " + code);
        System.out.println("Assigned person: " + assignedPerson.getFull_name());
        System.out.println("Assigned doctor: " + assignedDoctor.getFull_name());
        System.out.print("Assigned drugs: " );
        printDrugs();
        System.out.println("Date of creation: " + Date_Of_Creation);
        System.out.println("Date of expiration: " + Date_of_expiration);
        System.out.println("Total cost: " + Total_cost);
    }

}
