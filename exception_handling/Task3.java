package exception_handling;

import java.util.Arrays;
import java.util.Scanner;

class User {
    String email;
    String password;
    String firstName;
    String lastName;
    String[] phoneNubers;

    public User(String email, String password, String firstName, String lastName, String[] phoneNubers) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNubers = phoneNubers;
    }

    @Override
    public String toString() {
        return "user [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
                + ", phoneNubers=" + Arrays.toString(phoneNubers) + "]";
    }

    void validate() {
        if (!(validateName(firstName) && validateName(lastName)))
            throw new IllegalArgumentException("First name or last name does not contain alphabets");
        if (!validatePassword(password))
            throw new IllegalArgumentException(
                    "Password should be atleast 8 and 16 chars and should contain atleast one digit");
        if (!validateEmail(email))
            throw new IllegalArgumentException("Invalid email");

        if (!validatePhoneNumber(phoneNubers))
            throw new IllegalArgumentException("Invalid Phone numbers");

    }

    private boolean validateName(String name) {
        int strlen = name.length();

        for (int i = 0; i < strlen; i++) {
            int a = (int) name.charAt(i);
            if (!((a >= 97 && a <= 122) || (a >= 65 && a <= 90)))
                return false;

        }
        return true;
    }

    private boolean validatePassword(String password) {
        int len = password.length();
        if ((len < 8 || len > 16))
            return false;
        for (int i = 0; i < len; i++) {
            int a = (int) password.charAt(i);
            if ((a < 48 && a > 57))
                return false;

        }
        return true;
    }

    private boolean validateEmail(String email) {
        int strlen = email.length();
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < strlen; i++) {
            if (email.charAt(i) == ' ')
                return false;
            if (email.charAt(i) == '@')
                flag1 = true;
            if (email.charAt(i) == '.')
                flag2 = true;

        }
        return flag1 && flag2;

    }

    private boolean validatePhoneNumber(String phoneNumbers[]) {
        if (phoneNumbers[0].length() != 10 || phoneNumbers[1].length() != 10)
            return false;
        return containsDigits(phoneNumbers[0]) && containsDigits(phoneNumbers[1]);

    }

    private boolean containsDigits(String mystr) {
        int len = mystr.length();
        for (int i = 0; i < len; i++) {
            int a = (int) password.charAt(i);
            if ((a < 48 && a > 57))
                return false;

        }
        return true;
    }

}

class PhoneNumber {
    String countryCode;
    String phNo;

    PhoneNumber(String countryCode, String phNo) {
        this.countryCode = countryCode;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return countryCode + "-" + phNo;
    }
}

class IndianPhoneNumber extends PhoneNumber {
    IndianPhoneNumber(String phoneNumber) {
        super("+91", phoneNumber);
    }

}

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email...");

        String email = sc.next();

        sc.nextLine();

        System.out.println("Enter password");
        String password = sc.next();
        sc.nextLine();

        System.out.println("Enter firstName");
        String firstname = sc.next();
        sc.nextLine();

        System.out.println("Enter lastName");
        String lastName = sc.next();
        sc.nextLine();

        System.out.println("enter two phone numbers");
        String phoneNumbers[] = new String[2];
        phoneNumbers[0] = sc.next();
        sc.nextLine();
        phoneNumbers[1] = sc.next();

        User user = new User(email, password, firstname, lastName, phoneNumbers);
        System.out.println(user);
        // try {
        user.validate();

        // } catch (IllegalArgumentException e) {
        // System.out.println(e.getMessage());
        // }

        String fullName = firstname + lastName;
        System.out.println("Full Name is " + fullName);

        IndianPhoneNumber[] indianPhoneNumbers = new IndianPhoneNumber[2];
        indianPhoneNumbers[0] = new IndianPhoneNumber(phoneNumbers[0]);
        indianPhoneNumbers[1] = new IndianPhoneNumber(phoneNumbers[1]);
        System.out.println(indianPhoneNumbers[0]);
        System.out.println(indianPhoneNumbers[1]);
    }
}
