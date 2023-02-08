package linq;

import models.Customer;
import models.Order;
import support.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static support.Data.getCustomerList;

public class LinqProjections extends LinqBase {

    public static void Linq6() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var lownumbers = Arrays.stream(numbers)
                .boxed()
                .map(n -> n +1);

        print("Numbers +1:");
        lownumbers.forEach(System.out::println);
    }

    public static void  Linq7() {
        var products = Data.getProductList();

        var productNames = products.stream()
                .map(p -> p.productName);

        print("Product Names:");
        productNames.forEach(System.out::println);
    }

    public static void Linq8() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        var strings = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var stringNums = Arrays.stream(numbers)
                .boxed()
                .map(n -> strings[n]);

        print("Number strings:");
        stringNums.forEach(System.out::println);
    }

    public static void Linq9() {
        var words = new String[] { "aPPLE", "BlUeBeRrY", "cHeRry" };

        var upperLowerWords = Arrays.stream(words)
                .map(w -> new Object() {
                    String upper = w.toUpperCase();
                    String lower = w.toLowerCase();
                });

        upperLowerWords.forEach(word -> print("Uppercase: %s, Lowercase: %s", word.upper, word.lower));
    }

    public static void Linq10() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        var strings = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var digitOddEvens = Arrays.stream(numbers)
                .boxed()
                .map(n -> new Object() {
                    String Digit = strings[n];
                    Boolean Even = n % 2 == 0;
                });

        digitOddEvens.forEach(o -> print("The digit %s is %s", o.Digit, o.Even ? "even" : "odd"));
    }

    public static void Linq11() {
        var products = Data.getProductList();

        var productInfos = products.stream()
                .map(p -> new Object() {
                    String ProductName = p.productName;
                    String Category = p.category;
                    Double Price = p.unitPrice;
                });

        print("Product Info:");
        productInfos.forEach(product -> print("%s is in the category %s and costs %.2f per unit.", product.ProductName, product.Category, product.Price));
    }

    public static void  Linq12() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var numsInPlace = IntStream.range(0, numbers.length)
                .mapToObj(index -> new Object() {
                    int Num = numbers[index];
                    Boolean InPlace = numbers[index] == index;
                });

        print("Number: In-place?");
        numsInPlace.forEach(n ->  print("%d: %s" , n.Num, n.InPlace));
    }

    public static void Linq13() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };
        var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var lowNums = Arrays.stream(numbers)
                .boxed()
                .filter(n -> n < 5)
                .map(n -> digits[n]);

        print("Numbers < 5:");
        lowNums.forEach(System.out::println);
    }

    public static void Linq14() {
        var numbersA = new Integer[] { 0, 2, 4, 5, 6, 8, 9 };
        var numbersB = new Integer[]{ 1, 3, 5, 7, 8 };
        System.out.println("Pairs where a < b:");
        Arrays.stream(numbersA)
                .flatMap(a -> Arrays.stream(numbersB).map(b -> new Object(){
                    Integer numberA = a; Integer numberB = b;
                }))
                .filter(pair -> pair.numberA < pair.numberB)
                .forEach(pair -> System.out.println(pair.numberA + " is less than "+ pair.numberB));
    }

    public static void Linq15() {
        List<Customer> customers = Data.getCustomerList();
        customers.stream()
                .filter(c -> c.orders != null && c.orders.size() > 0)
                .flatMap(c -> c.orders.stream().map(o -> new Object(){
                     final String customerID = c.customerId;
                     final Integer orderId = o.orderId;
                     final Double total = o.total;
                 }))
                .filter(o -> o.total < 500.00)
                .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                                                 ", OrderId: " + o.orderId +
                                                 ", Total: " + o.total));
    }

    public static void Linq16() {
        List<Customer> customers = Data.getCustomerList();
        Date comparisonDate = new GregorianCalendar(1998, Calendar.JANUARY, 1).getTime();
        customers.stream()
                .filter(c -> c.orders != null && c.orders.size() > 0)
                .flatMap(c -> c.orders.stream().map(o -> new Object(){
                    final String customerID = c.customerId;
                    final Integer orderId = o.orderId;
                    final Date orderDate = o.orderDate;
                }))
                .filter(o -> o.orderDate.compareTo(comparisonDate) >= 0 )
                .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                        ", OrderId: " + o.orderId +
                        ", OrderDate: " + o.orderDate));
    }

    public static void Linq17() {
        List<Customer> customers = Data.getCustomerList();
        customers.stream()
                .filter(c -> c.orders != null && c.orders.size() > 0)
                .flatMap(c -> c.orders.stream().map(o -> new Object(){
                    final String customerID = c.customerId;
                    final Integer orderId = o.orderId;
                    final Double total = o.total;
                }))
                .filter(o -> o.total > 2000 )
                .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                        ", OrderId: " + o.orderId +
                        ", Total: " + o.total));
    }

    public static void Linq18() {
        List<Customer> customers = Data.getCustomerList();
        var cutoffDate = new GregorianCalendar(1997, 1, 1).getTime();
        customers.stream()
                .filter(c -> c.orders != null && c.orders.size() > 0)
                .filter(c -> Objects.equals(c.region, "WA"))
                .flatMap(c -> c.orders.stream().map(o -> new Object(){
                    final Customer customer = c;
                    final Order order = o;
                }))
                .filter(o -> o.order.orderDate.compareTo(cutoffDate) >= 0 )
                .map(o -> new Object(){
                    final String customerID = o.customer.customerId;
                    final Integer orderId = o.order.orderId;
                    final String region = o.customer.region;
                })
                .forEach(o -> System.out.println("{CustomerId: " + o.customerID +
                        ", OrderId: " + o.orderId +
                        ", Region: " + o.region));
    }

    public static void Linq19() {
        var customers = new ArrayList<>(Data.getCustomerList());
        IntStream.range(0, customers.size())
                .filter(i -> customers.get(i).orders != null)
                .mapToObj(i -> customers.get(i).orders.stream()
                            .map(o -> new Object(){
                                    final int index = i +1;
                                    final Integer orderID = o.orderId;
                }))
                .flatMap(s -> s)
                .forEach(o -> System.out.println("Customer " + o.index +
                                                 " has an order with OrderID " + o.orderID));
    }


}
