Project Overview
The Hospital Management System is a Java console-based application designed to manage patient records, appointment scheduling, and medical history efficiently. It uses core Java concepts and appropriate data structures to reduce manual record handling and improve data organization.
Features
Patient Registration
Stores patient details:
Patient ID
Name
Age
Gender
Contact Number
Address
Appointment Booking
Books appointments using First-Come, First-Served (FCFS) method.
Uses a Queue to manage appointment order.
Medical History Tracking
Maintains a separate medical history file for each patient.
Stores:
Diagnosis
Prescription
Appends new records after every visit.
Data Persistence
Patient records are saved to a file (patients.dat) using file handling.
Data is retained even after the program exits.
Data Structures Used
Data Structure	Purpose
Structure (Class)	Store patient details
Linked List	Dynamic addition and deletion of patient records
Queue	Appointment scheduling (FCFS)
Modules / Functions
Linked List Operations
addPatient() – Register a new patient
displayPatients() – Display all patient details
findPatient() – Search patient by ID
Queue Operations
enqueueAppointment() – Add patient ID to appointment queue
dequeueAppointment() – Complete appointment
File Handling
Saves patient list to patients.dat
Creates individual files: patient_<id>.txt
How to Run the Project (VS Code)
Prerequisites
JDK 8 or above
VS Code
Java Extension Pack
Compile the Code
javac Patient.java HospitalManagementSystem.java
Run the Program
java HospitalManagementSystem
Sample Output
--- Hospital Management System ---
1. Register Patient
2. Display Patients
3. Book Appointment
4. Complete Appointment
5. Exit
Applications
Small clinics and hospitals
Educational mini-project
Demonstrates data structures in real-world use cases

