package linq;

import models.Customer;
import models.Product;
import support.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LinqFilters {

    public static void Linq1() {
        int[] numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        List<Integer> lownumbers = Arrays
                .stream(numbers)
                .boxed()
                .filter(x -> x < 5)
                .collect(Collectors.toList());

        System.out.println("Numbers < 5:");
        lownumbers.forEach(System.out::println);
    }

    public static void Linq2() {
        List<Product> products = Data.getProductList();

        List<Product> sold_out_products = products
                .stream()
                .filter(p -> p.unitsInStock == 0)
                .collect(Collectors.toList());

        System.out.println("Sold out products:");
        sold_out_products.forEach(p -> System.out.println(String.format("%s is sold out!", p.productName)));
    }

    public static void Linq3() {
        List<Product> products = Data.getProductList();

        List<Product> sold_out_products = products
                .stream()
                .filter(p -> p.unitsInStock > 0 && p.unitPrice > 3.00)
                .collect(Collectors.toList());

        System.out.println("In-stock products that cost more than 3.00:");
        sold_out_products.forEach(p -> System.out.println(String.format("%s is in stock and costs more than 3.00.", p.productName)));
    }

    public static void Linq4() {
        List<Customer> customers = Data.getCustomerList();

        List<Customer> waCustomers = customers
                .stream()
                .filter(c -> "WA".equals(c.region))
                .collect(Collectors.toList());

        System.out.println("Customers from Washington and their orders:");
        waCustomers.forEach(c -> {
            System.out.println(String.format("%s : %s", c.customerId, c.companyName));
            c.orders.forEach(o -> System.out.println(String.format("     Order %s: %s\"", o.orderId, o.orderDate)));
        });
    }
}
