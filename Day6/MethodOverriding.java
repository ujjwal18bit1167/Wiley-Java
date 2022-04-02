package Day6;

class Parent {
    String firstname;
    String lastname;

    Parent() {
        this.lastname = "Das";
    }

    Parent(String firstname) {
        this(); // or this.lastname = "Das";
        this.firstname = firstname;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return String.format("Firstname: %s %nLastname: %s", this.firstname, this.lastname);
    }
}

class Child extends Parent {
    Child() {
        super();
    }

    Child(String firstname) {
        // super() (calls implicitly)

        this.firstname = firstname;
        // or super(firstname);
    }

    @Override
    public String toString() {
        System.out.println("CHILD OBJECT::");
        return super.toString();
        // return String.format("Firstname: %s %nLastname: %s", this.firstname,
        // this.lastname);
    }
}

public class MethodOverriding {
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println(parent.toString());

        System.out.println();
        Parent parent2 = new Parent("akash");

        System.out.println(parent2.toString());
        Child child = new Child("ABC"); // lastname is automatically set now because super() was called automatically
        System.out.println(child.toString());
    }
}
