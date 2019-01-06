package linq;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class LinqGeneration extends LinqBase {

    public static void Linq65() {
        var numbersEvenOdd = IntStream.range(100, 150)
                .mapToObj(n -> new Object() {
                   int Number = n;
                   String OddEven = (n % 2 == 0 ? "even" : "odd");
                })
                .collect(Collectors.toList());

        for (var num: numbersEvenOdd) {
            print("The number %d is %s", num.Number, num.OddEven);
        }
    }

    public static void Linq66() {
        var numbers  = new int[10];

        Arrays.fill(numbers, 7);

        for (int number : numbers) {
            System.out.println(number);
        }
    }

}
