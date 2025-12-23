import java.util.*;
import java.io.*;

public class HospitalManagementSystem {

    static LinkedList<Patient> patientList = new LinkedList<>();
    static Queue<Integer> appointmentQueue = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);

    // Register Patient
    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        patientList.add(new Patient(id, name, age, gender, contact, address));
        savePatients();
        System.out.println("Patient Registered Successfully!");
    }

    // Display Patients
    static void displayPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        for (Patient p : patientList) {
            p.display();
        }
    }

    // Find Patient
    static Patient findPatient(int id) {
        for (Patient p : patientList) {
            if (p.id == id)
                return p;
        }
        return null;
    }

    // Book Appointment
    static void enqueueAppointment() {
        System.out.print("Enter Patient ID for appointment: ");
        int id = sc.nextInt();

        if (findPatient(id) != null) {
            appointmentQueue.add(id);
            System.out.println("Appointment booked successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Complete Appointment
    static void dequeueAppointment() {
        if (appointmentQueue.isEmpty()) {
            System.out.println("No appointments pending.");
            return;
        }

        int id = appointmentQueue.poll();
        System.out.println("Appointment completed for Patient ID: " + id);
        addMedicalHistory(id);
    }

    // Medical History
    static void addMedicalHistory(int id) {
        sc.nextLine();
        System.out.print("Enter Diagnosis: ");
        String diagnosis = sc.nextLine();

        System.out.print("Enter Prescription: ");
        String prescription = sc.nextLine();

        try {
            FileWriter fw = new FileWriter("patient_" + id + ".txt", true);
            fw.write("Diagnosis: " + diagnosis + "\n");
            fw.write("Prescription: " + prescription + "\n");
            fw.write("-----------------------\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Error writing medical history.");
        }
    }

    // Save Patients
    static void savePatients() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("patients.dat"));
            oos.writeObject(patientList);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving patient data.");
        }
    }

    // Load Patients
    static void loadPatients() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("patients.dat"));
            patientList = (LinkedList<Patient>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // File may not exist initially
        }
    }

    // Main Method
    public static void main(String[] args) {
        loadPatients();
        int choice;

        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Register Patient");
            System.out.println("2. Display Patients");
            System.out.println("3. Book Appointment");
            System.out.println("4. Complete Appointment");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> displayPatients();
                case 3 -> enqueueAppointment();
                case 4 -> dequeueAppointment();
                case 5 -> System.out.println("Thank You!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }
}
