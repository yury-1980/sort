import java.util.stream.IntStream;

public class Range {

    public static void main(String[] args) {
        System.out.println(IntStream.rangeClosed(1, 10)
                .reduce(10,(a,b) -> Integer.max(a,b)));

        System.out.println(2%3);
        String s = "df";
        char[] charArray = s.toCharArray();
    }
}
