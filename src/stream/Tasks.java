package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks {

    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 7, 3, 2, 5, 2, 9, 0, 6, 4, 23, 15, 15);
        List<String> stringList = List.of("Яблоко", "банан", "банан", "груша", "Апельсин", "гранат", " ", "");
        int[] num = {1, 2, 7, 6, 3, 4, 5, 13, 12, 15, 10, 14, 11};
        List<User> users = List.of(
                new User(1, "Юрий-1"),
                new User(2, "Юрий-2"),
                new User(3, "Юрий-3"),
                new User(4, "Юрий-4"),
                new User(5, "Юрий-5")
        );
        List<Worker> workers = List.of(
                new Worker("Aleksei", 31, 400, "IT"),
                new Worker("Sergei", 40, 500, "HR"),
                new Worker("Elena", 50, 500, "HR"),
                new Worker("Elena", 60, 400, "IT"));

        System.out.println("task01(integerList) = " + task01(integerList));
        System.out.println("task02(stringList) = " + task02(stringList));
        System.out.println("task03(integerList) = " + task03(integerList));
        task04();
        System.out.println("task05(stringList) = " + task05(stringList));
        task06(integerList);
        task07(stringList);
        task08(stringList);
        task09(stringList);
        task10(num);
        task11(stringList);
        task12(stringList);
        task13(integerList);
        task14(stringList);
        task15(integerList);
        task16(users);
        task17(stringList);
        task18();
        task19(workers);
        task20(integerList);
    }

    // 🔹 Для экспертов:

    /**
     * Найти второй по величине элемент в списке:
     * Дано: список целых чисел.
     * Задача: найти второй по величине элемент (без сортировки списка).
     */
    private static void task20(List<Integer> integerList) {
        integerList.stream()
                .sorted()
                .skip(1L)
                .limit(1L)
                .forEach(System.out::println);

    }

    /**
     * Подсчитать сумму зарплат сотрудников старше 30 лет:
     * Дано: список объектов Employee с полями age и salary.
     * Задача: посчитать сумму зарплат только тех сотрудников, которым больше 30.
     */
    private static void task19(List<Worker> workers) {
        System.out.println(workers.stream()
                .filter(worker -> worker.getAge() > 30)
                .collect(Collectors.summingInt(value -> value.getSalary())));
//                .mapToInt(Worker::getSalary)
//                .sum());
    }

    /**
     * Сгруппировать числа по диапазонам (например, 0-10, 11-20 и т.д.):
     * Дано: список целых чисел.
     * Задача: сгруппировать их в Map, где ключ – это диапазон, а значение – список чисел из этого диапазона.
     */
    private static void task18() {
        int[] array = IntStream.rangeClosed(1, 30).toArray();
        int rangeSize = 10;

        Map<String, List<Integer>> mapCollector = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(num -> {
                            int numFirst = (num - 1) / rangeSize * rangeSize + 1;
                            int numLast = numFirst + rangeSize - 1;

                            return numFirst + "-" + numLast;
                        },
                        TreeMap::new, // Указываем тип карты
                        Collectors.toList() // Собираем значения в список
                ));
        for (Map.Entry<String, List<Integer>> entry : mapCollector.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    /**
     * Получить список уникальных букв из списка слов:
     * Дано: список строк.
     * Задача: получить список всех уникальных букв.
     */
    private static void task17(List<String> stringList) {
        stringList.stream()
                .flatMap(s -> Arrays.stream(s.split(""))) // Возвращаем массив string[] по буквам и делаем из него stream.
//                .flatMapToInt(s -> s.chars()) // Преобразуем строки в IntStream символов
//                .mapToObj(value -> (char)value) // Преобразуем int в char
                .distinct()
                .forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    /**
     * Преобразовать список пользователей в Map<id, имя>:
     * Дано: список объектов User с полями id и name.
     * Задача: создать Map, где ключ – это id, а значение – name.
     */
    private static void task16(List<User> users) {
        Map<Long, String> collect = users.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (Map.Entry<Long, String> entry : collect.entrySet()) {
            System.out.println("task16: " + entry.getKey() + " = " + entry.getValue());
        }
    }

    // 🔹 Продвинутый уровень:

    /**
     * Создать список квадратов всех чисел без повторений:
     * Дано: список чисел.
     * Задача: возвести все числа в квадрат и убрать дубликаты.
     */
    private static void task15(List<Integer> integerList) {
        System.out.println("task15: " + integerList.stream()
                .distinct()
                .map(integer -> integer * integer)
                .toList());
    }

    /**
     * Найти слово с максимальной длиной:
     * Дано: список строк.
     * Задача: найти слово с наибольшей длиной.
     */
    private static void task14(List<String> stringList) {
        System.out.println("task14: " + stringList.stream()
                .max(Comparator.comparingInt(String::length)).orElse(""));
    }

    /**
     * Разделить список чисел на чётные и нечётные:
     * Дано: список целых чисел.
     * Задача: использовать partitioningBy, чтобы разделить числа на чётные и нечётные.
     */
    private static void task13(List<Integer> integerList) {
        Map<Boolean, List<Integer>> collect = integerList.stream()
                .collect(Collectors.partitioningBy(integer -> integer % 2 == 0));
        for (Map.Entry<Boolean, List<Integer>> booleanListEntry : collect.entrySet()) {
            System.out.println("task13: " + booleanListEntry.getKey() + " = " + booleanListEntry.getValue());
        }
    }

    /**
     * Подсчитать частоту встречаемости каждого элемента:
     * Дано: список строк.
     * Задача: вернуть Map, где ключ – это строка, а значение – количество её появлений.
     */
    private static void task12(List<String> stringList) {
        Map<String, Long> map = stringList.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        for (Map.Entry<String, Long> s : map.entrySet()) {
            System.out.println("task12 = " + s.getKey() + " = " + s.getValue());
        }
    }

    /**
     * Группировать слова по первой букве:
     * Дано: список строк.
     * Задача: сгруппировать строки в Map, где ключ – это первая буква слова, а значение – список слов с этой буквой.
     */
    private static void task11(List<String> stringList) {
        Map<Character, List<String>> collect = stringList.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));

        for (Map.Entry<Character, List<String>> entry : collect.entrySet()) {
            System.out.println("task11 " + entry.getKey() + " = " + entry.getValue());
        }
    }


    // 🔹 Средний уровень:

    /**
     * Проверить, все ли элементы больше 5:
     * Дано: список чисел.
     * Задача: вернуть true, если все элементы больше 5.
     */
    private static void task10(int[] num) {
        System.out.println("task10 = " + Arrays.stream(num)
                .allMatch(value -> value > 5));
    }

    /**
     * Преобразовать список строк в список их длин:
     * Дано: список строк.
     * Задача: вернуть новый список, содержащий длины этих строк.
     */
    private static void task09(List<String> stringList) {
        System.out.println("task09 = " + stringList.stream()
                .mapToInt(value -> value.length())
                .boxed()
                .toList()
        );
    }

    /**
     * Отсортировать список строк по длине:
     * Дано: список строк.
     * Задача: отсортировать строки по возрастанию их длины.
     */
    private static void task08(List<String> stringList) {
        stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(s -> System.out.println("task08 = " + s));
    }

    /**
     * Конкатенировать все строки в одну через запятую:
     * Дано: список строк.
     * Задача: объединить все строки в одну строку с разделителем ", ".
     */
    private static void task07(List<String> stringList) {
        System.out.println("tasl07 = " + stringList.stream()
                .collect(Collectors.joining(", "))
        );
    }

    /**
     * Сумма всех чисел больше 10:
     * Дано: список чисел.
     * Задача: найти сумму всех чисел, которые больше 10.
     */
    private static void task06(List<Integer> integerList) {
        System.out.println("Summa > 10 = " + integerList.stream()
                .filter(value -> value > 10)
                .mapToInt(value -> value)
                .sum());
    }

    // 🔹 Базовые задачи:

    /**
     * Проверить, есть ли в списке строк хотя бы одно пустое значение:
     * Дано: список строк.
     * Задача: вернуть true, если есть хотя бы одна пустая строка.
     */
    private static boolean task05(List<String> stringList) {
        return stringList.stream()
                .anyMatch(String::isBlank);
    }

    /**
     * Найти максимальное и минимальное число:
     * Дано: список целых чисел.
     * Задача: найти максимальное и минимальное значение.
     */
    private static void task04() {
        IntSummaryStatistics intSumStat = new Random().ints(10, 0, 20)
                .summaryStatistics();
        System.out.println("intSumStat.getMax() = " + intSumStat.getMax());
        System.out.println("intSumStat.getMin() = " + intSumStat.getMin());
    }

    /**
     * Посчитать количество уникальных элементов:
     * Дано: список чисел с повторениями.
     * Задача: определить, сколько уникальных элементов в списке.
     */
    private static long task03(List<Integer> integerList) {
        return integerList.stream()
                .distinct()
                .peek(integer -> System.out.print(integer + ", "))
                .count();
    }

    /**
     * Преобразовать строки в верхний регистр:
     * Дано: список строк.
     * Задача: преобразовать все строки в верхний регистр.
     */
    private static List<String> task02(List<String> stringList) {
        return stringList.stream()
                .map(String::toUpperCase)
                .toList();
    }

    /**
     * Отфильтровать чётные числа:
     * Дано: список целых чисел.
     * Задача: оставить только чётные числа и собрать их в новый список.
     */
    private static List<Integer> task01(List<Integer> integerList) {
        return integerList.stream()
                .filter(integer -> integer % 2 == 0 && integer != 0)
                .toList();
    }
}
