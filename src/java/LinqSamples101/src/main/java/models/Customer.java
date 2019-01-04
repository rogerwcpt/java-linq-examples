package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.*;

public class Customer {
    @JsonProperty("id")
    public String customerId;
    @JsonProperty("name")
    public String companyName;
    public String address;
    public String city;
    public String region;
    @JsonProperty("postalcode")
    public String postalCode;
    public String country;
    public String phone;
    public String fax;
    @JsonIgnore
    public List<Order> orders;
    @JsonProperty("orders")
    public Orders ordersList;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", orders='" + orders.size() + '\'' +
                '}';
    }
}
