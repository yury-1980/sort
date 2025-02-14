import stream.Worker;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class SreamApi {

    public static void main(String[] args) {

        List<Worker> workers = List.of(new Worker("Aleksei", 31, 400, "IT"),
                new Worker("Sergei", 24, 500, "HR"),
                new Worker("Elena", 25, 500, "HR"),
                new Worker("Elena", 26, 400, "IT"));

// 1. Группировка списка рабочих по их должности (деление на списки).
        Map<String, List<Worker>> task1 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition));

        // 2. Группировка списка рабочих по их должности (деление на множества).
        Map<String, Set<Worker>> task2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        // 3. Подсчёт количества рабочих, занимаемых конкретную должность.
        Map<String, Long> task3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        // 4. Группировка списка рабочих по их должности, при этом нас интересуют только имена.
        Map<String, Set<String>> task4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(Worker::getName, Collectors.toSet())));

        // 5. Расчёт средней зарплаты для данной должности.
        Map<String, Double> task5 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.averagingInt(Worker::getSalary)));
        // 6. Увеличить возраст на 2, к имени добавить 1, вывести всё.
        workers.stream()
                .map(a -> {
                    a.setAge(a.getAge() * 2);
                    a.setName(a.getName() + 1);
                    return a;
                })
                .forEach(System.out::println);
        System.out.println();
        // 7. Сортировка по возрасту
        workers.stream()
                .sorted(Comparator.comparingInt(Worker::getAge))
                .forEach(a -> System.out.println("Сортировка по возрасту " + a));

        // 8. Сортировка по нескольким свойствам: age, name, salary.
        System.out.println();
        workers.stream()
                .sorted(Comparator.comparingInt(Worker::getAge)
                        .thenComparing(Worker::getName)
                        .thenComparing(Worker::getSalary))
                .forEach(System.out::println);
        // 9. Вычислить средний возраст.
        Double avg = workers.stream()
//                .mapToInt(stream.Worker::getAge)
//                .average();
                .collect(Collectors.averagingInt(Worker::getAge));
        // 10. Вычисление максимальной длины имени.
        System.out.println("Максимальная длина имени = " + workers.stream()
//                .map(a -> a.getName().length())
//                .max(Integer::compareTo).get());
                .mapToInt(a -> a.getName().length())
                .max().orElseGet(()->  5));
        // 11. Проверить, что все старше 6
        boolean b1 = workers.stream()
                .allMatch(a -> a.getAge() > 6);
        System.out.println("У всех возраст больше 6 = " + b1);

        // 12. Проверить, есть ли кто-то с именем начинающимся на А
        boolean b2 = workers.stream()
                .anyMatch(a -> a.getName().startsWith("A"));
        System.out.println("Есть ли кто-то с именем начинающимся на А = " + b2);

        // 13. Подсчитать кол-во разных имён.
        long count = workers.stream()
                .map(Worker::getName)
                .distinct()
                .count();
        System.out.println("кол-во разных имён = " + count);

        // 14. Есть 2 списка, объединить, отфильтровать уникальные значения и вывести результат.

        List<Integer> list_1 = Arrays.asList(1, 3, 4, 2, 5, 6, 7);
        List<Integer> list_2 = Arrays.asList(3, 4, 5, 6, 7, 8);

        Stream.concat(list_1.stream(),list_2.stream())
                        .forEach(System.out::println);

        Stream.of(list_1, list_2).flatMap(integers -> integers.stream()).distinct().forEach(System.out::print);
        System.out.println();
        Stream.concat(list_1.stream(), list_2.stream()).distinct().forEach(a -> System.out.println("Сложенный массив: " + a));
        System.out.println();

        // 15. Сумма целых чисел.
        System.out.println("sum = " + list_1.stream()
//                .reduce((a, b) -> a + b).ifPresent(System.out::println);
//                        .reduce(0,Integer::sum)
                .mapToInt(a -> a)
                .sum());
        // 16. Найти первое чётное число

        list_1.stream()
                .filter(a -> a % 2 == 0)
                .limit(1)
                .forEach(System.out::println);
        // 17. Преобразуйте список в одну строку, разделяя эл-ты запятой.
        List<String> words = Arrays.asList("яблоко", "банан", "груша");
        words.stream()
                .collect(joining(","));

        System.out.println("В 1 сторку = " + words.stream()
                .collect(joining(",")));


        // 18. Отсортируйте список строк по их длине и выведите.
        List<String> words1 = Arrays.asList("яблоко", "банан", "грушаaaa");
        words1.stream()
//                .sorted((o1, o2) -> o1.length() - o2.length())
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

        // 19. Получить список уникальных букв из списка слов.
        List<String> words2
                = Arrays.asList("яблоко", "банан", "груша");
        words2.stream()
                .flatMapToInt(a -> a.chars())
                .mapToObj(a1 -> (char) a1)
                .distinct()
                .forEach(System.out::print);

        // Дано не отрицательное целое число х, вернуть квадратный корень из х, округлённый до ближайшего целого числа. Возвращаемое целое число
        // также должно быть не отрицательным. Вход = 4 Ответ = 2.
        System.out.println("-------------------------");
        long abs = Math.abs(Math.round(Math.sqrt(4)));
        double a = (0.5 * 3);
        int b = (int) (0.5 * 3);
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println("abs = " + abs);
        System.out.println("otvet: " + sqrt(121));

        int n = 10; // Пример: находим 10-е число Фибоначчи
        System.out.println("Число Фибоначчи F(" + n + ") = " + fibonacci(n));

//--------------------------------------------------------------------------------------
        Map<String, Double> task25 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.averagingInt(Worker::getSalary)));
        Stream.of(list_1, list_2)
                .flatMap(a1 -> a1.stream())
                .distinct()
                .map(r -> r % 2 == 0 ? 0 : r)
                .mapToInt(r -> r * 2)
                .forEach(r -> System.out.print(" " + r));
        System.out.println();
        System.out.println("SUM " + Stream.of(list_1,list_2)
                .flatMap(s -> s.stream())
                .filter(s -> s % 2 == 0)
                .findFirst()
                .orElse(5));
        System.out.println(words.stream()
                .collect(joining()));
        List<String> words21
                = Arrays.asList("яблоко", "банан", "груша");
        words21.stream()
                .flatMapToInt(s->s.chars())
                .mapToObj(s->(char)s)
                .distinct()
                .forEach(System.out::print);

        int x1 = 121;
        int max = x1 / 2;
        int min = 1;

        while(min <= max){
            int avg1 = (max - min) / 2 + min;

            if(avg1 * avg1 > x1) {
                max = avg1 - 1;
            }else if(avg1 * avg1 < x1) {
                min = avg1 + 1;
            }else {
                System.out.println("avg1 = " + avg1);
                break;
            }
        }

// Сортировка
        int [] list5 = {1, 3, 4, 2, 5, 6, 7};
        for (int i = 0; i < list5.length - 1; i++){
            for (int j = 0; j < list5.length - i - 1; j++) {
                if (list5[j] < list5[j + 1]){
                    int y = list5[j];
                    list5[j]=list5[j + 1];
                    list5[j + 1] = y;
                }
            }
        }
        Arrays.stream(list5).boxed().forEach(a5-> System.out.println("Отсортированный " + a5));

    }

    public static int sqrt(int x) {
        int max = x / 2;
        int min = 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;

            if (mid * mid < x) {
                min = mid + 1;
            } else if (mid * mid > x) {
                max = mid - 1;
            } else {
                return mid;
            }
        }

        return max;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Базовые случаи
        }

        int a = 0, b = 1; // Начальные значения
        for (int i = 2; i <= n; i++) {
            int s = a + b; // Следующее число Фибоначчи
            a = b; // Сдвигаем значения
            b = s;
        }
        return b; // Возвращаем n-е число Фибоначчи
    }

}
