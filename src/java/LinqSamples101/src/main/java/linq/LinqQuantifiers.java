package linq;

import java.util.Arrays;

public class LinqQuantifiers extends LinqBase {

    public static void Linq67() {
        var words = new String []{ "believe", "relief", "receipt", "field" };

        var iAfterE = Arrays.stream(words)
                .anyMatch(w -> w.contains("ei"));

        print("There is a word that contains in the list that contains 'ei': %s",  iAfterE);
    }

    public static void Linq69() {
        print("TODO");
    }

    public static void Linq70() {
        var numbers = new int[] { 1, 11, 3, 19, 41, 65, 19 };

        var onlyOdd = Arrays.stream(numbers)
                .allMatch(n -> n % 2 == 1);

        print("The list contains only odd numbers: %s",  onlyOdd);
    }

    public static void Linq71() {
        print("TODO");
    }



}
