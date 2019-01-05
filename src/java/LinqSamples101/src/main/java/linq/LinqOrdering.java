package linq;

import models.Product;
import support.Data;

import java.util.*;
import java.util.stream.Collectors;

public class LinqOrdering extends LinqBase {

    public static void Linq28() {
        var words = new String[] { "cherry", "apple", "blueberry" };

        var sortedWords = Arrays.stream(words)
                .sorted();

        print("The sorted list of words:");
        sortedWords.forEach(System.out::println);
    }

    public static void Linq29() {
        var words = new String[] { "cherry", "apple", "blueberry" };

        var sortedWords = Arrays.stream(words)
                .sorted(Comparator.comparing(s -> s.length()));

        print("The sorted list of words:");
        sortedWords.forEach(System.out::println);
    }

    public static void Linq30() {
        var products = Data.getProductList();

        var sortedProducts = products.stream()
                .sorted(Comparator.comparing(p -> p.productName));

        sortedProducts.forEach(System.out::println);
    }

    public static void Linq31() {
        var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = Arrays.stream(words).
                sorted(Comparator.comparing(s -> s, String.CASE_INSENSITIVE_ORDER));

        sortedWords.forEach(System.out::println);
    }

    public  static void Linq32() {
        var doubles = new Double[]{ 1.7, 2.3, 1.9, 4.1, 2.9 };

        var sortedDoubles = Arrays.stream(doubles)
                .sorted(Comparator.reverseOrder());

        print("The doubles from highest to lowest:");
        sortedDoubles.forEach((System.out::println));
    }

    public static void Linq33() {
        var products = Data.getProductList();

        var reverseSortedProducts = products.stream()
                .sorted(Comparator.comparing(p -> p.unitsInStock, Comparator.reverseOrder()));

        reverseSortedProducts.forEach(System.out::println);
    }

    public static void Linq34() {
        var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = Arrays.stream(words).
                sorted(Comparator.comparing(String::toString, String.CASE_INSENSITIVE_ORDER).reversed());

        sortedWords.forEach(System.out::println);
    }

    public static void Linq35() {
        var digits = new String[] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var sortedDigits = Arrays.stream(digits)
                .sorted(
                        Comparator
                            .comparing(String::length)
                            .thenComparing(s -> s)
                );

        print("Sorted digits:");
        sortedDigits.forEach(System.out::println);
    }

    public static void Linq36() {
        var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = Arrays.stream(words)
                .sorted(Comparator
                            .comparing(String::length)
                            .thenComparing(s -> s, String.CASE_INSENSITIVE_ORDER));

        sortedWords.forEach(System.out::println);
    }

    public static void Linq37() {
        var products = Data.getProductList();

        var sortedProducts = products.stream()
                .sorted(Comparator
                            .comparing(Product::getCategory)
                            .thenComparing(Product::getUnitPrice, Comparator.reverseOrder()));

        sortedProducts.forEach(System.out::println);
    }

    public static void Linq38() {
        var words = new String[] { "aPPLE", "AbAcUs", "bRaNcH", "BlUeBeRrY", "ClOvEr", "cHeRry" };

        var sortedWords = Arrays.stream(words)
                .sorted(Comparator
                        .comparing(String::length)
                        .thenComparing(s -> s, String.CASE_INSENSITIVE_ORDER.reversed()));

        sortedWords.forEach(System.out::println);
    }

    public static void Linq39() {
        var digits = new String [] { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var reversedIDigits = Arrays.stream(digits)
                .filter(s -> s.charAt(1) == 'i')
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator();

        print("A backwards list of the digits with a second character of 'i':");
        reversedIDigits.forEachRemaining(System.out::println);
    }

}
