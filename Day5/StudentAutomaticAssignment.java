package Day5;

class UniversityStudent {
    private int rollNo;
    private String name;
    private String hometown;
    static final String university = "ABC Univeristy";
    static int count = 1;

    UniversityStudent() {
        this.rollNo = count;
        count++;
        this.name = "New Student";
        hometown = "XYZ";

    }

    UniversityStudent(String name) {
        this();
        this.name = name;
    }

    UniversityStudent(String name, String hometown) {
        this(name);

        this.hometown = hometown;
    }

    void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll No. :" + rollNo);
        System.out.println("Hometown :" + hometown);
        System.out.println("University: " + university);
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

}

public class StudentAutomaticAssignment {

    public static void main(String[] args) {
        UniversityStudent s1 = new UniversityStudent();
        System.out.println("Student1 's details  are....");
        s1.display();

        UniversityStudent s2 = new UniversityStudent("Ujjwal Gupta");
        System.out.println("\nUniversityStudent2 's details are....");
        s2.display();

        UniversityStudent s3 = new UniversityStudent("Ujjwal Gupta", "Saharanpur");
        System.out.println("\nUniversityStudent3 's details are... ");
        s3.display();

    }

}
