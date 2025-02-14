import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PeresechenieMas {
// В мар, ключ - число, значение - кол-во.
    public static void main(String[] args) {
        int[] mas1 = {1, 2, 3, 2, 0};
        int[] mas2 = {5, 1, 2, 7, 3, 2, 2, 1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mas2.length; i++) {
            int col = 0;
            for (int j = 0; j < mas2.length; j++) {
                if (mas2[i] == mas2[j]) {
                    col++;
                }
            }
            map.put(mas2[i], col);
        }
        System.out.println("map = " + map);

        System.out.println("map1 = " + Arrays.stream(mas2)
                .boxed()
                .collect(Collectors.groupingBy(o -> o, Collectors.counting())));

        Stream.of(mas1, mas2)
                .flatMapToInt(a->Arrays.stream(a))
                .forEach(a -> System.out.print(a + " "));
    }
}
