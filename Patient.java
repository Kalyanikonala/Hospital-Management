import java.io.Serializable;

public class Patient implements Serializable {
    int id;
    String name;
    int age;
    String gender;
    String contact;
    String address;

    public Patient(int id, String name, int age, String gender, String contact, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
        this.address = address;
    }

    public void display() {
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Contact    : " + contact);
        System.out.println("Address    : " + address);
        System.out.println("----------------------------");
    }
}
