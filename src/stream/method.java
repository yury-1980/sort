package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class method {

    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4, 5).reduce(10, (acc, x) -> acc + x);
        System.out.println("sum = " + sum);
        //----------------------
        Stream<String> people1 = Stream.of("Tom", "Bob", "Sam");
        Stream<String> people2 = Stream.of("Alice", "Kate", "Sam");
        Stream<String> people3 = Stream.of("111", "222", "333");

        System.out.println(Stream.concat(people1, (Stream.concat(people2, people3)))
                .collect(Collectors.joining(", ")));

        //---------------------
        List<String> list1 = Arrays.asList("Apple", "Banana");
        List<String> list2 = Arrays.asList("Carrot", "Date");
        List<String> list3 = Arrays.asList("Eggplant", "Fig");

        // Объединение трёх потоков с использованием flatMap
        Stream<String> mergedStream = Stream.of(list1, list2, list3)
                .flatMap(stringList -> stringList.stream());

        // Вывод результата
        mergedStream.forEach(System.out::println);

        //---------------
        Stream.of(Stream.of(1, 2, 3), Stream.of(4, 5, 6))
                .flatMap(integerStream -> integerStream)
                .forEach(System.out::print);
        System.out.println();

        //-----------------
        AnanimusClass ananimusClass = new AnanimusClass() {
            public int a = 3;

            @Override
            public void method1() {
                System.out.println("Method1");
            }

            @Override
            public void method2() {
                System.out.println("Method2");
            }
        };

        ananimusClass.method1();
        ananimusClass.method2();

        //----------------------
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        list.parallelStream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
