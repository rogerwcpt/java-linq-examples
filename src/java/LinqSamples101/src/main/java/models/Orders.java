package models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Orders {
    @JsonProperty("order")
    public List<Order> orderList;
}
