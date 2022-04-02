class Tata {
    void displayParentCompany() {
        System.out.println("Outer class:: Tata");
    }

    static class TataMotors {
        void display() {
            System.out.println("Inside static nested class-TataMotors");
        }
    }

    static class TataSteel {
        void display1() {
            System.out.println("Inside static nested class-TataMotors");
        }

        static void display() {
            System.out.println("Inside static nested class-TataSteel");
        }
    }
}

public class StaticNestedClass {
    public static void main(String[] args) {
        Tata.TataMotors tataMotors = new Tata.TataMotors();
        tataMotors.display();
        Tata.TataSteel.display();
        // displayParentCompany();
        // Tata.TataSteel.display1(); not allowed because we need to create object to
        // access non
        // static methods
    }
}
