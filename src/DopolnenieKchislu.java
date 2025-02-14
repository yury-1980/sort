import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DopolnenieKchislu {
    public static void main(String[] args) {
        int i = 5;
        String collect = Integer.toBinaryString(i).chars()
                .map(a -> a - '0')
                .flatMap(a -> a == 0 ? IntStream.of(1) : IntStream.of(0))
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining());
        Integer.valueOf(collect, 2);

    }
}
