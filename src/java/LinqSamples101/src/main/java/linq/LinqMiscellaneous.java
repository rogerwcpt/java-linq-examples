package linq;

import support.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinqMiscellaneous extends LinqBase {

    public static void Linq94() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var allNumbers = Stream
                .concat(
                        Arrays.stream(numbersA).boxed(),
                        Arrays.stream(numbersB).boxed());

        print("All numbers from both arrays:");
        allNumbers.forEach(System.out::println);
    }

    public static void Linq95() {
        var products = Data.getProductList();
        var customers = Data.getCustomerList();

        var customerNames = customers.stream().map(c -> c.companyName);
        var productNames = products.stream().map(p -> p.productName);


        var allNames = Stream.concat(customerNames, productNames);

        print("Customer and product names:");
        allNames.forEach(System.out::println);
    }

    public static void Linq96() {
        var wordsA = new String[] { "cherry", "apple", "blueberry" };
        var wordsB = new String[] { "cherry", "apple", "blueberry" };

        var equal = Arrays.equals(wordsA, wordsB);

        print("The sequences match: %s", equal);
    }

    public static void Linq97() {
        var wordsA = new String[] { "cherry", "apple", "blueberry" };
        var wordsB = new String[]  { "apple", "blueberry", "cherry" };

        var equal = Arrays.equals(wordsA, wordsB);

        print("The sequences match: %s", equal);
    }
}
