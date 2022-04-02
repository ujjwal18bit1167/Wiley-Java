package multithreading;

import java.util.Arrays;
import java.util.ArrayList;

class Height {
    int feet;
    int inches;

    public Height(int feet, int inches) {
        this.feet = feet;
        this.inches = inches;
    }

    @Override
    public String toString() {
        return "Height [feet=" + feet + ", inches=" + inches + "]";
    }

    public int convertToInches() {
        return feet * 12 + inches;
    }

}

abstract class Student {
    String name;

    Height height;
    String branch;

    public Student(String name, String branch, Height height) {
        this.name = name;
        this.branch = branch;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Student [branch=" + branch + ", height=" + height + ", name=" + name + "]";
    }

    // static Student[] sortByHeight(Student arr[]) {
    // int n = arr.length;
    // Student new_arr[] = new Student[n];

    // for (int i = 0; i < n; i++)
    // new_arr[i] = arr[i];

    // for (int i = 0; i < n - 1; i++)
    // for (int j = 0; j < n - i - 1; j++)
    // if (compareByAge(new_arr[j], new_arr[j + 1]) == 1) {
    // // swap arr[j+1] and arr[j]
    // Student temp = new_arr[j];
    // new_arr[j] = new_arr[j + 1];
    // new_arr[j + 1] = temp;
    // }
    // return new_arr;
    // }

    public static int compareByHeight(Student s1, Student s2) {
        if (s1.height.feet > s2.height.feet) {
            return 1;
        } else if (s1.height.feet < s2.height.feet) {
            return -1;
        } else {
            if (s1.height.inches < s2.height.inches) {
                return -1;
            } else if (s1.height.inches > s2.height.inches) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}

class EEEStudent extends Student {

    public EEEStudent(String name, Height height) {
        super(name, "EEE", height);
    }

}

class ECEStudent extends Student {

    public ECEStudent(String name, Height height) {
        super(name, "ECE", height);
    }

}

class CSEStudent extends Student {

    public CSEStudent(String name, Height height) {
        super(name, "CSE", height);
    }

}

class StudentAdministration {
    Student[] students;

    public StudentAdministration(Student[] students) {
        this.students = students;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public void sortByHeight() {
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < this.students.length - 1; i++) {
                if (Student.compareByHeight(this.students[i], this.students[i + 1]) == -1) {
                    Student temp = this.students[i];
                    this.students[i] = this.students[i + 1];
                    this.students[i + 1] = temp;
                }
            }
        }

    }

    public void displaySortedEEEStudents() {

        ArrayList<Student> EEEStudents = new ArrayList<Student>();

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].branch.equals("EEE")) {
                EEEStudents.add(this.students[i]);
            }
        }

        Student[] eeeStudents = EEEStudents.toArray(new EEEStudent[EEEStudents.size()]);
        synchronized (this) {
            for (Student s : eeeStudents) {
                notifyAll();
                System.out.println(s);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void displaySortedECEStudents() {

        ArrayList<Student> ECEStudents = new ArrayList<Student>();

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].branch.equals("ECE")) {
                ECEStudents.add(this.students[i]);
            }
        }

        Student[] eceStudents = ECEStudents.toArray(new ECEStudent[ECEStudents.size()]);
        synchronized (this) {
            for (Student s : eceStudents) {
                System.out.println(s);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notifyAll();
            }
        }

    }

    public void displaySortedCSEStudents() {

        ArrayList<Student> CSEStudents = new ArrayList<Student>();

        for (int i = 0; i < this.students.length; i++) {
            if (this.students[i].branch.equals("CSE")) {
                CSEStudents.add(this.students[i]);
            }
        }

        Student[] cseStudents = CSEStudents.toArray(new CSEStudent[CSEStudents.size()]);

        synchronized (this) {
            for (Student s : cseStudents) {
                notifyAll();
                System.out.println(s);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class HighMidLow {
    public static void main(String[] args) {
        CSEStudent student1 = new CSEStudent("Ujjwal", new Height(4, 5));
        EEEStudent student2 = new EEEStudent("Ram", new Height(5, 5));
        ECEStudent student3 = new ECEStudent("Mohan", new Height(4, 3));
        EEEStudent student4 = new EEEStudent("Nishith", new Height(2, 4));
        CSEStudent student5 = new CSEStudent("Shivank", new Height(6, 2));
        ECEStudent student6 = new ECEStudent("Ali", new Height(5, 4));

        Student[] student = new Student[] { student1, student2, student3, student4, student5, student6 };
        StudentAdministration studentAdministration = new StudentAdministration(student);
        studentAdministration.sortByHeight();

        new Thread() {
            public void run() {
                studentAdministration.displaySortedEEEStudents();
            }
        }.start();

        new Thread() {
            public void run() {
                studentAdministration.displaySortedECEStudents();
            }
        }.start();

        new Thread() {
            public void run() {
                studentAdministration.displaySortedCSEStudents();
            }
        }.start();

    }
}
