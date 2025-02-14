import stream.Worker;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Practic2 {

    public static void main(String[] args) {

        List<Worker> workers = List.of(new Worker("Aleksei", 31, 400, "IT"),
                new Worker("Sergei", 24, 500, "HR"),
                new Worker("Elena", 26, 400, "IT"));

// 1. Группировка списка рабочих по их должности (деление на списки).
        Map<String, List<Worker>> task1 = workers.stream()
                .collect(Collectors.groupingBy(w -> w.getPosition()));

        // 2. Группировка списка рабочих по их должности (деление на множества).
        Map<String, Set<Worker>> task2 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.toSet()));

        // 3. Подсчёт количества рабочих, занимаемых конкретную должность.
        Map<String, Long> task3 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.counting()));

        // 4. Группировка списка рабочих по их должности, при этом нас интересуют только имена.
        Map<String, Set<String>> task4 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.mapping(w -> w.getName(), Collectors.toSet())));

        // 5. Расчёт средней зарплаты для данной должности.
        Map<String, Double> task5 = workers.stream()
                .collect(Collectors.groupingBy(Worker::getPosition, Collectors.averagingDouble(Worker::getSalary)));

        // Дано не отрицательное целое число х, вернуть квадратный корень из х, округлённый до ближайшего целого числа. Возвращаемое целое число
        // также должно быть не отрицательным. Вход = 4 Ответ = 2.
int x = 121;
        int min = 1;
        int max = x/2;
        int avg = 0;
        while(min <=max){
            avg = (max-min)/2 + min;
            int result = avg * avg;
            if (result < x){
                min = avg + 1;
            }else if (result>x){
                max = avg -1;
            }else {
                System.out.println("result = " + avg);
                break;
            }
        }

        int n = 10;
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b=sum;

        }
        System.out.println("sum = " + sum);

//        long abs = Math.abs(Math.round(Math.sqrt(4)));
//        double a = (0.5 * 3);
//        int b = (int) (0.5 * 3);
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//
//        System.out.println("abs = " + abs);
//        System.out.println("otvet: " + sqrt(121));
//
//        int n = 10; // Пример: находим 10-е число Фибоначчи
//        System.out.println("Число Фибоначчи F(" + n + ") = " + fibonacci(n));

    }

    public static int fib(int x) {
        int a = 0;
        int b = 1;
        int s = 0;
        for(int i = 2; i <= x; i++) {
            s= a +b;
            a = b;
            b=s;
        }

        return b;
    }

    public static int sqrt(int x) {
        int max = x;
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
            int temp = a + b; // Следующее число Фибоначчи
            a = b; // Сдвигаем значения
            b = temp;
        }
        return b; // Возвращаем n-е число Фибоначчи
    }

}
