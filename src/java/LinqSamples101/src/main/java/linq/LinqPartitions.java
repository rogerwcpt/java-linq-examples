package linq;

import support.Data;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class LinqPartitions extends  LinqBase {

    public static void Linq20() {
        var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var first3Numbers = Arrays.stream(numbers)
                .limit(3);

        print("First 3 numbers:");
        first3Numbers.forEach(System.out::println);
    }

    public static void Linq21() {
        print("TODO");
    }

    public static void Linq22() {
        print("TODO");
    }

    public static void Linq23() {
        print("TODO");
    }

    public static void Linq24() {
        var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var firstNumbersLessThan6 = Arrays.stream(numbers)
                .boxed()
                .takeWhile(n -> n < 6);

        print("First numbers less than 6:");
        firstNumbersLessThan6.forEach(System.out::println);
    }

    public static void Linq25() {
        var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var firstSmallNumbers = IntStream.range(0, numbers.length)
                .mapToObj(index -> new Object() {
                    int Num = numbers[index];
                    int Index = index;
                }).takeWhile(x -> x.Num >= x.Index);

        print("First numbers not less than their position:");
        firstSmallNumbers.forEach(x -> print("%d", x.Num));
    }

    public static void Linq26() {
        var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var allButFirst3Numbers = Arrays.stream(numbers)
                .boxed()
                .dropWhile(n -> n % 3 != 0);

        print("All elements starting from first element divisible by 3:");
        allButFirst3Numbers.forEach(System.out::println);
    }

    public static void Linq27() {
        var numbers = new int[]{5, 4, 1, 3, 9, 8, 6, 7, 2, 0};

        var firstSmallNumbers = IntStream.range(0, numbers.length)
                .mapToObj(index -> new Object() {
                    int Num = numbers[index];
                    int Index = index;
                }).dropWhile(x -> x.Num >= x.Index);

        print("First numbers not less than their position:");
        firstSmallNumbers.forEach(x -> print("%d", x.Num));
    }
}



