package linq;

public class LinqBase {

    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

}
