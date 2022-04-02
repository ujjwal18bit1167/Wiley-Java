package Day6;

class person {
  private String name;

  person(String name) {
    this.name = name;
  }

  public person() {
    name = "";

  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    person other = (person) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

class employee extends person {
  private double salary;
  private int year;
  private final String UAN;

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    employee other = (employee) obj;
    if (UAN == null) {
      if (other.UAN != null)
        return false;
    } else if (!UAN.equals(other.UAN))
      return false;
    if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
      return false;
    if (year != other.year)
      return false;
    return true;
  }

  employee() {
    super();
    this.salary = 0;
    this.year = 0;
    this.UAN = "";
  }

  employee(String name, double salary, int year, String UAN) {
    super(name);
    this.salary = salary;
    this.year = year;
    this.UAN = UAN;

  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getUAN() {
    return UAN;
  }

  // public void setUAN(String uAN) {
  // UAN = uAN;
  // }

  void displayDetails() {
    System.out.println("Name:" + this.getName() + "\n" + "Salary :" + this.getSalary() + "\nJoining year : "
        + this.getYear() + "\nUAN : " + this.getUAN());
  }

}

public class inheritance {
  public static void main(String[] args) {
    employee e1 = new employee("Ujjwal", 750000.54, 2018, "100877449");
    employee e2 = new employee("Rohan", 855000.28, 2015, "974363202");
    employee e3 = new employee("Rohan", 855000.28, 2015, "974363202");
    employee e4 = new employee();

    person p1 = new person("Ujjwal");
    e1.displayDetails();
    System.out.println();
    e2.displayDetails();
    System.out.println();
    e4.displayDetails();
    System.out.println(e1.equals(p1));
    System.out.println(e1.equals(e2));
    System.out.println(e2.equals(e3));
  }
}
