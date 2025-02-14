import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyClass1 {


    public static void main(String[] args) {
        // Пронумеровать элементы списка - каждому задать его порядковый номер, начиная с 1.
        // Пример:
        // [] --> []
        // ["a", "b", "c"] --> ["1: a", "2: b", "3: c"]


        List<String> inputList = Arrays.asList("a", "b", "c");
//        Collections.reverse(inputList);
//        inputList = inputList.stream()
//                .sorted(Comparator.reverseOrder())
//                .toList();
//        System.out.println("inputList = " + inputList);
        List<String> numberedList = numberElements(inputList);
        System.out.println(numberedList); // Вывод: [1: a, 2: b, 3: c]

//        IntStream.rangeClosed(1, inputList.size())
//                .mapToObj(i -> i +": " + inputList.get(i-1))
//                        .forEach(System.out::println);


//        Character[] ch = {'a', 'b', 'c'};

//        Stream<Character> stream = Arrays.stream(ch);
//
//        stream
//                .map(ch -> "1: " + ch)
//                .sorted(Comparator.comparingInt())
//                .forEach(System.out::println);


//        int i = 1;
//        while ( i <= ch.length) {
//            System.out.println(i++ + ": " + ch[i-2]);
//        }
//                .map(character -> character.charValue())
    }

    public static List<String> numberElements(List<String> inputList) {
        return IntStream.rangeClosed(1, inputList.size())
                .mapToObj(i -> i + ": " + inputList.get(i - 1))
                .collect(Collectors.toList());
    }

}
