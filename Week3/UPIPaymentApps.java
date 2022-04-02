package Week3;

class Location {
    String street;
    String city;

    public Location(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "[ Street = " + street + " City = " + city + "]";
    }
}

class Address implements Cloneable {
    Location location;
    String state;
    String country;

    public Address(Location location, String state, String country) {
        this.location = location;
        this.state = state;
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        return "[State : " + state + " Country : " + country + "]";
    }

}

public class UPIPaymentApps implements Cloneable {
    String appName = "BHIM";
    int dailyLimit = 10;
    double maxDailyAmount = 100000;
    Address headOfficeLocation;

    public UPIPaymentApps() {
    }

    public UPIPaymentApps(String appName, int dailyLimit, double maxDailyAmount, Address headOfficeLocation) {
        this.appName = appName;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
        this.headOfficeLocation = headOfficeLocation;
    }

    @Override
    public String toString() {
        return "UPIPaymentApps [ " + "appName = " + appName + "\tMaxDailyAmount = "
                + maxDailyAmount
                + "\tDateLimit = " + dailyLimit + " ]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Location clone1 = new Location(headOfficeLocation.location.street, headOfficeLocation.location.city);
        Address newObj = new Address(clone1, headOfficeLocation.state, headOfficeLocation.country);
        return new UPIPaymentApps(this.appName, this.dailyLimit, this.maxDailyAmount, newObj);
    }

}

class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {

        Location location = new Location("Hakikat Nagar", "Saharanpur");
        Address address = new Address(location, "Uttar Pradesh", "India");
        UPIPaymentApps bhim = new UPIPaymentApps("BHIM", 10, 100000, address);
        UPIPaymentApps paytm = (UPIPaymentApps) bhim.clone();
        paytm.appName = "Paytm";
        paytm.headOfficeLocation.location.city = "NCR";
        paytm.headOfficeLocation.location.street = "Sector 14";
        paytm.headOfficeLocation.state = "Delhi";
        System.out.println("BHIM Object ::");
        System.out.println(bhim.headOfficeLocation + "\n" + bhim.headOfficeLocation.location);
        System.out.println("\n\nPaytm Object ::");
        System.out.println(paytm.headOfficeLocation + "\n" + paytm.headOfficeLocation.location);

    }
}