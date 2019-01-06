package linq;

import java.util.*;
import java.util.stream.Collectors;

public class LinqConversion extends LinqBase {

    public static void Linq54() {
        var list = new double[] { 1.7, 2.3, 1.9, 4.1, 2.9 };

        var sortedDoubles = Arrays.stream(list).boxed()
                .sorted(Comparator.reverseOrder())
                .toArray();

        print("Every other double from highest to lowest:");
        for (int i = 0; i < sortedDoubles.length; i += 2) {
            System.out.println(sortedDoubles[i]);
        }
    }

    public static void Linq55() {
        var words = new String[] { "cherry", "apple", "blueberry" };

        var wordList = Arrays.stream(words)
                .sorted()
                .collect(Collectors.toList());

        print("The sorted word list:");
        wordList.forEach(System.out::println);
    }

    public static void Linq56() {

        class StudentScore {
            public String name;
            public int score;

            public StudentScore(String name, int score) {
                this.name = name;
                this.score = score;
            }
        }

        var scoreRecords =new ArrayList<StudentScore>();
        scoreRecords.add(new StudentScore("Alice", 50));
        scoreRecords.add(new StudentScore("Bob", 40));
        scoreRecords.add(new StudentScore("Cathy", 45));

        var scoreRecordsMap= scoreRecords.stream()
                .collect(Collectors.toMap(s -> s.name, s -> s.score));

        print("Bob's score: %s", scoreRecordsMap.get("Bob"));
    }

    public static void Linq57() {
        var numbers = new Object[]{ null, 1.0, "two", 3, "four", 5, "six", 7.0 };

        var doubles = Arrays.stream(numbers)
                .filter(Double.class::isInstance);

        doubles.forEach(System.out::println);
    }

}
