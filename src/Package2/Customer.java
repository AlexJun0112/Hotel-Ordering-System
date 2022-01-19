package Package2;

public class Customer {

    private int customerID = 0;
    private String name;
    private String contactNo;
    private String ICNo;
    private String passportNo;
    private String email;

    public Customer(String name, String contactNo, String ICNo, String passportNo, String email) {
        this.name = name;
        this.contactNo = contactNo;
        this.ICNo = ICNo;
        this.passportNo = passportNo;
        this.email = email;
        customerID++;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getICNo() {
        return ICNo;
    }

    public void setICNo(String ICNo) {
        this.ICNo = ICNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printCustomerInfo() {
        System.out.printf("ID: %-5d\nName: %-30s\nContact No: %-20s\nIC No: %-20s\nPassport No: %-20s\nEmail Address: %-30s", getCustomerID(), getName(), getContactNo(), getICNo(), getPassportNo(), getEmail());
        System.out.println();
    }
}
