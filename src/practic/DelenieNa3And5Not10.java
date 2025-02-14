package practic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DelenieNa3And5Not10 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
//        for (int i = 0; i <= 1000; i++) {
//            System.out.print(i + " ");
//            if (i % 3 == 0 && (i % 5 != 0)) {
//                int y = i;
//                while (y % 10 > 0) {
//                    integerList.add(y % 10);
//                     y /= 10;
//                }
//
//                Integer reduce = integerList.stream()
//                        .reduce(Integer::sum)
//                        .orElse(5);
//                if (reduce < 10) {
//                    System.out.println(reduce);
//                }
//            }
//        }

        IntStream.range(0, 1000)
                .filter(a -> {
                    if (a % 3 == 0 && a % 5 != 0) {
                        int sum = 0;

                        while (a > 0) {
                            sum += (a % 10);
                            a /= 10;
                        }

                        return sum < 10;
                    } else {
                        return false;
                    }
                })
                .forEach(System.out::println);

        int a = 5;
        double b = 3.0;

        System.out.println("5/3 = " + (a / b));
    }
}
