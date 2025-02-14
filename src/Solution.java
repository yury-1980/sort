import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                shift(arr, i + 1);
                if (i != arr.length - 1) {
                    arr[i + 1] = 0;
                    i++;
                }
            }
        }
    }

    public static void shift(int[] arr, int index) {
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
    }

    public static void main(String[] args) {

        int[] mas = {1, 0, 2, 3, 0, 4, 5, 0};
// дублируем 0
//        for (int i = 0; i < mas.length; i++) {
//
//            if (mas[i] == 0) {
//
//                for (int j = mas.length - 2; j > i; j--) {
//                    mas[j + 1] = mas[j];
//                }
//                mas[i + 1] = 0;
//                i++;
//            }
//        }
//
//        for (int newMas : mas) {
//            System.out.println("newMas = " + newMas);
//        }

//        дублируем 0 через стрим
        List<Integer> list = List.of(1, 0, 2, 3, 0, 4, 5, 0);

        List<Integer> integerList = new ArrayList<>(list.stream()
                .flatMapToInt(n -> n == 0 ? IntStream.of(0, 0) : IntStream.of(n))
                .boxed()
                .toList());

        System.out.println();

        integerList.removeIf(integer -> integer == 0);

        List<String> list1 = new ArrayList<>(List.of("ф", "о", "ж", "а"));
//        list1.stream()
//                .filter(a->!a.equals("о"))
//                .toList();
        list1.removeIf(a -> a.equals("ф"));
        list1.forEach(System.out::print);
        System.out.println();

//

//        Arrays.stream(mas)
//                .flatMap(a -> a == 1 ? IntStream.of(1, 1) : IntStream.of(a))
//                .forEach(System.out::print);

        List<Integer> collect = Arrays.stream(mas)
                .flatMap(a -> a == 5 ? IntStream.of(5, 5) : IntStream.of(a))
                .boxed()
                .toList();


        for (Integer newMas : integerList) {

            System.out.print(newMas + ", ");
        }
    }
}