package practic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Increment {
    private static int counter1 = 0;
    private static int counter2 = 0;

    // Метод для инкрементации счетчиков с синхронизацией
    private static synchronized void incrementCounters() {
        counter1++;
        counter2++;
    }

    public static void main(String[] args) throws InterruptedException {
        int tasksCount = 100_000;
        CountDownLatch latch = new CountDownLatch(tasksCount);
        ExecutorService executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < tasksCount; i++) {
            executor.submit(() -> {
                incrementCounters(); // Вызываем синхронизированный метод
                latch.countDown();
            });
        }

        latch.await(); // Ждем завершения всех задач
        System.out.println(counter1);
        System.out.println(counter2);
        executor.shutdown();
    }
}
