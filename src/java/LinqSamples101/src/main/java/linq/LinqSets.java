package linq;

import support.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LinqSets extends LinqBase {

    public static void Linq46() {
        int[] factorsOf300 = { 2, 2, 3, 5, 5 };

        var uniqueFactors = Arrays.stream(factorsOf300).boxed()
                .distinct();

        print("Prime factors of 300:");
        uniqueFactors.forEach(System.out::println);
    }

    public static void Linq47() {
        var products = Data.getProductList();

        var productCategories = products.stream()
                .map(p -> p.category)
                .distinct();

        print("Category names:");
        productCategories.forEach(System.out::println);
    }

    public static void Linq48() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var uniqueNumbers = Stream
                .concat(
                        Arrays.stream(numbersA).boxed(),
                        Arrays.stream(numbersB).boxed())
                .distinct();

        print("Unique numbers from both arrays:");
        uniqueNumbers.forEach(System.out::println);
    }

    public static void Linq49() {
        var products = Data.getProductList();
        var customers = Data.getCustomerList();

        var productChars = products.stream().map(p -> p.productName.charAt(0));
        var customerChars = customers.stream().map(c -> c.companyName.charAt(0));

        var uniqueFirstChars = Stream
                .concat(productChars, customerChars)
                .distinct();

        print("Unique first letters from Product names and Customer names:");
        uniqueFirstChars.forEach(System.out::println);
    }


    public static void Linq50() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

         var uniqueNumbers = Arrays.stream(numbersA)
                 .filter(a -> Arrays.stream(numbersB).anyMatch(b -> b == a));

         print("Common numbers shared by both arrays:");
        uniqueNumbers.forEach(System.out::println);
    }

    public static void Linq51() {
        var products = Data.getProductList();
        var customers = Data.getCustomerList();

        var uniqueFirstChars = products.stream()
                .map(p -> p.productName.charAt(0))
                .filter(p -> customers.stream().map(c -> c.companyName.charAt(0)).anyMatch(c -> c == p))
                .distinct();

        print("Common first letters from Product names and Customer names:");
        uniqueFirstChars.forEach(System.out::println);
    }

    public static void Linq52() {
        int[] numbersA = { 0, 2, 4, 5, 6, 8, 9 };
        int[] numbersB = { 1, 3, 5, 7, 8 };

        var uniqueNumbers = Arrays.stream(numbersA)
                .filter(a -> Arrays.stream(numbersB).noneMatch(b -> b == a));

        print("Common numbers shared by both arrays:");
        uniqueNumbers.forEach(System.out::println);
    }

    public static void Linq53() {
        var products = Data.getProductList();
        var customers = Data.getCustomerList();

        var uniqueFirstChars = products.stream()
                .map(p -> p.productName.charAt(0))
                .filter(p -> customers.stream().map(c -> c.companyName.charAt(0)).noneMatch(c -> c == p))
                .distinct();

        print("Common first letters from Product names and Customer names:");
        uniqueFirstChars.forEach(System.out::println);
    }
}
