package collections;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

class Employee2 {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee2(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Employee2 emp1 = new Employee2(3, "Vishal Singhal", 34, "male", "HR", 2013, 300000);
        Employee2 emp2 = new Employee2(4, "Amitabh Singh", 35, "male", "Admin", 2014, 500000);
        Employee2 emp3 = new Employee2(5, "Vivek Bhati", 28, "male", "Admin", 2017, 500000);
        Employee2 emp4 = new Employee2(6, "Vipul Diwan", 34, "male", "Account", 2014, 200000);
        Employee2 emp5 = new Employee2(7, "Satish Kumar", 29, "male", "Account", 2017, 75000);
        Employee2 emp6 = new Employee2(8, "Geetika Chauhan", 30, "female", "Admin", 2016, 90000);

        ArrayList<Employee2> list = new ArrayList<>();
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp5);
        list.add(emp6);
        HashMap<String, Integer> map = new HashMap<>();
        for (Employee2 emp : list) {

            map.put(emp.department, map.getOrDefault(emp.department, 0) + 1);
        }
        double maleSalarySum = 0, femaleSalarySum = 0;
        int countMales = 0, countFemales = 0;
        for (Employee2 emp : list) {
            if (emp.gender.equals("male")) {
                maleSalarySum += emp.salary;
                countMales++;

            } else {
                femaleSalarySum += emp.salary;
                countFemales++;
            }
        }
        System.out.println("{feamle=" + femaleSalarySum / countFemales + ", male=" +
                maleSalarySum / countMales + "}");

        double maxSalary = Double.MIN_VALUE;
        Employee2 highestPaidEmp = null;
        for (Employee2 emp : list) {

            if (maxSalary < emp.salary) {
                maxSalary = emp.salary;
                highestPaidEmp = emp;
            }
        }
        System.out.println("Optional" + highestPaidEmp);

        double ageSum = 0;
        for (Employee2 emp : list) {
            ageSum += emp.age;

        }

        HashMap<String, ArrayList<Employee2>> departmentMap = new HashMap<>();
        for (Employee2 emp : list) {

            departmentMap.put(emp.department, new ArrayList<>());
        }
        for (Employee2 emp : list) {

            departmentMap.get(emp.department).add(emp);
        }
        // System.out.println(departmentMap);
        HashMap<String, Double> avgAgeMap = new HashMap<>();

        for (String department : departmentMap.keySet()) {
            ArrayList<Employee2> myEmpArrayList = departmentMap.get(department);
            double avgAgeSum = 0;
            for (int i = 0; i < myEmpArrayList.size(); i++) {
                avgAgeSum += myEmpArrayList.get(i).age;

            }
            avgAgeMap.put(department, avgAgeSum / myEmpArrayList.size());
        }

        System.out.println(avgAgeMap);
        Employee2 seniorMostEmployee = null;
        int minYearOfJoining = Integer.MAX_VALUE;
        for (Employee2 emp : list) {
            if (minYearOfJoining > emp.yearOfJoining) {
                minYearOfJoining = emp.yearOfJoining;
                seniorMostEmployee = emp;
            }
        }
        System.out.println(seniorMostEmployee);

        Employee2 youngestEmployee = null;
        int minAge = Integer.MAX_VALUE;
        for (Employee2 emp : list) {
            if (minAge > emp.age) {
                minAge = emp.age;
                youngestEmployee = emp;
            }
        }
        System.out.println(youngestEmployee);

        Iterator<String> iterator = departmentMap.keySet().iterator();
        System.out.print("{");
        while (iterator.hasNext()) {
            String key = iterator.next();
            int value = departmentMap.get(key).size();
            System.out.print(key + ":" + value + " ");
        }
        System.out.println("}");

        System.out.println("{female=" + countFemales + ",male=" + countMales + "}");

    }
}
