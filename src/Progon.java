import java.util.*;

public class Progon {

    public static void main(String[] args) {

//        List<Integer> list =
        Arrays.stream(args)
                .map(Integer::parseInt)
                .sorted()
                .skip(1)
                .limit(1)
                .forEach(System.out::println);


        int[] arr = {3, 2, 9, 4, 4, 1, 2, 5, 7, 3, 1, 5, 2};  // 7, 9
        Double average = Arrays.stream(arr)
                .average().orElse(5.0);


        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            for (int y = 0; y < arr.length; y++) {

                if (arr[i] == arr[y] && i != y) {
                    a++;
                    break;
                }
            }
            if (a == 0)
                System.out.print(arr[i]);

        }
    }
}
