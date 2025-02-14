package practic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SkleitStrokiPoSimvolno {
    public static void main(String[] args) {
        String s1 = "abc12";
        String s2 = "pqr";
        int maxLength = Math.max(s1.length(),s2.length());
        int minLength = Math.min(s1.length(), s2.length());
        StringBuilder builder = new StringBuilder();

        String getMaxWord = s1.length() > s2.length() ? s1 : s2;

        for (int i = 0; i < minLength; i++) {
                builder.append(s1.charAt(i)).append(s2.charAt(i));
            }
        for (int i = minLength; i < maxLength; i++) {
            builder.append(getMaxWord.charAt(i));
        }

//        if (ls1 >= ls2) {
//
//            for (int i = 0; i < ls2; i++) {
//                builder.append(s1.charAt(i)).append(s2.charAt(i));
//
//            }
//                for (int i = ls2; i < ls1; i++) {
//                    builder.append(s1.charAt(i));
//            }
//        } else {
//            for (int i = 0; i < ls1; i++) {
//                builder.append(s1.charAt(i)).append(s2.charAt(i));
//
//            }
//            for (int i = ls1; i < ls2; i++) {
//                builder.append(s2.charAt(i));
//            }
//        }

        System.out.println("builder = " + builder);
        System.out.println("doubleStream() = ");
        doubleStream();

    }

    static void doubleStream() {
        Stream<Integer> stream = Stream.of(1, 3, 5, 4, 9);
        stream = stream.map(a -> a * 2);

//         stream.peek((it) -> System.out.println("f ->" + it));

        List<Integer> result1 = stream.collect(Collectors.toList());
//        List<Integer> result2 = stream.collect(Collectors.toList());

        System.out.println(result1);
//        System.out.println(result2);
    }
}
