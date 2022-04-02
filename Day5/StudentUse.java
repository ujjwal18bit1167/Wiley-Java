package Day5;

class Student {
    private int rollNo;
    private String name;

    Student() {
        System.out.println("Non parameterized constructor ");
    }

    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    Student(int rollNo) {
        this.rollNo = rollNo;
    }

    Student(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll No. " + rollNo);
    }

    int getRollNo() {
        return rollNo;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}

public class StudentUse {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(25, "Ujjwal Gupta");
        System.out.println("\nStudent2 's name is " + s2.getName());
        Student s3 = new Student(12);
        System.out.println("\nStudent3's roll number is " + s3.getRollNo());
        Student s4 = new Student("Ujjwal Gupta");
        s4.setRollNo(55);
        System.out.println("\nStudent4 's details are....");
        s4.display();
    }

}
