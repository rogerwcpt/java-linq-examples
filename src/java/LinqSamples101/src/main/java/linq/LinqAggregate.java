package linq;

import support.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class LinqAggregate extends LinqBase {

    public static void Linq73() {
        var primeFactorsOf300 = new int [] { 2, 2, 3, 5, 5 };

        var uniqueFactors = Arrays.stream(primeFactorsOf300).distinct().count();

        print("There are %d unique factors of 300.",  uniqueFactors);
    }

    public static void Linq74() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var oddNumbers = Arrays.stream(numbers)
                .filter(n -> n % 2 == 1)
                .count();

        print("There are %d odd numbers in the list.", oddNumbers);
    }

    public static void Linq75() {
        var customers = Data.getCustomerList();


        var orderCounts = customers.stream()
                .map(c -> new Object() {
                    String customerId = c.customerId;
                    int orderCount = c.orders != null ? c.orders.size() : 0;
                })
                .collect(Collectors.toList());

        for (var o : orderCounts) {
            print("{CustomerId: %s, OrderCount: %d}", o.customerId, o.orderCount);
        }
    }

    public static void Linq77() {
        var products = Data.getProductList();

        var categoryCounts = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,  Collectors.counting()));

        System.out.println((categoryCounts));
    }

    public static void Linq78() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var numSum = Arrays.stream(numbers).sum();

        print("The sum of the numbers is %d." , numSum);
    }

    public static void Linq79() {
        var  words = new String[] { "cherry", "apple", "blueberry" };

        var totalChars = Arrays.stream(words)
                .mapToInt(w -> w.length())
                .sum();

        print("There are a total of %d characters in these words.", totalChars);
    }

    public static void Linq80() {
        var products = Data.getProductList();

        var categoryStockCounts = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.summingInt(p -> p.unitsInStock)));

        System.out.println((categoryStockCounts));
    }

    public static void Linq81() {
        var numbers = new int[]{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var minNum = Arrays.stream(numbers).min().getAsInt();

        print("The minimum number is %d", minNum);
    }

    public static void Linq82() {
        var words = new String[] { "cherry", "apple", "blueberry" };

        var shortestWord = Arrays.stream(words)
                .mapToInt(w -> w.length())
                .min()
                .getAsInt();

        print("The shortest word is %d characters long.", shortestWord);
    }

    public static void Linq83() {
        var products = Data.getProductList();

        var groupedByCategoryPrice = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.minBy(Comparator.comparing(p -> p.unitPrice))));

        for(var key: groupedByCategoryPrice.keySet()) {
            var unitPrice = groupedByCategoryPrice.get(key).get().unitPrice;
            print("{Category: %s, CheapestPrice %.2f}", key, unitPrice);
        }
    }

    public static void Linq84() {
        print("TODO");
    }

    public static void Linq85() {
        var numbers = new int []{ 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var maxNum = Arrays.stream(numbers).max().getAsInt();

        print("The maximum number is %d.", maxNum);
    }

    public static void Linq86() {
        var words = new String[] { "cherry", "apple", "blueberry" };

        var shortestWord = Arrays.stream(words)
                .mapToInt(w -> w.length())
                .max()
                .getAsInt();

        print("The longest word is %d characters long.", shortestWord);
    }

    public static void Linq87() {
        var products = Data.getProductList();

        var groupedByCategoryPrice = products.stream()
                .collect(Collectors.groupingBy(p -> p.category,
                        Collectors.maxBy(Comparator.comparing(p -> p.unitPrice))));

        for(var key: groupedByCategoryPrice.keySet()) {
            var unitPrice = groupedByCategoryPrice.get(key).get().unitPrice;
            print("{Category: %s, MostExpensive %.2f}", key, unitPrice);
        }
    }

    public static void Linq88() {
        print("TODO");
    }

    public static void Linq89() {
        var numbers = new int[] { 5, 4, 1, 3, 9, 8, 6, 7, 2, 0 };

        var averageNum = Arrays.stream(numbers).average().getAsDouble();

        print("The averages number is %.2f." , averageNum);
    }

    public static void Linq90() {
        var words = new String[] { "cherry", "apple", "blueberry" };

        var averageWordLength = Arrays.stream(words)
                .mapToInt(w -> w.length())
                .average()
                .getAsDouble();

        print("The shortest word is %f characters long.", averageWordLength);
    }

    public static void Linq91() {
        print("TODO");
    }

    public static void Linq92() {
        var doubles = new double[] { 1.7, 2.3, 1.9, 4.1, 2.9 };

        var product = Arrays.stream(doubles)
                .reduce((runningTotal, nextFactor) -> runningTotal * nextFactor)
                .getAsDouble();

        print("Total product of all numbers: %f" , product);
    }

    public static void Linq93() {
        int startBalance = 100;

        var attemptedWithdrawals = new int[]{ 20, 10, 40, 50, 10, 70, 30 };

        var endBalance = Arrays.stream(attemptedWithdrawals)
                .reduce(startBalance,
                        (balance, nextWithdrawal) ->
                                (nextWithdrawal <= balance) ? (balance - nextWithdrawal) : balance);

        print("Ending balance: %d",  endBalance);
    }

}
