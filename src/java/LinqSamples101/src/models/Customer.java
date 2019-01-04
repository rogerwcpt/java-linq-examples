package models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public String customerId;
    public String companyName;
    public String address;
    public String city;
    public String region;
    public String postalCode;
    public String country;
    public String phone;
    public String fax;
    public List<Order> orders;

    public Customer() {
        orders = new ArrayList<Order>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orders='" + orders.size() + '\'' +
                '}';
    }
}
