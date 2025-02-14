import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class DocumentMy {

    public static void main(String[] args) {


        List<String> words = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry");

        Map<Character, List<String>> groupedByFirstLetter = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        System.out.println(groupedByFirstLetter);
    }



    public class GroupingAndCountingExample {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry");

            Map<Character, Long> countByFirstLetter = words.stream()
                    .collect(Collectors.groupingBy(
                            word -> word.charAt(0),   // Функция классификации (первая буква)
                            Collectors.counting()     // Подсчёт элементов в каждой группе
                    ));

            System.out.println(countByFirstLetter);
        }
    }




    public class GroupingByConcurrentExample {
        public static void main(String[] args) {
            List<String> words = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry");

            ConcurrentMap<Character, List<String>> groupedByFirstLetter = words.parallelStream()
                    .collect(Collectors.groupingByConcurrent(word -> word.charAt(0)));

            System.out.println(groupedByFirstLetter);
        }
    }












}
