package collections;

import java.util.ArrayList;

class Employee implements Comparable<Employee> {
    protected long employeeId;
    protected String firstName;
    protected String lastName;

    public Employee(long employeeId, String firstName, String lastName) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEqual(Employee other) {
        if (other == null)
            return false;
        else if (this.getClass() != other.getClass())
            return false;
        else if (this == other)
            return true;
        else if ((this.employeeId == other.employeeId) && (this.firstName == other.firstName)
                && (this.lastName == other.lastName))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Employee o) {
        if (this.employeeId < o.employeeId)
            return -1;
        else if (this.employeeId > o.employeeId)
            return 1;
        else
            return 0;
    }

}

public class EmployeeDriver {
    public static void main(String[] args) {
        Employee e1 = new Employee(2, "Ujjwal", "Gupta");
        Employee e2 = new Employee(1, "Ram", "Sharma");
        Employee e3 = new Employee(3, "Shyam", "Kaushik");
        ArrayList<Employee> arr = new ArrayList<>();
        arr.add(e1);
        arr.add(e2);
        arr.add(e3);
        System.out.println(e1.isEqual(e2));

        arr.forEach(ele -> System.out.println(ele));
        arr.forEach(System.out::println);
        if (e1.compareTo(e3) == 0)
            System.out.println("Employee ids of e1 and e3 are same");

        System.out.println("Performing sorting.....");
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr.get(j).compareTo(arr.get(j + 1)) == 1) {
                    Employee temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                }
            }
        }
        System.out.println("After sorting we get");
        System.out.println(arr);
    }
}
