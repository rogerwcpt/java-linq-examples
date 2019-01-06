package linq;

import support.Data;

import java.util.Arrays;
import java.util.stream.IntStream;

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
        print("TODO");
    }

    public static void Linq15() {
        print("TODO");
    }

    public static void Linq16() {
        print("TODO");
    }

    public static void Linq17() {
        print("TODO");
    }

    public static void Linq18() {
        print("TODO");
    }

    public static void Linq19() {
        print("TODO");
    }


}
