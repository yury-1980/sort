package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class f {
}


public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Predicate: фильтруем чётные числа
        Predicate<Integer> isEven = n -> n % 2 == 0;
        // Function: возводим число в квадрат
        Function<Integer, Integer> square = n -> n * n;
        // Consumer: печатаем числа
        Consumer<Integer> print = n -> System.out.print(n + " ");
        // Supplier: создаём случайное число
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);
        // UnaryOperator: умножаем на 2
        UnaryOperator<Integer> multiplyByTwo = n -> n * 2;
        // BinaryOperator: сумма двух чисел
        BinaryOperator<Integer> sum = Integer::sum;
        // Применение всех функций:
        numbers.stream()
                .filter(isEven)              // Predicate: фильтрация
                .map(square)                 // Function: возведение в квадрат
                .map(multiplyByTwo)          // UnaryOperator: умножаем на 2
                .forEach(print);             // Consumer: вывод
        System.out.println("\nСлучайное число: " + randomSupplier.get());
        // BinaryOperator: сумма всех элементов
        int total = numbers.stream().reduce(0, sum);
        System.out.println("Сумма всех чисел: " + total);
    }
}
