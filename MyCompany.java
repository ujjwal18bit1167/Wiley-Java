
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

interface Client {
    double getCharges();

    double calculatePayment(Date invoiceDate);

    void sendEmail(double payment);
}

abstract class Service implements Client, Comparable<Service> {

    int id;
    double charges;
    Date dateOfAgreement;

    public Service(int id, double charges, Date dateOfAgreement) {
        this.id = id;
        this.charges = charges;
        this.dateOfAgreement = dateOfAgreement;
    }

    @Override
    public double getCharges() {
        return this.charges;
    }

    @Override
    public void sendEmail(double payment) {
        System.out.println("Your Pending amount is: " + payment);
    }

    @Override
    public double calculatePayment(Date invoiceDate) {
        long diff = invoiceDate.getTime() - this.dateOfAgreement.getTime();
        diff = diff / (1000 * 60 * 60 * 24) % 365;
        return diff * this.getCharges();
    }

    @Override
    public int compareTo(Service o) {
        if (this.id == o.id)
            return 0;
        if (this.id > o.id)
            return 1;
        return -1;
    }
}

class Customer extends Service {
    String name;
    String email;

    public Customer(int id, String name, String email, double charges, Date dateOfAgreement) {
        super(id, charges, dateOfAgreement);
        this.name = name;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer [charges=" + charges + ", dateOfAgreement=" +
                dateOfAgreement + ", email=" + email + ", id="
                + id + ", name=" + name + "]";
    }

}

class Business extends Service {
    String name;
    String email;
    double gsRate;

    public Business(int id, String name, String email, double charges, double gsRate, Date dateOfAgreement) {
        super(id, charges, dateOfAgreement);
        this.name = name;
        this.email = email;
        this.gsRate = gsRate;
    }

    double getGST() {
        return 0;
    }

    @Override
    public String toString() {
        return "Business [charges=" + charges + ", dateOfAgreement=" +
                dateOfAgreement + ", email=" + email
                + ", gsRate=" + gsRate + ", id=" + id + ", name=" + name + "]";
    }

}

public class MyCompany {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
        Service cust2 = new Customer(1, "John", "john@xyz.com", 200, sdf.parse("20-02-2022"));
        Service cust1 = new Customer(2, "Jack", "jack@abc.com", 100, sdf.parse("01-02-2022"));

        Service bus2 = new Business(11, "X Corp", "xcorp@xc.com", 15000, 10.5, sdf.parse("01-01-2020"));

        Service bus1 = new Business(12, "E Corp", "ecorp@ec.com", 20000, 9.5, sdf.parse("01-04-2021"));

        List<Service> clientArr = new ArrayList<>();

        clientArr.add(cust1);
        clientArr.add(cust2);
        clientArr.add(bus1);
        clientArr.add(bus2);

        double[] pendingArr = new double[4];
        for (int i = 0; i < pendingArr.length; i++) {
            pendingArr[i] = clientArr.get(i).calculatePayment(sdf.parse("31-03-2022"));
            clientArr.get(i).sendEmail(pendingArr[i]);
        }

        Collections.sort(clientArr);

        clientArr.forEach(System.out::println);

        clientArr.sort((Service c1, Service c2) -> (int) (c2.getCharges() - c1.getCharges()));
        clientArr.forEach(System.out::println);
        System.out.println("\n\n\n");
        clientArr.sort((Service c1, Service c2) -> (int) (c1.dateOfAgreement.getTime() - c2.dateOfAgreement.getTime()));
        clientArr.forEach(System.out::println);

    }
}