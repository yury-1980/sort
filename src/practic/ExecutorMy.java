package practic;

import java.util.concurrent.*;

public class ExecutorMy {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> task = () -> {
            Thread.sleep(3000); // Симуляция долгой задачи
            return "Результат задачи";
        };

        Future<String> future = executor.submit(task);

        try {
            // Ждём максимум 1 секунду
            String result = future.get(1, TimeUnit.SECONDS);
            System.out.println("Результат: " + result);
        } catch (TimeoutException e) {
            System.out.println("Превышено время ожидания результата!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();

        CompletableFuture<String> completableFuture = new CompletableFuture<String>();
    }
}
