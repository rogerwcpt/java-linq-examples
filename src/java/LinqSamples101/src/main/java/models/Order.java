package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Order {

    @JsonProperty("id")
    public Integer orderId;
    @JsonProperty("orderdate")
    public Date orderDate;
    public Double total;

    @Override
    public String toString() {
        return "(Order " +
                "id=" + orderId +
                ", total=" + total +
                ')';
    }
}

