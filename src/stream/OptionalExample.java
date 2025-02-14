package stream;

import java.util.List;
import java.util.Optional;

public class OptionalExample {

    public static String getDefaultValue() {
        System.out.println("Вызван getDefaultValue()");
        return "Default Value";
    }

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Present");

        // Используем orElse()
        String value1 = optional.orElse(getDefaultValue());
        System.out.println("Результат с orElse: " + value1);

        // Используем orElseGet()
        String value2 = optional.orElseGet(() -> getDefaultValue());
        System.out.println("Результат с orElseGet: " + value2);

        List<Integer> integerList = List.of(1, 7, 3, 2, 5, 2, 9, 0, 6, 4, 23, 15, 15);
        List<String> stringList = List.of("Яблоко", "банан", "банан", "груша", "Апельсин", "гранат", " ", "");
        List<User> users = List.of(
                new User(1, "Юрий-1"),
                new User(2, "Юрий-2"),
                new User(3, "Юрий-3"),
                new User(4, "Юрий-4"),
                new User(5, "Юрий-5")
        );

        task01(integerList);
        task02("");
        task03(Optional.of("Я есть!"));
        task04(Optional.ofNullable(5));
        task05(null);
        task06(users, 1);
        task07(Optional.ofNullable("я стока"), "я");
        task08(Optional.ofNullable("ssd"), Optional.ofNullable("ddr"));
        task09("Hello world!");
        task10(Optional.ofNullable(null));
    }

//    🔹 **Средний уровень:**

    /**
     * 10. **Преобразовать `Optional<Integer>` в `Optional<String>`:**
     * Дано: `Optional<Integer>`.
     * Задача: если значение присутствует, преобразовать его в строку.
     */
    private static void task10(Optional<Integer> optInt) {
        System.out.println("task10: " + optInt.map(String::valueOf));
    }

    /**
     * 9. **Удалить пробелы из строки, если она не `null`:**
     * Дано: строка, которая может быть `null`.
     * Задача: удалить все пробелы из строки, если она не `null`, иначе вернуть пустую строку.
     */
    private static void task09(String s) {
        Optional.ofNullable(s)
                .ifPresentOrElse(s1 -> System.out.println("task09: " + s1.replaceAll("\\s+", "")),
                        () -> System.out.println(""));
//        Optional.ofNullable(s)
//                .map(s1 -> s.replaceAll("\\s+", ""))  // Удаляем все пробелы
//                .orElse("");  // Если строка null, возвращаем пустую строку
    }

    /**
     * 8. **Объединить два `Optional`:**
     * Дано: два объекта `Optional<String>`.
     * Задача: если оба значения присутствуют, объединить их через пробел, иначе вернуть пустой `Optional`.
     */
    private static void task08(Optional<String> opt1, Optional<String> opt2) {
        System.out.println("task08: " + opt1.flatMap(s1 -> opt2.map(s2 -> s1 + " " + s2)));
    }

    /**
     * 7. **Проверить, начинается ли строка с определённой буквы:**
     * Дано: `Optional<String>`.
     * Задача: вернуть `true`, если строка начинается с буквы "A", иначе вернуть `false`.
     */
    private static void task07(Optional<String> stringOptional, String c) {
        System.out.println("task07 = " + stringOptional.map(s -> s.startsWith(c))
                .orElse(false));
    }

    /**
     * 6. **Найти пользователя по ID и вернуть его имя:**
     * Дано: список пользователей с полями `id` и `name`.
     * Задача: найти пользователя по `id` и вернуть его имя, используя `Optional`. Если пользователь не найден, вернуть "Unknown".
     */
    private static void task06(List<User> users, int id) {
        users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .ifPresentOrElse(user -> System.out.println("task06 = " + user), () -> System.out.println("Unknown"));

    }


    // 🔹 **Базовые задачи:**

    /**
     * 5. **Преобразовать строку в число, если строка не `null`:**
     * Дано: строка, содержащая число, или `null`.
     * Задача: преобразовать строку в `Integer`, если она не `null`, и вернуть `Optional<Integer>`.
     */
    private static void task05(String str) {
        Optional<Integer> optionalInteger = Optional.ofNullable(str)
                .map(Integer::valueOf);
        System.out.println("task05 = " + optionalInteger);

    }

    /**
     * 4. **Возвращать значение по умолчанию, если `Optional` пустой:**
     * Дано: `Optional<Integer>`.
     * Задача: вернуть значение, если оно есть, или `-1`, если значение отсутствует.
     */
    private static void task04(Optional<Integer> integerOptional) {
        System.out.println("task04 = " + integerOptional.orElse(-1));
    }

    /**
     * 3. **Проверить наличие значения и вывести его:**
     * Дано: объект типа `Optional<String>`.
     * Задача: если значение присутствует, вывести его на экран.
     */
    private static void task03(Optional<String> stringOptional) {
//        Optional<String> optional = Optional.of("Я есть!");
        stringOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Optional пуст!"));

    }

    /**
     * 2. **Получить длину строки, если она не `null`:**
     * Дано: строка, которая может быть `null`.
     * Задача: вернуть длину строки, если она не `null`, иначе вернуть `0`.
     */
    private static void task02(String str) {
        System.out.println("Task02 = " + Optional.ofNullable(str)
                .map(String::length)
                .orElse(0));
    }

    /**
     * 1. **Найти первое чётное число в списке:**
     * Дано: список целых чисел.
     * Задача: использовать `Optional`, чтобы вернуть первое чётное число, если оно есть.
     */
    private static void task01(List<Integer> integerList) {
        integerList.stream()
                .filter(integer -> integer % 2 == 0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}
