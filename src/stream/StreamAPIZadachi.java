package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIZadachi {

    public static void main(String[] args) {

        List<Worker> workers = List.of(new Worker("Aleksei", 31, 400, "IT"),
                new Worker("Sergei", 24, 500, "HR"),
                new Worker("Elena", 25, 500, "HR"),
                new Worker("Elena", 26, 400, "IT"));

        // 1. Группировка списка рабочих по их должности (деление на списки).
        Map<String, List<Worker>> map = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        // 2. Группировка списка рабочих по их должности (деление на множества).
        Map<String, Set<Worker>> map1 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        // 3. Подсчёт количества рабочих, занимаемых конкретную должность.
        Map<String, Long> map2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        // 4. Группировка списка рабочих по их должности, при этом нас интересуют только имена.
        Map<String, List<String>> map3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toList())));

        // 5. Расчёт средней зарплаты для данной должности.
        Map<String, Double> map4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.averagingDouble(Worker::getAge)));

        // 6. Увеличить возраст на 2, к имени добавить 1, вывести всё.
        workers.stream()
                .map(worker -> {
                    worker.setName(worker.getName() + 1);
                    worker.setAge(worker.getAge() * 2);
                    return worker;
                })
                .forEach(System.out::println);
        System.out.println();

        // 8. Сортировка по нескольким свойствам: age, name, salary.
        workers.stream()
                .sorted(Comparator.comparingInt(Worker::getAge)
                        .thenComparing(Worker::getName)
                        .thenComparingInt(Worker::getSalary))
                .forEach(System.out::println);

        System.out.println();

        // 9. Вычислить средний возраст.
        workers.stream()
                .mapToInt(Worker::getAge)
                .average()
                .ifPresent(System.out::println);

        System.out.println();

        // 10. Вычисление максимальной длины имени.
        Optional<Worker> max = workers.stream()
                .max(Comparator.comparingInt(Worker::getAge));
        System.out.println("max = " + max.get());

        // 11. Проверить, что все старше 6
        System.out.println(workers.stream()
                .allMatch(worker -> worker.getAge() > 6));

        // 12. Проверить, есть ли кто-то с именем начинающимся на А
        System.out.println(workers.stream()
                .anyMatch(worker -> worker.getName().startsWith("A")));


        // 13. Подсчитать кол-во разных имён.
        System.out.println("Кол-во разных имён - " + workers.stream()
                .map(Worker::getName)
                .distinct()
                .count());


        // 14. Есть 2 списка, объединить, отфильтровать уникальные значения и вывести результат.

        List<Integer> list_1 = Arrays.asList(1, 3, 4, 2, 5, 6, 7);
        List<Integer> list_2 = Arrays.asList(3, 4, 5, 6, 7, 8);

//        Set<Integer> numbers = new HashSet<>(list_1);
//        numbers.addAll(list_2);
//
//        for (Integer number : numbers) {
//            System.out.println("number = " + number);
//        }

        Stream.of(list_1, list_2).flatMap(integers -> integers.stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);


        // 15. Сумма целых чисел любого массива.
        System.out.println("Сумма чисел 2-го массива = " + list_2.stream()
                .mapToInt(value -> value)
                .sum());

        // 16. Найти первое чётное число из любого массива
        System.out.println(list_1.stream()
                .filter(integer -> integer % 2 == 0)
                .findFirst()
                .get());


        // 17. Преобразуйте список в одну строку, разделяя эл-ты запятой.
        List<String> words = Arrays.asList("яблоко", "банан", "груша");
        System.out.println(String.join(",", words));


        // 18. Отсортируйте список строк по их длине и выведите.
        List<String> words1 = Arrays.asList("яблоко", "банан", "грушаaaa");
        words1.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);


        // 19. Получить список уникальных букв из списка слов.
        List<String> words2
                = Arrays.asList("яблоко", "банан", "груша");
        words2.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .forEach(System.out::print);

    }
}

