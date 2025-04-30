package question2;

public class Customer {
    private String customerId;
    private String customerName;
    private String email;
    private String address;
    private String phone;

    public Customer(String customerId, String customerName, String email, String address, String phone) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
