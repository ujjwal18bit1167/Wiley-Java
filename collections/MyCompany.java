package collections;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

interface Client {
    double getCharges();

    double calculatePayment(GregorianCalendar invoiceDate);

    void sendEmail(double payment);

}

class ServiceClient implements Client, Comparable<ServiceClient> {
    int id;
    String name;
    String email;
    double charges;
    GregorianCalendar dateOfAgreement;

    public ServiceClient(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.charges = charges;
        this.dateOfAgreement = dateOfAgreement;
    }

    @Override
    public double getCharges() {
        return charges;
    }

    public long calculateDays(GregorianCalendar invoiceDate) {
        Date d1 = invoiceDate.getTime();

        long diff = d1.getTime() - dateOfAgreement.getTime().getTime();
        return diff / (1000 * 60 * 60 * 24);
    }

    public double calculatePayment(GregorianCalendar invoiceDate) {

        return charges * calculateDays(invoiceDate);
    }

    @Override
    public void sendEmail(double payment) {
        System.out.println("The pending amount is " + payment);
    }

    // @Override
    // public String toString() {
    // return "ServiceClient [charges=" + charges + ", dateOfAgreement=" +
    // dateOfAgreement + ", email=" + email
    // + ", id=" + id + ", name=" + name + "]";
    // }

    @Override
    public int compareTo(ServiceClient o) {
        if (this.id < o.id)
            return -1;
        else if (this.id > o.id)
            return 1;
        else
            return 0;
    }

}

class Customer extends ServiceClient {

    public Customer(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        super(id, name, email, charges, dateOfAgreement);
    }

    @Override
    public String toString() {
        return "Customer [charges=" + charges + ", dateOfAgreement=" + dateOfAgreement.getTime() + ", email=" + email
                + ", id="
                + id + ", name=" + name + "]";
    }

}

class Business extends ServiceClient {
    double gstRate = 15;

    public Business(int id, String name, String email, double charges, GregorianCalendar dateOfAgreement) {
        super(id, name, email, charges, dateOfAgreement);
    }

    @Override
    public double calculatePayment(GregorianCalendar invoiceDate) {
        double payment = calculateDays(invoiceDate) * charges;
        return payment + (payment * gstRate) / 100;
    }

    @Override
    public String toString() {
        return "Business [GST_RATE=" + gstRate + ", charges=" + charges + ", dateOfAgreement="
                + dateOfAgreement.getTime()
                + ", email=" + email + ", id=" + id + ", name=" + name + "]";
    }

}

public class MyCompany {
    public static void main(String[] args) {
        ServiceClient serviceClient1 = new Customer(1, "Ram", "Ram@gmail.com", 1000,
                new GregorianCalendar(2022, 1, 12));
        ServiceClient serviceClient2 = new Customer(2, "Sohan", "Sohan@gmail.com", 2000,
                new GregorianCalendar(2020, 3, 11));
        ServiceClient serviceClient3 = new Business(3, "ujjwal", "ujjwal@gmail.com", 2500,
                new GregorianCalendar(2018, 1, 28));
        ServiceClient serviceClient4 = new Business(4, "Sanyam", "sanyam@gmail.com", 1500,
                new GregorianCalendar(2017, 5, 18));
        ArrayList<ServiceClient> arr = new ArrayList<>();
        arr.add(serviceClient1);
        arr.add(serviceClient2);
        arr.add(serviceClient3);
        arr.add(serviceClient4);

        ArrayList<Double> pendingPayments = new ArrayList<>();
        for (ServiceClient client : arr) {
            pendingPayments.add(client.calculatePayment(new GregorianCalendar(2022, 3,
                    31)));
        }
        int count = 1;
        for (Double payment : pendingPayments) {
            System.out.println("Pending Payment for client" + count + " is " + payment);
            count++;
        }

        System.out.println("Sending emails.......");
        for (int i = 0; i < 4; i++) {
            arr.get(i).sendEmail(pendingPayments.get(i));
        }
        System.out.println("Sorting according to IDs.....");
        Collections.sort(arr);
        arr.forEach(System.out::println);

        System.out.println("Sorting according charges in descending order ");
        Collections.sort(arr, new Comparator<ServiceClient>() {
            @Override
            public int compare(ServiceClient o1, ServiceClient o2) {
                return (int) (o2.charges - o1.charges);
            }
        });

        arr.forEach(System.out::println);

        System.out.println("Sorting according to Agreement Date ");
        Collections.sort(arr, new Comparator<ServiceClient>() {
            @Override
            public int compare(ServiceClient o1, ServiceClient o2) {
                long ans = o1.dateOfAgreement.getTimeInMillis() - o2.dateOfAgreement.getTimeInMillis();
                if (ans > 0)
                    return 1;
                else if (ans < 0)
                    return -1;
                else
                    return 0;

            }
        });
        arr.forEach(System.out::println);

    }
}
