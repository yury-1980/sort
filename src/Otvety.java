import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Otvety {

    public static void main(String[] args) {
        String str = "кобан, уп-ал и лапу на бок";

        int l = 0;
        int r = str.length() - 1;
        int i = 0;

        while (l < r) {
            if (!Character.isLetterOrDigit(str.charAt(l))) {
                l++;
                continue;
            }

            if (!Character.isLetterOrDigit(str.charAt(r))) {
                r--;
                i--;
                continue;
            }

            if (str.charAt(l) != str.charAt(r)) {
                System.out.println("1. Не является");
                break;
            } else {
                l++;
                r--;
            }
        }
        if (i != 0) {
            System.out.println("1. Является");
        }

        int[] mas1 = {1, 2, 3, 5, 4};
        int[] mas2 = {6, 7, 8, 9, 10};
        List<Integer> list1 = Arrays.stream(mas1).boxed().toList();
        List<Integer> list2 = Arrays.stream(mas2).boxed().toList();
        Stream.concat(Arrays.stream(mas1).boxed(), Arrays.stream(mas2).boxed()).forEach(a -> System.out.print(a + ","));

        Stream.of(list1, list2)
                .flatMap(integers -> integers.stream())
                .sorted(Integer::compareTo)
                .forEach(System.out::print);
        System.out.println();
        int[] mas = {1, 2, 1, 3, 5, 4, 4, 7};

        for (int j = 0; j < mas.length; j++) {
            int t = 0;
            for (int k = 0; k < mas.length; k++) {
                if (mas[k] == mas[j] && k != j) {
                    t++;
                    break;
                }
            }
            if (t == 0) {
                System.out.print(mas[j]);
            }
        }
        System.out.println();
        IntStream.rangeClosed(1,10)
                .filter(a -> a % 2 == 0)
                .forEach(System.out::print);

        String[] mas11 = {"Apple", "Banana", "Cherry"};
        String[] mas21 = {"Date", "Elderberry", "Fig"};
        String[] mas31 = {"Grape", "Honeydew", "Kiwi"};

        // Объединяем три массива в один поток
        Stream.of(mas11, mas21, mas31)
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        // Выводим элементы потока
//        combinedStream.forEach(System.out::println);
    }
}
