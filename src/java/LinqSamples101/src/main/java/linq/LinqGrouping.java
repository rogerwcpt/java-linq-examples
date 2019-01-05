package linq;

import support.Data;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LinqGrouping extends LinqBase {

    public static void Linq40() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var numberGroups = Arrays.stream(numbers).boxed()
                .collect(Collectors.groupingBy(n -> n % 5, Collectors.toList()));

        for (var key:numberGroups.keySet()) {
            print("Numbers with a remainder of %d when divided by 5:", key);
            numberGroups.get(key).forEach(System.out::println);
        }
    }

    public static void Linq41() {
        var words = new String [] { "blueberry", "chimpanzee", "abacus", "banana", "apple", "cheese" };

        var wordGroups = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.toList()));

        for (var key:wordGroups.keySet()) {
            print("Words that start with the letter '%s':", key);
            wordGroups.get(key).forEach(System.out::println);
        }
    }

    public static void Linq42() {
        var products = Data.getProductList();

        var productCategories = products.stream()
                .collect(Collectors.groupingBy(p -> p.category, Collectors.toList()));

        for (var key:productCategories.keySet()) {
            print("Products in the category '%s':" , key);
            productCategories.get(key).forEach(System.out::println);
        }
    }

    public  static void Linq43() {
        print("TODO");
    }
}
