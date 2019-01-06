package linq;

import support.Data;

import java.util.Arrays;

public class LinqElements extends LinqBase {

    public static void Linq58() {
        var products = Data.getProductList();

        var produdct12 = products.stream()
                            .filter(p -> p.productId == 12)
                            .findFirst();

        System.out.println(produdct12);
    }

    public static void Linq59() {
        var strings = new String[]{ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

        var startsWithO = Arrays.stream(strings)
                .filter(s -> s.startsWith("o"))
                .findFirst();

        print("A string starting with 'o': %s", startsWithO);
    }

    public static void Linq61() {
        var numbers = new int[0];

        var firstNumOrdDefault = Arrays.stream(numbers).boxed()
                .findFirst()
                .orElse(0);

        System.out.println(firstNumOrdDefault);
    }

    public static void Linq62() {
        var products = Data.getProductList();

        var product789 = products.stream()
                .filter(p -> p.productId == 789)
                .findFirst()
                .orElse(null);

        print("Product 789 exists: %s" , product789 != null);
    }

    public static void Linq64() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var secondNumberGreaterThan5 = Arrays.stream(numbers).boxed()
                .filter(n -> n > 5)
                .toArray()
                [1];

        print("Second number > 5: %d" , secondNumberGreaterThan5);
    }


}
