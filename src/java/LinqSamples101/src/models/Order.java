package models;

import java.util.Date;

public class Order {

    public Integer orderId;
    public Date orderDate;
    public Double total;

    public Order(Integer orderId, Date orderDate, Double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.total = total;
    }

    @Override
    public String toString() {
        return "(Order " +
                "id=" + orderId +
                ", total=" + total +
                ')';
    }
}

