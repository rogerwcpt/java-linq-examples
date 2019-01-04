package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Customers {
    @JsonProperty("customers")
    public List<Customer> customers;

}
