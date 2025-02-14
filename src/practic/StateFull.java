package practic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class StateFull {

    public static void main(String[] args) {
        IntStream.of(1, 2, 1)
                .peek(System.out::println)
                .distinct()
                .forEach(s -> System.out.println(s + "s"));

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.execute(() -> {
            System.out.println("Task executed asynchronously");
        });

//        System.identityHashCode()
    }
}
