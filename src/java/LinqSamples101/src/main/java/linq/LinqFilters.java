package linq;

import support.Data;

import java.util.Arrays;
import java.util.stream.IntStream;

public class LinqFilters extends LinqBase {

    public static void Linq1() {
        var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var lownumbers = Arrays.stream(numbers)
                .filter(x -> x < 5);

        print("Numbers < 5:");
        lownumbers.forEach(System.out::println);
    }

    public static void Linq2() {
        var products = Data.getProductList();

        var sold_out_products = products.stream()
                .filter(p -> p.unitsInStock == 0);

        print("Sold out products:");
        sold_out_products.forEach(p -> print("%s is sold out!", p.productName));
    }

    public static void Linq3() {
        var products = Data.getProductList();

        var sold_out_products = products.stream()
                .filter(p -> p.unitsInStock > 0 && p.unitPrice > 3.00);

        print("In-stock products that cost more than 3.00:");
        sold_out_products.forEach(p -> print("%s is in stock and costs more than 3.00.", p.productName));
    }

    public static void Linq4() {
        var customers = Data.getCustomerList();

        var waCustomers = customers.stream()
                .filter(c -> "WA".equals(c.region));

        print("Customers from Washington and their orders:");
        waCustomers.forEach(c -> {
            print(String.format("%s : %s", c.customerId, c.companyName));
            c.orders.forEach(o -> print("     Order %s: %s\"", o.orderId, o.orderDate));
        });
    }

    public static void Linq5() {
        var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var shortDigits = IntStream.range(0, digits.length)
                .mapToObj(index -> new Object() {
                    int Index = index;
                    String Digit = digits[index];
                })
                .filter(o -> o.Digit.length() < o.Index);

        print("Short digits:");
        shortDigits.forEach(o -> print("The word %s is shorter than its value", o.Digit));
    }

}
